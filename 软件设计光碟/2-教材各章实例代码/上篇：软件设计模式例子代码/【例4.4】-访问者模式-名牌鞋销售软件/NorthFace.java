


public class NorthFace  extends WalkingSheos{

   public double getPrice(){
      return 99.95;
   }

   public String getDescription(){
      return "NorthFace, produced in US";
   }

   public void accept(Visitor v){
      System.out.println("NorthFace has been visited.");
      v.visitNorthFace(this);
   }
}
