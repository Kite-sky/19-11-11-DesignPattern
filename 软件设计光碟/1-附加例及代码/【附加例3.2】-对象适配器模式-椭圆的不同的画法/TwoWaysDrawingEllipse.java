
/*=====================================================*/
/* This interface shows the one use of the adapter     */
/* pattern, that is, when the interface of a class is  */
/* not the one we need, we can use adapter pattern to  */
/* chnage the interface to the one we needed.          */
/* THis interface is used to provide users with        */
/* two ways of drawing an ellipse shape, one is by     */
/* drawing the Oval by upper left corner coordinates   */
/* and the Width and length, the other is by drawing   */
/* Oval By Center coordinates ans radius.              */
/*=====================================================*/


public interface TwoWaysDrawingEllipse
{
   abstract EllipseGUI drawOvalByCorner(double xCorner, double yCorner,
                                                  double xLen, double yLen);
   abstract EllipseGUI drawOvalByCenter(double xCenter, double yCenter,
                                              double xRadius, double yRadius);
}