

/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public class F15 extends Fighter{

	public static final String FEATURES = "F15E Strike Eagle";


    public String getDescription(){
	    return FEATURES;
	}

	public String fight(){
		return FEATURES + " Ready to fight!";

	}

}
