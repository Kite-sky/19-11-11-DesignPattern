/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public class F16 extends Fighter{

	public static final String FEATURES = "F16CD Fighting Falcon";


    public String getDescription(){
	    return FEATURES;
	}

	public String fight(){
		return FEATURES + " Ready to fight!";

	}

}
