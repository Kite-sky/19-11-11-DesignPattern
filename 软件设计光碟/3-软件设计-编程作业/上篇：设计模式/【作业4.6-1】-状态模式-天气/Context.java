import java.awt.Color;
import javax.swing.ImageIcon;
//========================================================
//Characteristics of this implementation
//1)The constructor of class Context has no parameter.
//   The purpose is that the client class, when use class
//   Context, it doesn't need to create any object of the
//   WeatherState class. Or, the client class doesn't have to
//   know the existence of the WeatherState class
//2)Context class only calls the WeatherState class, and the
//   WeatherState class never calls class Context
//3)This design is totally extenssible. When adding a new state
//   The only thing to do: add a new subclass, and modify methods
//   changeState(), and createStateObj(). You don't need to change
//   class StateAnimatGUI and Context class
//========================================================

public class Context{

   private WeatherState state;

   public Context(){
	  state = new SunnyState();
   }

   //This method is called by the client class to show the
   //current state in a String format
   public String getWeatherState() {
	  return state.getCurrentState();
   }
   //This method is called by the client class to show the
   //color in a String format
   public Color getColor() {
   	  return state.setColor();
   }

   //This method is called by the client class to get the
   //image icon, which will be displayed on the screen
   public ImageIcon getImgIcon(){
   	  return state.setImgIcon();
   }
   //No conditional statements here. Better for extention;
   //Add a new state will not need to change any code here.
   public String doAction(){
	  state.changeState();
	  state = state.createStateObj();
      String voice = state.act();
      return voice;
   }
}
