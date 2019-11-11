
import java.awt.Color;


public abstract class TrafficLight{
    protected String state=null;
    protected TrafficLight traffLight = null;
    protected final String RED = "Red";
    protected final String YELLOW = "Yellow";
    protected final String GREEN = "Green";

    public void changeState(){
		   if( state.compareTo(RED) == 0)
			  state = GREEN;
		   else if( state.compareTo(GREEN) == 0)
			  state = YELLOW;
		   else if(state.compareTo(YELLOW) == 0)
			  state = RED;
	}
	public TrafficLight createStateObj(){
		   if( state.compareTo(RED) == 0)
			  traffLight = new RedLight();
		   else if( state.compareTo(GREEN) == 0)
			  traffLight = new GreenLight();
		   else if(state.compareTo(YELLOW) == 0)
			  traffLight = new YellowLight();
		   return traffLight;
    }
    public String getCurrentState(){
	       return state;
    }

    public abstract void performTask();
    public abstract Color setColor();
}

