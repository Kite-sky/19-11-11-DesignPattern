import java.awt.Color;
import javax.swing.ImageIcon;

public class RainyState extends WeatherState{
   public RainyState(Context c) {
      state = RAINY;
      ctxt = c;
   }
   public String getCurrentState(){
       return state;
   }
   public String act(){
	   changeState();
	   createStateObj();
	   ctxt.setStateObj(subState);
	   String voice = " It is raining now.";
	   return voice;
   }
   public Color setColor(){
      return Color.cyan;
   }
   public ImageIcon setImgIcon(){
      ImageIcon rainyIcon = new ImageIcon("images/Rainy.jpg");
      return rainyIcon;
   }
}


