import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.*;

class NormHouseBuilder extends HouseBuilder{
   public static final String SMALL_AREA = "220 sq meters";
   public static final String BIG_AREA = "330 sq meters";
   public static final String LESS_BEDROOM = "4";
   public static final String MORE_BEDROOM = "6";
   public static final String LESS_BATHROOM = "2";
   public static final String MORE_BATHROOM = "4";
   public static final String SMALL_GARAGE = "2-car garage";
   public static final String BIG_GARAGE = "3-car garage";
   public static final String SMALL_GARDEN = "40-Sqm garden";
   public static final String BIG_GARDEN = "60-Sqm garden";
   public static final String NORMAL_TYPE = "Normal-type house";


   public NormHouseBuilder(){
      area = null;
      bedroom = null;
      bathroom = null;
      garage = null;
      garden = null;
      swimmingPool = null;
   }
   public void addUIComponents(){
      houseGUI = new JPanel();
  	  houseGUI.setLayout(new GridLayout(5,3));
	  JLabel label1 = new JLabel("Area:");
	  JLabel label2 = new JLabel("Bed room number:");
	  JLabel label3 = new JLabel("Bathroom number:");
	  JLabel label4 = new JLabel("Garage type:");
	  JLabel label5 = new JLabel("Garden type:");

	  JRadioButton areaBtn1 = new JRadioButton(SMALL_AREA);
	  JRadioButton areaBtn2 = new JRadioButton(BIG_AREA);
	  JRadioButton bedroomBtn1 = new JRadioButton(LESS_BEDROOM);
	  JRadioButton bedroomBtn2 = new JRadioButton(MORE_BEDROOM);
	  JRadioButton bathroomBtn1 = new JRadioButton(LESS_BATHROOM);
	  JRadioButton bathroomBtn2 = new JRadioButton(MORE_BATHROOM);
	  JRadioButton grageBtn1 = new JRadioButton(SMALL_GARAGE);
	  JRadioButton grageBtn2 = new JRadioButton(BIG_GARAGE);

	  JRadioButton gardenBtn1 = new JRadioButton(SMALL_GARDEN);
	  JRadioButton gardenBtn2 = new JRadioButton(BIG_GARDEN);

	  ButtonGroup areaGroup = new ButtonGroup();
	  ButtonGroup bedroomGroup = new ButtonGroup();
	  ButtonGroup bathroomGroup = new ButtonGroup();
	  ButtonGroup garageGroup = new ButtonGroup();
	  ButtonGroup gardenGroup = new ButtonGroup();

	  areaGroup.add(areaBtn1);
	  areaGroup.add(areaBtn2);
	  bedroomGroup.add(bedroomBtn1);
	  bedroomGroup.add(bedroomBtn2);
	  bathroomGroup.add(bathroomBtn1);
	  bathroomGroup.add(bathroomBtn2);
	  garageGroup.add(grageBtn1);
	  garageGroup.add(grageBtn2);

	  gardenGroup.add(gardenBtn1);
	  gardenGroup.add(gardenBtn2);

	  houseGUI.add(label1);
      houseGUI.add(areaBtn1);
	  houseGUI.add(areaBtn2);
	  houseGUI.add(label2);
	  houseGUI.add(bedroomBtn1);
	  houseGUI.add(bedroomBtn2);
	  houseGUI.add(label3);
	  houseGUI.add(bathroomBtn1);
	  houseGUI.add(bathroomBtn2);
	  houseGUI.add(label4);
	  houseGUI.add(grageBtn1);
	  houseGUI.add(grageBtn2);
      houseGUI.add(label5);
	  houseGUI.add(gardenBtn1);
	  houseGUI.add(gardenBtn2);

	  areaBtn1.addActionListener(new AreaListener());
	  areaBtn2.addActionListener(new AreaListener());
      bedroomBtn1.addActionListener(new BedroomListener());
      bedroomBtn2.addActionListener(new BedroomListener());
	  bathroomBtn1.addActionListener(new BathroomListener());
	  bathroomBtn2.addActionListener(new BathroomListener());
	  grageBtn1.addActionListener(new GarageListener());
      grageBtn2.addActionListener(new GarageListener());

      gardenBtn1.addActionListener(new GardenListener());
      gardenBtn2.addActionListener(new GardenListener());
  }

  /* Build up a whole object incrementally */
  public void buildType(){
  	 house.setType(NORMAL_TYPE);
  }
  public void buildArea(){
  	 house.setArea(area);
  }
  public void buildBedroom(){
     house.setBedroom(bedroom);
  }
  public void buildBathroom(){
  	 house.setBathroom(bathroom);
  }
  public void buildGarage(){
  	 house.setGarage(garage);
  }
  public void buildGarden(){
  	 house.setGarden(garden);
  }
  public void buildSwimmingpool(){
  	 house.setSwimmingPool(swimmingPool);
  }

  //This method returns user chosen requests
  //as a string to be displayed on screen
  public String getUserRequest(){
     String usrRequest = null;
     if((area==null)||(bedroom==null)||(bathroom==null)
                    ||(garage==null) ||(garden==null)){
        usrRequest = "Incomplete items";
     }
     else{
        usrRequest = NORMAL_TYPE
                     +"\nArea =" + area
                     + "\nBedroom number= " + bedroom
                     + "\nBathroom number = " + bathroom
                     + "\nGarage type = " + garage
                     + "\nGarden=" + garden;
     }
     return usrRequest;
  }
}// end class

