
/*=====================================================*/
/* This class shows the one use of the adapter         */
/* pattern, that is, when the interface of a class is  */
/* not the one we need, we can use adapter pattern to  */
/* chnage the interface to the one we needed.          */
/* THis adapter class is used to provide users with    */
/* two ways of drawing an ellipse shape, one is by     */
/* drawing the Oval by upper left corner coordinates   */
/* and the Width and length, the other is by drawing   */
/* Oval By Center coordinates ans radius.              */
/* EllipseGUI is the adaptee class                     */
/*=====================================================*/


public class EllipseGUIAdapter implements TwoWaysDrawingEllipse
{
   private EllipseGUI ellipGui;
   public EllipseGUI drawOvalByCorner(double xCorner, double yCorner,
                                                 double xLen, double yLen)
   {
	   ellipGui = new EllipseGUI(xCorner, yCorner, xLen, yLen);
	   return ellipGui;
   }

   public EllipseGUI drawOvalByCenter(double xCenter, double yCenter,
                                            double xRadius, double yRadius)
   {
   	   double xCorner= xCenter-xRadius;
   	   double yCorner= yCenter-yRadius;
   	   double xLen = 2*xRadius;
   	   double yLen = 2*yRadius;

   	   ellipGui = new EllipseGUI(xCorner, yCorner, xLen, yLen);
   	   return ellipGui;
   }
}