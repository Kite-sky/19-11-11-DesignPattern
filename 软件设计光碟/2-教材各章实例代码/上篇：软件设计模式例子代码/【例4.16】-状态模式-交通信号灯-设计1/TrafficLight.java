
import java.awt.Color;


public abstract class TrafficLight{
    protected String state=null;
    protected TrafficLight traffLight = null;
    public static final String RED = "Red";
    public static final String YELLOW = "Yellow";
    public static final String GREEN = "Green";
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

