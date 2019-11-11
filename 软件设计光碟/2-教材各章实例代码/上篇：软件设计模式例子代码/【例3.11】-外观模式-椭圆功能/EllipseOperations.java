import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/*========================================================*/
// This class provides some functionalities that are not  */
// included in Ellipse2D.Double. The new functionalities  */
// are those frequently used by mathematics workers       */
//========================================================*/

public class EllipseOperations extends Ellipse2D.Double{
   private double xCorner, yCorner, xLen, yLen;
   private double a;
   private double b;
   private double e;

   public EllipseOperations(double xCorner, double yCorner, double xLen, double yLen){
	  super(xCorner, yCorner, xLen, yLen);
	  this.xCorner = xCorner;
	  this.yCorner = yCorner;
	  this.xLen = xLen;
	  this.yLen = yLen;
	  a = xLen/2;
	  b = yLen/2;
   }

   public double getOvalArea(){
      return Math.PI*a*b;
   }

   // The perimeter of an ellipse (in definite integral) has no finite
   // form so we can only use an approximate formula by Ramanujan's 1914
   public double getOvalPerimeter(){
      double h=Math.pow((a-b)/(a+b),2);
	  return Math.PI*(a+b)*(1+3*h/(10+Math.sqrt(4-3*h)));
   }

   public double getEccentricity (){
	  double c;
	  if((a>b)|| (a==b)){
         c=Math.sqrt(a*a-b*b);
         e=c/a;
      }
      else if(a<b){
		 c=Math.sqrt(b*b-a*a);
		 e=c/b;
	  }
      return e;
   }

   public Point2D[] getFocalPoints(){
	  Point2D[] focalPoints=new Point2D.Double[2];
	  if((a>b)||(a==b)){
	     double centerX = getCenterX();
	     double c=Math.sqrt(a*a-b*b);
	     Point2D focalLeft  = new Point2D.Double(centerX - c, 0);
	     Point2D focalRight = new Point2D.Double(centerX + c, 0);

	     focalPoints[0]= focalLeft;
	     focalPoints[1]= focalRight;
	  }
	  else if (a<b){
		 double centerY = getCenterY();
	     double c=Math.sqrt(b*b-a*a);
	     Point2D focallower = new Point2D.Double(0, centerY-c);
	     Point2D focalUpper = new Point2D.Double(0, centerY+c);
	     focalPoints[0]= focallower;
	     focalPoints[1]= focalUpper;
	  }
	  return focalPoints;
  }
}
