
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

class Controller implements ActionListener {
   private CarAuctionGUI objCarGUI;
   private CarModel cm;
   private CarGUIInfoView civ;
   private CarBitInfoView cb;
   private String carPrice;

   public Controller(CarAuctionGUI objGui,CarModel cmodel,
                     CarGUIInfoView cgiv,
                     CarBitInfoView cbiv) {

      objCarGUI = objGui;
      cm=cmodel;
      civ=cgiv;
      cb=cbiv;

	  String[] cars = objGui.getCarList();
	  cm.setCarList(cars);
   }
   public void actionPerformed(ActionEvent e){
      String searchResult = null;

      if (e.getActionCommand().equals(CarAuctionGUI.EXIT)){
         System.exit(1);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.SEARCH)){
         String selectedCar = objCarGUI.getSelectedCar();
         cm.setSelectedCar(selectedCar);
         cm.setCarFileUrl();
         cm.setupImageIcon();

         cm.setSearchBtnClickInfo(true);
         cm.notifyObservers();
         cm.setSearchBtnClickInfo(false);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.BIT)){
	     carPrice = objCarGUI.getBitPrice();
		 cm.setBitPrice(carPrice);

		 cm.setBitBtnClickInfo(true);
		 cm.notifyObservers();
		 cm.setBitBtnClickInfo(false);

	  }
   }
} // End of class Controller

