
import java.awt.Color;


public abstract class TrafficLight{
    protected String state=null;
    protected TrafficLight traffLight = null;
    protected final String RED = "Red";
    protected final String YELLOW = "Yellow";
    protected final String GREEN = "Green";
    protected Context cxt;

    public String getCurrentState(){
	       return state;
    }
    public void setupContext(Context cxt){
		 this.cxt = cxt;
	}

    public abstract void performTask();
    public abstract Color setColor();
    public abstract void changeState();
}

