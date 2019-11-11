


public class Nike  extends WalkingSheos{

   public double getPrice(){
      return 44.98;
   }

   public String getDescription(){
   	   return "Nike, produced in US";
   }

   public void accept(Visitor v){
      System.out.println("Nike has been visited.");
      v.visitNike(this);
   }
}
