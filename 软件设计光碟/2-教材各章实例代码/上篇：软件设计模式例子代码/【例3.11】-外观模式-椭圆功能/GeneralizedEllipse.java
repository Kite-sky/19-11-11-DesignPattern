
/*===========================================================*/
/* This class is a facade class that put together some       */
/* options for initializing an ellipse,i.e.,                 */
/* initialize an Oval ByCorner point and width and height,   */
/* initialize an Oval By Center and radius, initialize       */
/* Oval By Rectangle. The class also has the functionality   */
/* of drawing an ellipse by using the above data set.        */
/* In addtion to this,the class also provide some operations */
/* for mathematicians to use, including, getOvalArea,        */
/* getOvalPerimeter,getEccentricity, getFocalPoints          */
/*===========================================================*/

import java.awt.geom.Point2D;


public class GeneralizedEllipse {
   private EllipseGraph ellipGui;
   private EllipseOperations ellipOper;
   private double xCorner;
   private double yCorner;
   private double xLen;
   private double yLen;
   private boolean isOvalInitialized = false;

   public boolean initializeOvalByCorner(double xCorner, double yCorner,
                                         double xLen, double yLen){
      if( (xLen>0)&&(yLen>0) ){
   	     this.xCorner = xCorner;
   	     this.yCorner = yCorner;
   	     this.xLen = xLen;
   	     this.yLen = yLen;
         isOvalInitialized=true;
         return true;
      }
      else{
	     return false;
	  }
   }
   public boolean initializeOvalByCenter(double xCenter, double yCenter,
                                         double xRadius, double yRadius){
	  if( (xRadius>0)&&(yRadius>0) ){
         xCorner= xCenter-xRadius;
         yCorner= yCenter-yRadius;
         xLen = 2*xRadius;
         yLen = 2*yRadius;
         isOvalInitialized=true;
         return true;
	  }
	  else{
	     return false;
	  }
   }
   public boolean initializeOvalByRectangle(double xLeft, double xRight,
                                            double yBottom, double yTop){
      if((xRight>xLeft)&&(yBottom>yTop)){
         xCorner = xLeft;
         yCorner = yTop;
         xLen = xRight-xLeft;
         yLen = yBottom-yTop;
         isOvalInitialized=true;
         return true;
      }
      else{
	     return false;
	  }
   }

   // This method has no parameters, and it can draw oval that has
   // been set up by using setUpOvalByCorner, setUpOvalByCenter,
   // and setUpOvalByRectangle
   public EllipseGraph drawOval(){
	  if( isOvalInitialized = true ){
	     ellipGui = new EllipseGraph(xCorner, yCorner, xLen, yLen);
	     return ellipGui;
      }
      else{
	     System.out.println("Ellipse has not been initialized");
		 return null;
	  }
   }
   public double getOvalArea(){
      ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getOvalArea();
   }
   // The perimeter of an ellipse is expressed by definite integrals
   // and there is no finite form of it, so we use an approximate
   // formula
   public double getOvalPerimeter(){
      ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getOvalPerimeter();
   }
   public double getEccentricity (){
	  ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getEccentricity();
   }
   public Point2D[] getFocalPoints(){
	  ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getFocalPoints();
   }

   public double getCornerX(){
	  ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getX();
   }
   public double getCornerY(){
	  ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getY();
   }
   public double getWidth(){
	  ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getWidth();
   }
   public double getHeight(){
	  ellipOper = new EllipseOperations(xCorner, yCorner, xLen, yLen);
	  return ellipOper.getHeight();
   }
}