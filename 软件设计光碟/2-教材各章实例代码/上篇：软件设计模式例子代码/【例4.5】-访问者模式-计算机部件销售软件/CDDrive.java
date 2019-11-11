

/*================================*/
/* This is a class to be visited  */
/*================================*/

public class CDDrive implements ComputerParts{

    public static final String NAME = "CDDrive";
	private final double PRICE = 30.00;
	public static final String FEATURES = "CD Drive. H3K";

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
        System.out.println("CDDrive has been visited.");
        v.visitCDDrive (this);
    }
}
