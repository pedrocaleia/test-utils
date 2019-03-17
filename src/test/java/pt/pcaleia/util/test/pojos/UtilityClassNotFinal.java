package pt.pcaleia.util.test.pojos;


/**
 * @author Pedro Caleia
 */
public class UtilityClassNotFinal {
	
	
	private UtilityClassNotFinal() {
		throw new AssertionError( UtilityClassNotFinal.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}

}
