
/*==========================*/
/* Represents an air Squadron    */
/*==========================*/

public class Squadron extends AirUnit{

    public static final String FEATURES = "A Quadron with 24 aircrafts";
    Airforce[] fighters = new Airforce[18];
    Airforce[] bombers = new Airforce[2];
    Airforce[] transporters= new Airforce[2];
    Airforce[] eAircrafts = new Airforce[2];

    public Squadron(){
       for(int k=0;k<18;k++){
           fighters[k] = new F22();
           super.attach(fighters[k]);
	   }
       for(int k=0;k<2;k++){
           bombers[k] = new B52();
           super.attach(bombers[k] );
	   }
       for(int k=0;k<2;k++){
           transporters[k] = new C130J();
	       super.attach(transporters[k]);
	   }
       for(int k=0;k<2;k++){
            eAircrafts[k] = new E9A();
            super.attach(eAircrafts[k]);
	   }
    }

    public String getDescription(){
	return FEATURES;
    }

    public String fight(){
	    return super.fight();
	}
}