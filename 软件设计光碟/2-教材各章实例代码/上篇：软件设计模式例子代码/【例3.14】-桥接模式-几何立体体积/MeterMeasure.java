/*=================================================*/
/* This is a subclass to implement interface Measure. Together
/* they form the abstract part of the bridge pattern.
/*=================================================*/

public class MeterMeasure implements Measure{

   private GeoForm g;

   public MeterMeasure (GeoForm g){
       this.g = g;
	}

   public double findVolume(){
      double v = g.computeVolume();
      return v;
   }

   public String convert(){

   	   double cubeMeters = findVolume();
   	   double cubeFeet = 804d* cubeMeters;

          String str  = "It equals " + cubeFeet  + "  Cubic feet";
          return str;
   }
}
