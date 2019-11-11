

/*======================================================*/
/* Interface for the tea kind, which is implemented by  */
/* classes RedTea and GreenTea, which represent the     */
/* kinds of tea in the tea seller machine.              */
/* This interface TeaKind together with its implementer */
/* classes is the implementation part of the bridge     */
/* pattern                                              */
/*======================================================*/

public interface TeaKind {

   public abstract float price();

}