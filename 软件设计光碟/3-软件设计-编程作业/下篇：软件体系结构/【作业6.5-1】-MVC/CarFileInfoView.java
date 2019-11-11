
import java.io.*;
import java.net.URL;

class CarFileInfoView implements Observer{
   private String fileName;
   private URL url;
   private CarModel model;
   private CarAuctionGUI cg;

   public CarFileInfoView(CarModel cmodel,CarAuctionGUI cg){
      model = cmodel;
	  this.cg=cg;
   }

   public void update(Observable subject){
      if ((subject == model) && (model.isSearchBtnClicked())){
	     URL url = model.getCarFileURL();
		 cg.setCarFileToEditorPane(url);
       }
	}
}

