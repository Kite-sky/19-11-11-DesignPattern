

/*==============================================*/
/* This class implements Interface GeoForm. Together thay
/* form the implementation part of the bridge pattern
/*==============================================*/

public class EllipseCylinder implements GeoForm{

   private double aRadius;
   private double bRadius;
   private double height;
   private final String FOOT = "foot";
   private final String METER = "meter";

   public EllipseCylinder(double aRadius, double bRadius, double height){
	   this.aRadius = aRadius;
	   this.bRadius = bRadius;
	   this.height = height;
   }

   public double computeVolume(){
       double volume = 3.1415926* aRadius* bRadius* height;

       return volume;
   }
}
