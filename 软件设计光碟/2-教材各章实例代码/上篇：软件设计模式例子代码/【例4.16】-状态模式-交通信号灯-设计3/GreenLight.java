
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
}


