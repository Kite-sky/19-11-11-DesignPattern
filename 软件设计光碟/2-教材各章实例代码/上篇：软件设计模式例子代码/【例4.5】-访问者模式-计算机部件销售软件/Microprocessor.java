
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class Microprocessor implements ComputerParts{

	public static final String NAME = "Microprocessor";
	private final double PRICE = 80.00;
	public static final String FEATURES = "Microprocessor. Intel BJ786";

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
        System.out.println("Microprocessor has been visited.");
        v.visitMicroprocessor(this);
    }
}
