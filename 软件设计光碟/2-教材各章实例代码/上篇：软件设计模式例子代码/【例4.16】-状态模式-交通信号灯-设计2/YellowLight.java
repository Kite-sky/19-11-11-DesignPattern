
import java.awt.Color;

public class YellowLight extends TrafficLight{

	   public YellowLight(){
		   state = YELLOW;
	   }

	   public Color setColor(){
			 return Color.yellow;
	   }
	   public void performTask() {
		  Surveillance.takePictures();
		  Surveillance.doStatistics();
		  changeState();
	   }
	    public void changeState(){
	   		  state = RED;
	   		  TrafficLight stateObj = new RedLight();
	   		  cxt.setStateObj(stateObj);
	    }
}

