package pt.pcaleia.util.test;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.opentest4j.AssertionFailedError;

import pt.pcaleia.util.test.pojos.ClassWithInterface;
import pt.pcaleia.util.test.pojos.ClassWithSuperClass;
import pt.pcaleia.util.test.pojos.ClassWithoutInterfaces;
import pt.pcaleia.util.test.pojos.ClassWithoutSuperClass;
import pt.pcaleia.util.test.pojos.FinalClass;
import pt.pcaleia.util.test.pojos.NotFinalClass;
import pt.pcaleia.util.test.pojos.UtilityClass;
import pt.pcaleia.util.test.pojos.UtilityClassNotFinal;
import pt.pcaleia.util.test.pojos.UtilityClassThatDoesntThrowExceptionInConstructor;
import pt.pcaleia.util.test.pojos.UtilityClassThatThrowsWrongExceptionInDefaultConstructor;
import pt.pcaleia.util.test.pojos.UtilityClassWithDefaultConstructorButIsPublic;
import pt.pcaleia.util.test.pojos.UtilityClassWithInterface;
import pt.pcaleia.util.test.pojos.UtilityClassWithMoreThanOneConstructor;
import pt.pcaleia.util.test.pojos.UtilityClassWithNonStaticMethod;
import pt.pcaleia.util.test.pojos.UtilityClassWithSuperclass;
import pt.pcaleia.util.test.pojos.UtilityClassWithoutDefaultConstructor;


/**
 * @author Pedro Caleia
 */
public final class ClassAssertionsTest {
	
	
	/*
	 * Class Tests
	 */
	
	
	@Test
	public void testThatClassAssertionsClassIsAnUtilityClass() {
		ClassAssertions.assertUtilityClass( ClassAssertions.class );
	}
	
	
	/*
	 * assertFinal Tests
	 */
	
	
	@Test
	public void testThatAssertFinalReturnsWhenArgumentIsAFinalClass() {
		ClassAssertions.assertFinal( FinalClass.class );
	}
	
	
	@Test
	public void TestThatAssertFinalThrowsWhenArgumentIsNull() {
		Executable executable = () -> ClassAssertions.assertFinal( null );
		Assertions.assertThrows( NullPointerException.class, executable );
	}
	
	
	@Test
	public void testThatAssertFinalThrowsWhenArgumentIsNotAFinalClass() {
		Executable executable = () -> ClassAssertions.assertFinal( NotFinalClass.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	/*
	 * assertNoSuperclass Tests
	 */
	
	
	@Test
	public void testThatAssertNoSuperclassReturnsWhenArgumentIsAClassWithoutASuperclass() {
		ClassAssertions.assertNoSuperclass( ClassWithoutSuperClass.class );
	}
	
	
	@Test
	public void TestThatAssertNoSuperclassThrowsWhenArgumentIsNull() {
		Executable executable = () -> ClassAssertions.assertNoSuperclass( null );
		Assertions.assertThrows( NullPointerException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNoSuperclassThrowsWhenArgumentIsAClassWithASuperclass() {
		Executable executable = () -> ClassAssertions.assertNoSuperclass( ClassWithSuperClass.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	/*
	 * assertNoInterfaces Tests
	 */
	
	
	@Test
	public void testThatAssertNoInterfacesReturnsWhenArgumentIsAClassWithoutInterfaces() {
		ClassAssertions.assertNoInterfaces( ClassWithoutInterfaces.class );
	}
	
	
	@Test
	public void TestThatAssertNoInterfacesThrowsWhenArgumentIsNull() {
		Executable executable = () -> ClassAssertions.assertNoInterfaces( null );
		Assertions.assertThrows( NullPointerException.class, executable );
	}
	
	
	@Test
	public void testThatAssertNoInterfacesThrowsWhenArgumentIsAClassWithAtLeastOneInterface() {
		Executable executable = () -> ClassAssertions.assertNoInterfaces( ClassWithInterface.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	/*
	 * assertUtilityClass Tests
	 */
	
	
	@Test
	public void testThatAssertUtilityClassReturnsWhenArgumentIsAValidUtilityClass() {
		ClassAssertions.assertUtilityClass( UtilityClass.class );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsNull() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( null );
		Assertions.assertThrows( NullPointerException.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButItIsNotFinal() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassNotFinal.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButHasAnSuperclass() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassWithSuperclass.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButHasAnInterface() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassWithInterface.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButHasMoreThanOneConstructor() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassWithMoreThanOneConstructor.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButDoesntHaveTheDefaultConstructor() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassWithoutDefaultConstructor.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButTheDefaultConstructorIsPublic() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassWithDefaultConstructorButIsPublic.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButTheDefaultConstructorDoesntThrowAnException() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassThatDoesntThrowExceptionInConstructor.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButTheDefaultConstructorThrowsWrongException() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassThatThrowsWrongExceptionInDefaultConstructor.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}
	
	
	@Test
	public void testThatAssertUtilityClassThrowsWhenArgumentIsAnUtilityClassButWithNonStaticMethod() {
		Executable executable = () -> ClassAssertions.assertUtilityClass( UtilityClassWithNonStaticMethod.class );
		Assertions.assertThrows( AssertionFailedError.class, executable );
	}

}
