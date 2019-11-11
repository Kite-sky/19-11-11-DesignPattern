
import java.awt.Color;

public class Context {
      private TrafficLight light;

	 public Context(){
		  light = new RedLight();
      }
      public String getLightState() {
	       return light.getCurrentState();
      }
      public Color getColor(){
           return light.setColor();
      }
      public void doAction() {
           light.performTask();
           light = light.createStateObj();
      }
}
