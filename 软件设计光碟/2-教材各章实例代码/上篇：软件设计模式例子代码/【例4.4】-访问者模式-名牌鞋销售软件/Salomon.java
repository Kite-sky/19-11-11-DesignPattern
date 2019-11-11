


public class Salomon extends RunningShoes{

	public double getPrice(){
       return 103.95;
    }

    public String getDescription(){
	   return "Salomon, produced in US";
    }

	public void accept(Visitor v){
       System.out.println("Salomon has been visited.");
       v.visitSalomon(this);
    }
}
