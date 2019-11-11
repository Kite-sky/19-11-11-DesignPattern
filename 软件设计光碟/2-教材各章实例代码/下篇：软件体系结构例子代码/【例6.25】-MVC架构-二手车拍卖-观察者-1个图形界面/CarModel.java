import java.io.*;
import java.net.URL;
import java.net.URI;
import javax.swing.*;
import java.util.*;

public class CarModel implements Observable{
    private Vector<Observer> observersList;
    private ImageIcon imgIcon;
    private URL url;
    private String[] carNameList;
	private String carSelected;
    private String bitPrice;
    private boolean isBitBtnClicked = false;
    private boolean isSearchBtnClicked = false;
    static final String CARFILES = "CarFiles/";
    static final String CARIMAGES = "CarImages/";

    public CarModel(){
          observersList = new Vector<Observer>();
          carNameList=new String[200];
  	}
    public void setCarList(String[] cars){
		  carNameList = cars;
	}
    public String[] getCarList(){
	      return  carNameList;
    }
    public void setSelectedCar(String sCar){
          carSelected = sCar;
  	}
  	public String getSelectedCar(){
	      return carSelected;
  	}
  	public void setBitPrice(String bPrice){
		  bitPrice = "";
		  bitPrice = bitPrice + bPrice;
	}
	public String getBitPrice(){
		  return bitPrice;
	}
	public void setFileUrl(){
	      try{
		        String fileURLStr = CARFILES + carSelected+ ".html";
		        URI uri = (new File(fileURLStr)).toURI();
		        url = uri.toURL();
		  }
		  catch (IOException e){
		        e.printStackTrace();
		 }
	}
	public URL getCarFileURL(){
		 return url;
	}
    public void setupImageIcon(){
	     String iconStr = CARIMAGES + carSelected+".jpg";
         imgIcon = createImageIcon(iconStr);
	}
    public ImageIcon getImageIcon(){
	     return imgIcon;
	}
    public void setBitBtnClickInfo(boolean opt){
	     isBitBtnClicked = opt;
	}
	public boolean isBitBtnClicked(){
	     return isBitBtnClicked;
	}
    public void setSearchBtnClickInfo(boolean opt){
	     isSearchBtnClicked = opt;
	}
	public boolean isSearchBtnClicked(){
	     return isSearchBtnClicked;
	}
    public void register(Observer obs){
	     observersList.addElement(obs);
    }
    public void notifyObservers() {
         for (int i = 0; i < observersList.size(); i++) {
              Observer observer = (Observer) observersList.get(i);
			  observer.update(this);
         }
    }
    protected ImageIcon createImageIcon(String path){
         java.net.URL imgURL = getClass().getResource(path);
         if (imgURL != null) {
               return new ImageIcon(imgURL);
         }
         else {
              System.err.println("Couldn't find file: " + path);
              return null;
         }
   }
}