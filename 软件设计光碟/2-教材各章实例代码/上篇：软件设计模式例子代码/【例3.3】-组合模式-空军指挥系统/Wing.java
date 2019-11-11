


/*=======================*/
/* Represents an air Wing      */
/*=======================*/

public class Wing extends AirUnit{

    public static final String FEATURES = "A Wing with 216 aircrafts";
    Airforce[] fighters = new Airforce[162];
    Airforce[] bombers = new Airforce[18];
    Airforce[] transporters= new Airforce[18];
    Airforce[] eAircrafts = new Airforce[18];

    public Wing(){
       for(int k=0;k<162;k++){
           // need 162 fighters
	   }
       for(int k=0;k<18;k++){
           // need 18 bombers
	   }
       for(int k=0;k<18;k++){
           // need 18 transporters
	   }
       for(int k=0;k<18;k++){
           // need 18 eAirplanes
	   }
    }

    public String getDescription(){
	return FEATURES;
    }

    public String fight(){
	    return super.fight();
	}
}