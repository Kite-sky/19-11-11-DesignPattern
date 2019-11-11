
public class PriceVisitor extends Visitor{
	private float total;
	private double shoesPrice;

	public PriceVisitor(){
       total = 0;
    }

	public void visitAdidas(Adidas e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitSalomon(Salomon e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitPonyMexico(PonyMexico e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitNorthFace (NorthFace e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitNike(Nike e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitMephisto(Mephisto e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitGlobeBlitz (GlobeBlitz e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitGlobeAppleyard(GlobeAppleyard e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}
	public void visitDCShoesRover(DCShoesRover e){
	   shoesPrice = e.getPrice();
	   total += shoesPrice;
	}

    public double getShoesPrice(){
	   return shoesPrice;
	}
	public float getPriceTotal(){
	       return total;
	}
}

