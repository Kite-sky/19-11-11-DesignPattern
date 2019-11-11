
/*==============================================*/
/* This class implements Interface GeoForm. Together thay
/* form the implementation part of the bridge pattern
/*==============================================*/

public class Cube implements GeoForm{
   private double len;
   private double width;
   private double height;

   public Cube(double len, double width, double height){
	   this.len = len;
	   this.width = width;
	   this.height = height;
   }

   public double computeVolume(){
        double volume = len*width*height;

        return volume;
   }
}
