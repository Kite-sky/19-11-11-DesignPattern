


public class GlobeBlitz extends SkatingShoes{

   public double getPrice(){
      return  60.00;
   }

   public String getDescription(){
         return "GlobeBlitz, produced in US";
   }

   public void accept(Visitor v){
      System.out.println("GlobeBlitz has been visited.");
      v.visitGlobeBlitz(this);
   }
}
