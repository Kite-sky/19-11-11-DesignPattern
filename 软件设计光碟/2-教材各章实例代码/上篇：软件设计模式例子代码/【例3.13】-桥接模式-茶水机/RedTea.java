

/*=================================================*/
/* This is a subclass to implement interface       */
/* TeaKind. The TeaKind class hierarchy represents */
/* the implementation part of the bridge pattern   */
/*=================================================*/

public class RedTea implements TeaKind{

   private final float PRICE = 3.0f;

   public float price(){
      return PRICE;
   }
}
