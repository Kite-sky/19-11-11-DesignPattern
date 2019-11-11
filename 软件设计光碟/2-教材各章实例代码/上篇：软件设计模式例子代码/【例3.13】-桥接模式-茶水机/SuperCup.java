




/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaSize                                         */
/* a) This class keeps a reference tk of TeaKind   */
/* b) An object of TeaKind is passed through the   */
/*    parameter                                    */
/* c) This tk is used to call the price method in  */
/*    class hierarchy TeaKind                      */
/*=================================================*/


public class SuperCup implements TeaSize{

   private TeaKind tk;

   public SuperCup(TeaKind tKind){
	  tk = tKind;
   }

   public float getPrice(){
      float teaPrice = 1.5f * tk.price();
      return teaPrice;
   }
}
