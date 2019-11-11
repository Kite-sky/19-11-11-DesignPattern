
import javax.swing.*;


public class CarPictureInfoView implements Observer{
   private CarModel model;
   private CarAuctionGUI cg;

   public CarPictureInfoView(CarModel cmodel,CarAuctionGUI cg){
	  model = cmodel;
	  this.cg=cg;
   }

   public void update(Observable subject){
      if ((subject == model) && (model.isSearchBtnClicked())){
         ImageIcon imIcon = model.getImageIcon();
         cg.setImageInfo(imIcon);
       }
     }
}

