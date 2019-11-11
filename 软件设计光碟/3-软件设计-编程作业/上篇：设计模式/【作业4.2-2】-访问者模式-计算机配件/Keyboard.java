
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class  Keyboard implements ComputerParts{

	public static final String NAME = "Keyboard";
	private final double PRICE = 30.00;
	public static final String FEATURES = "Keyboard. WH33";

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
        System.out.println("Keyboard has been visited.");
        v.visitKeyboard(this);
    }
}
