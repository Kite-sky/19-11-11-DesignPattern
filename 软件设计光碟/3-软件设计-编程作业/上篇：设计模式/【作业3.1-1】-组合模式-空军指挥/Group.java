/*=======================*/
/* Represents an air Group    */
/*=======================*/

public class Group extends AirUnit{

    public static final String FEATURES = "A Group with 72 aircrafts";
    Airforce[] fighters = new Airforce[54];
    Airforce[] bombers = new Airforce[6];
    Airforce[] transporters= new Airforce[6];
    Airforce[] eAircrafts = new Airforce[6];

    public Group(){
       for(int k=0;k<54;k++){
           fighters[k] = new F22();
           super.attach(fighters[k]);
	   }
       for(int k=0;k<6;k++){
           bombers[k] = new B52();
           super.attach(bombers[k] );
	   }
       for(int k=0;k<6;k++){
           transporters[k] = new C130J();
	       super.attach(transporters[k]);
	   }
       for(int k=0;k<6;k++){
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