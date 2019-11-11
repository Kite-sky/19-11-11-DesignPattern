
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class  Mouse implements ComputerParts{

	public static final String NAME = "Mouse";
	private final double PRICE = 10.00;
	public static final String FEATURES = "Mouse. HK32";

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
        System.out.println("Mouse has been visited.");
        v.visitMouse(this);
    }
}