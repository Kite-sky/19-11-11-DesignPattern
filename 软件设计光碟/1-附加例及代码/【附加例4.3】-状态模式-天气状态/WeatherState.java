import java.util.Random;
import java.awt.Color;
import javax.swing.ImageIcon;

//===============================================
// As an abstract super class, WeatherState is responsible
// for changing state. The duty has not been assigned to
// the sub classes. To add a new state subclasses will
// requires only modify this class WeatherState
//===============================================
public abstract class WeatherState{
    protected String state;
    protected Context ctxt = null;
    protected WeatherState subState = null;
    protected final String SUNNY = "Sunny";
	protected final String RAINY = "Rainy";
	protected final String WINDY = "Windy";
    private final String[] STATE ={SUNNY, RAINY, WINDY};

    public void changeState() {
	   Random generator = new Random();
	   int n = STATE.length;
	   int randomIndex = generator.nextInt( n );
	   state = STATE[randomIndex];
    }
	public void createStateObj(){
	   if( state.compareTo(SUNNY) == 0)
	      subState = new SunnyState(ctxt);
	   else if( state.compareTo(RAINY) == 0)
	      subState = new RainyState(ctxt);
	   else if(state.compareTo(WINDY) == 0)
	      subState = new WindyState(ctxt);
    }
    public abstract String act();
    public abstract String getCurrentState();
    public abstract Color setColor();
    public abstract ImageIcon setImgIcon();
}

