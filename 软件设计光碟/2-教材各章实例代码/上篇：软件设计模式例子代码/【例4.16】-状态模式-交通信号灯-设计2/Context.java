
import java.awt.Color;

public class Context {
      private TrafficLight light;

      public Context(TrafficLight lt){
	       light= lt;
      }

      public String getLightState() {
	       return light.getCurrentState();
      }
      public Color getColor(){
           return light.setColor();
      }
      public void doAction() {
           light.performTask();
           light.setupContext(this);
      }
      public void setStateObj(TrafficLight st){
		   light= st;
	 }
}
