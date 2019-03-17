package pt.pcaleia.util.test;


/**
 * @author Pedro Caleia
 */
public final class TestConstants {
	
	
	private TestConstants() {
		throw new AssertionError( TestConstants.class.getSimpleName() + " class cannot be instantiated." );
	}
	
	
	/**
	 * This is a String composed only by white space characters 
	 */
	public static final String WHITE_SPACE_STRING;
	static {
		byte[] whiteSpaceString = new byte[ 33 ];
		for( int n = 0; n <= 32; n++ ) {
			whiteSpaceString[ n ] = (byte)n;
		}
		
		WHITE_SPACE_STRING = new String( whiteSpaceString );
	}

}
