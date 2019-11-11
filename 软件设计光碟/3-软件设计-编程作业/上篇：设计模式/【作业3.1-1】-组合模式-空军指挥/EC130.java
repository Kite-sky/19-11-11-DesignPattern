



/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public class EC130 extends EPlane{

	public static final String FEATURES = "EC130HJ Compass";


    public String getDescription(){
	    return FEATURES;
	}

	public String fight(){
		return FEATURES + " Ready to fight!";

	}

}
