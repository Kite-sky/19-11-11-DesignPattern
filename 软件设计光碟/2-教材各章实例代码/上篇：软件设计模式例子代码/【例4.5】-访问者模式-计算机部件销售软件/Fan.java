
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class  Fan implements ComputerParts{

	public static final String NAME = "Fan";
    private final double PRICE = 20.00;
    public static final String FEATURES = "Fan. SDWH 665";

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
        System.out.println("Fan has been visited.");
        v.visitFan(this);
    }
}