import java.awt.Color;
import javax.swing.ImageIcon;

public class WindyState extends WeatherState{
   public WindyState(){
	   state = WINDY;
   }
   public String getCurrentState(){
       return state;
   }
   public String act() {
	   String voice = " Strong wind is blowing...";
	   return voice;
   }
   public Color setColor(){
       return Color.yellow;
   }
   public ImageIcon setImgIcon(){
       ImageIcon windyIcon = new ImageIcon("images/Windy.jpg");
       return windyIcon;
   }
}

