


public class Mephisto  extends WalkingSheos{

	public double getPrice(){
       return 384.98;
    }

    public String getDescription(){
	   return "Mephisto, produced in US";
   }

	public void accept(Visitor v){
       System.out.println("Mephisto has been visited.");
       v.visitMephisto(this);
    }
}
