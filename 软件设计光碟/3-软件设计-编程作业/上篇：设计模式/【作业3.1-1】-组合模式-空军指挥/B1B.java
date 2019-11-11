/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public class B1B extends Bomber{

	public static final String FEATURES = "B1B Lancer";


    public String getDescription(){
	    return FEATURES;
	}

	public String fight(){
		return FEATURES + " Ready to fight!";

	}

}
