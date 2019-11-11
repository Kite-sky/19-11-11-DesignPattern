import java.io.*;
import java.net.URL;
import java.net.URI;
import javax.swing.*;
import java.util.*;

public class CarModel{
    private String[] carNameList;
    private URL imgURL;
    private URL carFileUrl;
    private ImageIcon imgIcon;
	private String carSelected;
    private String bitPrice;
    static final String CARFILES = "CarFiles/";
    static final String CARIMAGES = "CarImages/";

    public CarModel(){
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
	public void setupImageIcon(){
		    String iconStr = CARIMAGES + carSelected+".jpg";
	        imgIcon = createImageIcon(iconStr);
		}
    public ImageIcon getImageIcon(){
		    return imgIcon;
	}
	public void setCarFileURL(){
	    try{
		    String fileURLStr = CARFILES + carSelected+ ".html";
		    URI uri = (new File(fileURLStr)).toURI();
		    carFileUrl= uri.toURL();
		}
		catch (IOException e){
		    e.printStackTrace();
		}
	}
	public URL getCarFileURL(){
		return carFileUrl;
	}

    protected ImageIcon createImageIcon(String path){
       imgURL = getClass().getResource(path);
       if (imgURL != null) {
           return new ImageIcon(imgURL);
       } else {
           System.err.println("Couldn't find file: " + path);
           return null;
       }
   }
   public void tell(View view){
	    view.update();
   }
} // End of class


