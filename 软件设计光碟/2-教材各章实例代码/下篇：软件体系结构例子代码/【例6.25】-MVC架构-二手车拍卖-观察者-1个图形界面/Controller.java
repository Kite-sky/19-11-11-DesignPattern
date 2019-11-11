
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

class Controller implements ActionListener {
   private CarAuctionGUI objCarGui;
   private CarModel cm;
   private String carPrice;
   private String[] carList;

   public Controller(CarAuctionGUI objCarGui, CarModel cm) {
      this.objCarGui = objCarGui;
	  this.cm = cm;

	  carList = objCarGui.getCarList();
	  cm.setCarList(carList);
   }
   public void actionPerformed(ActionEvent e){
      String searchResult = null;

      if (e.getActionCommand().equals(CarAuctionGUI.EXIT)){
         System.exit(1);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.SEARCH)){
         String selectedCar = objCarGui.getSelectedCar();
		 cm.setSelectedCar(selectedCar);
		 cm.setFileUrl();
         cm.setupImageIcon();

         cm.setSearchBtnClickInfo(true);

         cm.notifyObservers();
         cm.setSearchBtnClickInfo(false);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.BIT)){
	     carPrice = objCarGui.getBitPrice();
		 cm.setBitPrice(carPrice);
		 cm.setBitBtnClickInfo(true);

		 cm.notifyObservers();
		 cm.setBitBtnClickInfo(false);
	  }
   }
} // End of class Controller

