


public class HardDiskDrive implements ComputerParts{

	public static final String NAME = "HardDiskDrive";
	private final double PRICE = 20.00;
	public static final String FEATURES = "Hard DiskDrive. TAISHAN380";

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
        System.out.println("HardDiskDrive has been visited.");
        v.visitHardDiskDrive(this);
    }
}

