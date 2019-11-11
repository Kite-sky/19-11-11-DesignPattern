
public class Adidas extends RunningShoes{

   public double getPrice(){
      return 93.53;
   }

   public String getDescription(){
      return "Adidas, made in US.";

   }

   public void accept(Visitor v){
      System.out.println("Adidas has been visited.");
      v.visitAdidas(this);
   }
}
