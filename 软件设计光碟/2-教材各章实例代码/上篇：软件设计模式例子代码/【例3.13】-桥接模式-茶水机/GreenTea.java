


/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaKind. The TeaKind class hierarchy represents */
/* the implementation part of the bridge pattern   */
/*=================================================*/

public class GreenTea implements TeaKind{

   private final float PRICE = 2.0f;

   public float price(){
      return PRICE;
   }
}
