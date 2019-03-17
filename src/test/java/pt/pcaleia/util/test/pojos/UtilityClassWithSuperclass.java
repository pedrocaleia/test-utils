package pt.pcaleia.util.test.pojos;


/**
 * @author Pedro Caleia
 */
public final class UtilityClassWithSuperclass extends SuperClass {
	
	
	private UtilityClassWithSuperclass() {
		throw new AssertionError( UtilityClassWithSuperclass.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}

}
