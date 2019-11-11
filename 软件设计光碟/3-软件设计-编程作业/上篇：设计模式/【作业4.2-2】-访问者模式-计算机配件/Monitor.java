
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class Monitor implements ComputerParts{

	public static final String NAME = "Monitor";
	private final double PRICE = 40.00;
	public static final String FEATURES = "Monitor. GZ997";

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
        System.out.println("Monitor has been visited.");
        v.visitMonitor(this);  // parameter "this" is harddisk
    }
}
