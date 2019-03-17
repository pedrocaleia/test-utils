package pt.pcaleia.util.test.pojos;


/**
 * @author Pedro Caleia
 */
public final class UtilityClassWithMoreThanOneConstructor {
	
	
	private UtilityClassWithMoreThanOneConstructor() {
		throw new AssertionError( UtilityClassWithMoreThanOneConstructor.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	private UtilityClassWithMoreThanOneConstructor( int someArgument ) {
		throw new AssertionError( UtilityClassWithMoreThanOneConstructor.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}

}
