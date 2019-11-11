
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class EconHouseBuilder extends HouseBuilder{
   public static final String SMALL_AREA = "180 sq meters";
   public static final String BIG_AREA = "210 sq meters";
   public static final String LESS_BEDROOM = "2";
   public static final String MORE_BEDROOM = "3";
   public static final String LESS_BATHROOM = "1";
   public static final String MORE_BATHROOM = "2";
   public static final String SMALL_GARAGE = "1-car garage";
   public static final String BIG_GARAGE = "2-car garage";
   public static final String ECONOMY_TYPE = "Economy-type house";

   public EconHouseBuilder(){
	  area = null;
      bedroom = null;
      bathroom = null;
      garage = null;
      garden = null;
      swimmingPool = null;
   }
   public void addUIComponents(){
      houseGUI = new JPanel();
  	  houseGUI.setLayout(new GridLayout(4,3));
	  JLabel label1 = new JLabel("Area:");
	  JLabel label2 = new JLabel("Bed room number:");
	  JLabel label3 = new JLabel("Bathroom number:");
	  JLabel label4 = new JLabel("Garage type:");

	  //Add code here
  }

  /* Build up a whole object incrementally */
  public void buildType(){
	 house.setType(ECONOMY_TYPE);
  }
  public void buildArea(){
	 // Add code here
  }
  public void buildBedroom(){
     // Add code here
  }
  public void buildBathroom(){
	 // Add code here
  }
  public void buildGarage(){
	 // Add code here
  }
  public void buildGarden(){
	 // Add code here
  }
  public void buildSwimmingpool(){
	 // Add code here
  }

  //This method returns user chosen requests
  //as a string to be displayed on screen
  public String getUserRequest(){
	 String usrRequest = null;
	 if((area==null)||(bedroom==null)||(bathroom==null)||(garage==null)){
	    usrRequest = "Incomplete items";
	 }
	 else{
	    usrRequest = ECONOMY_TYPE
                     +"\nArea =" + area
                     +"\nBedroom number= " + bedroom
                     + "\nBathroom number = " + bathroom
                     + "\nGarage type = " + garage;

	 }
     return usrRequest;
  }
}// end class

