
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;

class Controller implements ActionListener{
   private CarAuctionGUI objCarGui;
   private CarModel cm;
   private CarGUIView civ;
   private CarBitView cb;
   private String carPrice;
   private String[] carList;

   public Controller(CarAuctionGUI objCarGui,CarModel cm,
                     CarGUIView civ,CarBitView cb){
      this.objCarGui = objCarGui;
      this.cm=cm;
      this.civ=civ;
      this.cb=cb;

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
         cm.setCarFileURL();
         cm.setupImageIcon();
         cm.tell(civ);
      }
      if (e.getActionCommand().equals(CarAuctionGUI.BIT)){
	     carPrice = objCarGui.getBitPrice();
		 cm.setBitPrice(carPrice);
         cm.tell(cb);
	  }
   }
} // End of class Controller

