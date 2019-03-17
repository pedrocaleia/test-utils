package pt.pcaleia.util.test.pojos;


import java.io.Serializable;


/**
 * @author Pedro Caleia
 */
@SuppressWarnings( "serial" )
public final class UtilityClassWithInterface implements Serializable {
	
	
	private UtilityClassWithInterface() {
		throw new AssertionError( UtilityClassWithInterface.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	public static void utilityMethod() {
		// Empty on purpose
	}

}
