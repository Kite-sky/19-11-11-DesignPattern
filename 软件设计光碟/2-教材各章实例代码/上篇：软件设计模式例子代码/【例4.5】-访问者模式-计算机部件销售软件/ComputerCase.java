
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class ComputerCase implements ComputerParts{

	public static final String NAME = "ComputerCase";
	private final double PRICE = 30.00;
    public static final String FEATURES = "Computer Case. Green Hoke C668";

	public String getName(){
		return NAME;
	}
	public double getPrice(){
        return PRICE;
    }
    public String getDescription(){
		return FEATURES;
	}

	public void accept(Visitor v){
        System.out.println("ComputerCase has been visited.");
        v.visitComputerCase(this);
    }
}
