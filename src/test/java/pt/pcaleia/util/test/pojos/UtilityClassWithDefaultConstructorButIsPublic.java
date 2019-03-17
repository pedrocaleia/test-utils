package pt.pcaleia.util.test.pojos;


/**
 * @author Pedro Caleia
 */
public final class UtilityClassWithDefaultConstructorButIsPublic {
	
	
	public UtilityClassWithDefaultConstructorButIsPublic() {
		throw new AssertionError( UtilityClassWithDefaultConstructorButIsPublic.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}

}
