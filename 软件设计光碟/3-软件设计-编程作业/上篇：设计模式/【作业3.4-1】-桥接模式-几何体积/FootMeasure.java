


/*=================================================*/
/* This is a subclass to implement interface Measure. Together
/* they form the abstract part of the bridge pattern.
/*=================================================*/

public class FootMeasure implements Measure{

   private GeoForm g;

   public FootMeasure (GeoForm g){
       this.g = g;
	}

   public double findVolume(){
      double v = g.computeVolume();
      return v;
   }

    public String convert(){

	   double cubeFeet = findVolume();
	   System.out.println("Cubic feet = "+cubeFeet);
	   double cubeMeters = (1/804d)* cubeFeet;

       String str  = "It equals  " + cubeMeters + " Cubic meters";
       return str;
   }
}
