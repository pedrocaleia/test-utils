package pt.pcaleia.util.test.pojos;


/**
 * @author Pedro Caleia
 */
public final class UtilityClassWithoutDefaultConstructor {
	
	
	private UtilityClassWithoutDefaultConstructor( int someArgument ) {
		throw new AssertionError( UtilityClassWithoutDefaultConstructor.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}

}
