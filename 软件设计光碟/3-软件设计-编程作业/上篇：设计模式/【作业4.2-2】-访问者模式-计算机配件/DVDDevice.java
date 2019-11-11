

/*================================*/
/* This is a class to be visited  */
/*================================*/

public class DVDDevice implements ComputerParts{

	public static final String NAME = "DVDDevice";
	private final double PRICE = 20.00;
	public static final String FEATURES = "DVD Device. KR D380";

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
        System.out.println("DVDDevice has been visited.");
        v.visitDVDDevice(this);
    }
}
