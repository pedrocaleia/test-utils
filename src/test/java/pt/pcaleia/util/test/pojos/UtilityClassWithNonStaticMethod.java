package pt.pcaleia.util.test.pojos;


/**
 * @author Pedro Caleia
 */
public final class UtilityClassWithNonStaticMethod {
	
	
	private UtilityClassWithNonStaticMethod() {
		throw new AssertionError( UtilityClassWithNonStaticMethod.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}
	
	
	public void nonStaticMethod() {
		// Empty on purpose
	}

}
