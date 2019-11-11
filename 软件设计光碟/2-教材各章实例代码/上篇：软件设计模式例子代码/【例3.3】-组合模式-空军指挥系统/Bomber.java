


/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public abstract class Bomber implements Airforce{

	public static final String FEATURES = "Bombers ";


    public String getDescription(){
	    return FEATURES;
	}

	public abstract String fight();

}
