


public class PonyMexico  extends RunningShoes{

   public double getPrice(){
      return 33.64;
   }

   public String getDescription(){
         return "PonyMexico, produced in US";
   }

   public void accept(Visitor v){
      System.out.println("PonyMexico has been visited.");
      v.visitPonyMexico(this);
   }
}
