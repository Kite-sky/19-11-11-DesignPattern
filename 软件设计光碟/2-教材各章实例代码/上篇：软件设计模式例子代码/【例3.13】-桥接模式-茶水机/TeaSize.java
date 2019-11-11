

/*======================================================*/
/* Interface for the cup size, which is implemented by  */
/* classes MediumCup and SuperCup, which represent the  */
/* cup size of the tea seller machine.                  */
/* This interface TeaSIze together with its implementer */
/* classes is the abstract part of the bridge pattern   */
/*======================================================*/

public interface TeaSize {

   public abstract float getPrice();

}