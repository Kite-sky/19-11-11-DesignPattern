
import java.awt.Color;

public class Context {
      private TrafficLight light, redLight, greenLight, yellowLight;
      private String state;

      public Context(TrafficLight lt){
	       light = lt;
	       //Apart from the three light objects,
	       //no new other light object will be created
	       redLight = new RedLight();
	       greenLight = new GreenLight();
	       yellowLight = new YellowLight();
      }

      public String getLightState() {
	       return light.getCurrentState();
      }
      public Color getColor(){
           return light.setColor();
      }
      public void doAction() {
		   light = setupStateObj();
           light.performTask();
      }
      // Called by the concrete light state to
      // update the state object in this class
      public void setState(String st){
		   state = st;
	  }
	  // This method is repeatedly called by the
	  // doAction method inside this class
	  public TrafficLight setupStateObj(){
	  		   if( state.equals(TrafficLight.RED)){
	  			   light =  redLight;
	  			   light.setupContext(this);
			   }
	  		   else if( state.equals(TrafficLight.GREEN)){
	  			   light = greenLight;
	  			   light.setupContext(this);
			   }
	  		   else if(state.equals(TrafficLight.YELLOW)){
	  			   light = yellowLight;
	  			   light.setupContext(this);
			   }
	  		   return light;
    }
}
