

/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public class F22 extends Fighter{

	public static final String FEATURES = "F22A Rapter";


    public String getDescription(){
	    return FEATURES;
	}

	public String fight(){
		return FEATURES + " Ready to fight!";

	}

}
