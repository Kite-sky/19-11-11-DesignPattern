

public class CarBitInfoView implements Observer{

    private CarModel model;
    private CarAuctionGUI cg;

	public CarBitInfoView(CarModel cmodel,CarAuctionGUI cg) {
       model = cmodel;
       this.cg=cg;
    }
    public void update(Observable subject){
       if ( (subject == model) && (model.isBitBtnClicked())){
          String sCar= model.getSelectedCar();
		  String pr = model.getBitPrice();
          String prc="\n Bit price for "+ sCar + " : "+ pr;

          cg.showBitPrice(prc);
       }
     }
}// end of class


