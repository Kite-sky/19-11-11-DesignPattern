

/*===================================*/
/* This is the interface of a class  */
/* hierarchy that is to be visited   */
/* by some visitors                  */
/*===================================*/

public abstract interface ComputerParts {

   public abstract void accept(Visitor vis);
   public abstract String getName();
   public abstract double getPrice();
   public abstract String getDescription();
}
