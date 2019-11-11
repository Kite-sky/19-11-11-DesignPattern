import java.awt.Color;


public class RedLight extends TrafficLight{

	   public RedLight() {
		   state = RED;
	   }

	   public Color setColor(){
		  return Color.red;
	   }

	   public void performTask() {
		   Surveillance.takePictures();
		   Surveillance.doStatistics();
		   changeState();
	   }
}

