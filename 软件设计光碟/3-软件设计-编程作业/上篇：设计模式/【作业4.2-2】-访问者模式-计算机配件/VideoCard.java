
/*================================*/
/* This is a class to be visited  */
/*================================*/

public class VideoCard implements ComputerParts{

	public static final String NAME = "VideoCard";
    private final double PRICE = 30.00;
    public static final String FEATURES = "Video Card. TAISHAN5";

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
        System.out.println("VideoCard has been visited.");
        v.visitVideoCard (this);
    }
}