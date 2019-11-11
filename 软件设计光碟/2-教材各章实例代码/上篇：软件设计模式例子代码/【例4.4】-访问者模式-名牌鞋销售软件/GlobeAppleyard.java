


public class GlobeAppleyard  extends SkatingShoes{

   public double getPrice(){
      return 69.99;
   }

   public String getDescription(){
      return "GlobeAppleyard, produced in US";
   }

   public void accept(Visitor v){
      System.out.println("GlobeAppleyard has been visited.");
      v.visitGlobeAppleyard(this);
   }
}
