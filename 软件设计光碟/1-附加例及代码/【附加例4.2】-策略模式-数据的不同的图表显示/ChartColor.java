import java.awt.Color;



public class ChartColor{

   public static Color getColor(double value){

     Color color = Color.black;

     if( value < 20 ){
	 	color = Color.black;
   	 }
   	 else if( (value >= 20) && ( value < 30)){
	 	color = new Color(200, 50, 8, 255);
   	 }
     else if( (value >= 30) && ( value < 40)){
	    color = new Color(255, 80, 10, 255);
   	 }
     else if( (value >= 40) && ( value < 50)){
	    color = new Color(255, 130, 80, 255);
   	 }
     else if( (value >= 50) && ( value < 60)){
   	    color = new Color(200, 180, 100, 255);
   	 }
   	 else if( (value >= 60) && ( value < 70)){
	    color = new Color(150, 220, 120, 255);
   	 }
   	 else if( (value >= 70) && ( value < 80)){
	    color = new Color(100, 240, 140, 255);
   	 }
   	 else if( (value >= 80) && ( value < 90)){
	    color = new Color(50, 250, 160, 255);
   	 }
   	 else if( (value >= 90) && ( value < 100)){
	    color = new Color(20, 255, 180, 255);
   	 }
   	 else if( (value >= 100) && ( value < 110)){
	 	color = new Color(20, 255, 200, 255);
   	 }
   	 else if( (value >= 110) && ( value < 120)){
	 	color = new Color(20, 255, 220, 255);
   	 }
   	 else if( (value >= 110) && ( value < 120)){
	 	color = new Color(20, 255, 240, 255);
   	 }
   	 else if( (value >= 110) && ( value < 120)){
	 	color = new Color(20, 255, 255, 255);
   	 }
   	 else {
	 	color = new Color(20, 10, 255, 255);
   	 }

     return color;
   }

}