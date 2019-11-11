


public class DCShoesRover extends SkatingShoes{

   public double getPrice(){
      return 99.95;
   }

   public String getDescription(){
         return "DCShoesRover, produced in US";
   }

   public void accept(Visitor v){
      System.out.println("DCShoesRover has been visited.");
      v.visitDCShoesRover(this);
   }
}
