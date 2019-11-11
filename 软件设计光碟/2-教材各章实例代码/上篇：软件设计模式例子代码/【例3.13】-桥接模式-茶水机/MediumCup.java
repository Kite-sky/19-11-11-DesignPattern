


/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaSize                                         */
/* a) This class keeps a reference tk of TeaKind   */
/* b) An object of TeaKind is passed through the   */
/*    parameter                                    */
/* c) This tk is used to call the price method in  */
/*    class hierarchy TeaKind                      */
/*=================================================*/


public class MediumCup implements TeaSize{

   private TeaKind tk;

   public MediumCup(TeaKind tKind){
   	  tk = tKind;
   }

   public float getPrice(){
      float teaPrice = tk.price();
      return teaPrice;
   }
}
