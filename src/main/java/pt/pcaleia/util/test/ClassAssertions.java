package pt.pcaleia.util.test;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;


/**
 * @author Pedro Caleia
 */
public final class ClassAssertions {
	
	
	private static final String CLASS_IS_NOT_FINAL_MESSAGE = "Class %s is not final";
	private static final String CLASS_EXTENDS_ANOTHER_CLASS_MESSAGE = "Class %s extends another class other than Object";
	private static final String CLASS_IMPLEMENTS_SOME_INTERFACE_MESSAGE = "Class %s implements at least one interface";
	private static final String CLASS_MUST_HAVE_ONLY_ONE_PRIVATE_CONSTRUCTOR_WITH_NO_ARGS_MESSAGE = "Class %s must have only one constructor and it must be private "
			+ "with no arguments";
	private static final String ALL_METHODS_MUST_BE_STATIC = "Class %s methods must be all static";
	private static final String DEFAULT_CONSTRUCTOR_MUST_THROW_AE_BUT_NOTHING = "Class %s default constructor must throw an " + AssertionError.class.getName()
			+ " but nothing was thrown";
	private static final String DEFAULT_CONSTRUCTOR_MUST_THROW_AE_BUT_OTHER = "Class %s default constructor must throw an " + AssertionError.class.getName()
			+ " but an %s was thrown instead";
	
	
	private ClassAssertions() {
		throw new AssertionError( ClassAssertions.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	/**
	 * Assert that the given class is final.
	 * 
	 * @param clazz
	 * @throws NullPointerException When the clazz argument is null.
	 */
	public static void assertFinal( Class<?> clazz ) {
		int modifiers = clazz.getModifiers();
		boolean isFinal = Modifier.isFinal( modifiers );
		
		if( !isFinal ) {
			String message = String.format( CLASS_IS_NOT_FINAL_MESSAGE, clazz.getName() );
			throw new AssertionFailedError( message );
		}
	}
	
	
	/**
	 * Assert that the given class doesn't extend from any other class other than Object.
	 * 
	 * @param clazz
	 * @throws NullPointerException When the clazz argument is null.
	 */
	public static void assertNoSuperclass( Class<?> clazz ) {
		if( clazz.getSuperclass() != Object.class ) {
			String message = String.format( CLASS_EXTENDS_ANOTHER_CLASS_MESSAGE, clazz.getName() );
			throw new AssertionFailedError( message );
		}
	}
	
	
	/**
	 * Assert that the given class doesn't implement any interfaces.
	 * 
	 * @param clazz
	 * @throws NullPointerException When the clazz argument is null.
	 */
	public static void assertNoInterfaces( Class<?> clazz ) {
		if( clazz.getInterfaces().length != 0 ) {
			String message = String.format( CLASS_IMPLEMENTS_SOME_INTERFACE_MESSAGE, clazz.getName() );
			throw new AssertionFailedError( message );
		}
	}
	
	
	public static void assertUtilityClass( Class<?> clazz ) {
		assertFinal( clazz );
		assertNoSuperclass( clazz );
		assertNoInterfaces( clazz );
		
		// Assert only one constructor
		if( clazz.getDeclaredConstructors().length != 1 ) {
			String message = String.format( CLASS_MUST_HAVE_ONLY_ONE_PRIVATE_CONSTRUCTOR_WITH_NO_ARGS_MESSAGE, clazz.getName() );
			throw new AssertionFailedError( message );
		}
		else {
			Constructor<?> constructor;
			try {
				// Assert that the constructor with no arguments exists
				constructor = clazz.getDeclaredConstructor();
			}
			catch( NoSuchMethodException nsme ) {
				String message = String.format( CLASS_MUST_HAVE_ONLY_ONE_PRIVATE_CONSTRUCTOR_WITH_NO_ARGS_MESSAGE, clazz.getName() );
				throw new AssertionFailedError( message );
			}
			
			// Assert that it is private
			int modifiers = constructor.getModifiers();
			boolean isPrivate = Modifier.isPrivate( modifiers );
			if( !isPrivate ) {
				String message = String.format( CLASS_MUST_HAVE_ONLY_ONE_PRIVATE_CONSTRUCTOR_WITH_NO_ARGS_MESSAGE, clazz.getName() );
				throw new AssertionFailedError( message );
			}
			
			// Assert that it throws an AssertionError
			constructor.setAccessible( true );
			
			Executable executable = () -> {
				try {
					constructor.newInstance();
				}
				catch( InvocationTargetException ite ) {
					throw ite.getCause();
				}
			};
			
			boolean wasThrown;
			try {
				executable.execute();
				
				// If it reached here then the constructor didn't throw anything
				wasThrown = false;
			}
			catch( AssertionError ae ) {
				wasThrown = true;
			}
			catch( Throwable t ) {
				String message = String.format( DEFAULT_CONSTRUCTOR_MUST_THROW_AE_BUT_OTHER, clazz.getName(), t.getClass().getName() );
				throw new AssertionFailedError( message );
			}
			
			if( !wasThrown ) {
				String message = String.format( DEFAULT_CONSTRUCTOR_MUST_THROW_AE_BUT_NOTHING, clazz.getName() );
				throw new AssertionFailedError( message );
			}
		}
		
		// Assert that all methods are static
		Method[] methods = clazz.getDeclaredMethods();
		for( Method method : methods ) {
			int modifiers = method.getModifiers();
			boolean isStatic = Modifier.isStatic( modifiers );
			
			if( !isStatic ) {
				String message = String.format( ALL_METHODS_MUST_BE_STATIC, clazz.getName() );
				throw new AssertionFailedError( message );
			}
		}
	}

}
