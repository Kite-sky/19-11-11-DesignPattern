import java.awt.Color;
import javax.swing.ImageIcon;


public class SunnyState extends WeatherState {

   public SunnyState(Context c) {
   	   state = SUNNY;
   	   ctxt = c;
   }
   public String getCurrentState(){
      return state;
   }
   public String act() {
	  changeState();
	  createStateObj();
	  ctxt.setStateObj(subState);
	  String voice = "  The sun is shining.";
	  return voice;
   }
   public Color setColor(){
      return Color.green;
   }
   public ImageIcon setImgIcon(){
      ImageIcon sunnyIcon = new ImageIcon("images/Sunny.jpg");
      return sunnyIcon;
   }
}

