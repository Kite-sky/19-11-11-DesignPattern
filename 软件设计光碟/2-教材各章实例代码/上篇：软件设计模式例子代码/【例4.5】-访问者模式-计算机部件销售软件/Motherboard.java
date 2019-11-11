
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class Motherboard implements ComputerParts {

	public static final String NAME = "Motherboard";
	private final double PRICE = 40.00;
	public static final String FEATURES = "Motherboard. Intel HB778";

	public String getName(){
		return NAME;
	}
	public double getPrice(){
		return PRICE;
    }

    public String getDescription(){
		return FEATURES;
	}

	public void accept(Visitor v) {
        System.out.println("Motherboard has been visited.");
        v.visitMotherboard(this);
    }
}

