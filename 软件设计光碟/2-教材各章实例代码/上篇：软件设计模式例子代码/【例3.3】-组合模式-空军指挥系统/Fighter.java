

/*================================*/
/* Represents a kind of airforce  */
/*================================*/

public abstract class Fighter implements Airforce{

	public static final String FEATURES = "Fighter Airplanes";


    public String getDescription(){
	    return FEATURES;
	}

	public abstract String fight();

}
