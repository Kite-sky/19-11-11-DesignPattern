
import java.awt.Color;


public class GreenLight extends TrafficLight{

	   public GreenLight() {
		  state = GREEN;
	   }

	  public Color setColor(){
			 return Color.green;
	   }
	   public void performTask() {
		   Surveillance.takePictures();
		   Surveillance.doStatistics();
		   changeState();
	   }
	    public void changeState(){
	   		  state = YELLOW;
	   		  TrafficLight stateObj = new YellowLight();
	   		  cxt.setStateObj(stateObj);
	    }
}


