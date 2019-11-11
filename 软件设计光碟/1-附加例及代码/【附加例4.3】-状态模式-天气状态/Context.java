import java.awt.Color;
import javax.swing.ImageIcon;

//========================================================
// Characteristics of this implementation
// 1)The constructor of class Context has no parameter.
//    The purpose is that the client class, when use class
//    Context, it doesn't need to create any object of the
//    WeatherState class. Or, the client class doesn't have to
//    know the existence of the WeatherState class
// 2)Super state class WeatherState is responsible for creating objects
//    of its subclasses and whenever the state changes, a subclass will
//    pass the current state object to the Context class, so that the
//    Context class can use it to call the act() method of the state object
// 3)Extenssibility: When adding a new substate, the only thing to do is
//    to modify the method changeState(), and createStateObj() in the
//    super class WeatherState; One deosn't need to modify the
//    Context class or the user interface class StateAnimatGUI
//========================================================

public class Context{
   private WeatherState state;

   public Context(){
	     state = new SunnyState(this);
   }
   public void setStateObj(WeatherState ws){
	     state = ws;
   }
   public String getWeatherState() {
	     return state.getCurrentState();
   }
   public Color getColor() {
   	     return state.setColor();
   }
   public ImageIcon getImgIcon(){
   	     return state.setImgIcon();
   }
   // No conditional statements here. Better for extention
   // Add a new state will not need to change any code here
   public String doAction(){
      String voice = state.act();
      return voice;
   }
}
