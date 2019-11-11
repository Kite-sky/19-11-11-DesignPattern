import java.util.Random;
import java.awt.Color;
import javax.swing.ImageIcon;

//===========================================
// As an abstract super class, WomanState is responsible
// for changing state. The duty has not been assigned to
// the sub classes. To add a new state subclasses will
// requires only modify this class WomanState
//===========================================
public abstract class WeatherState{
    protected final String SUNNY = "Sunny";
    protected final String RAINY = "Rainy";
    protected final String WINDY = "Windy";

    protected String state;
    private final String[] MOOD ={SUNNY, RAINY, WINDY};

    public void changeState() {
	   Random generator = new Random();
	   int n = MOOD.length;
	   int randomIndex = generator.nextInt( n );
	   state = MOOD[randomIndex];
    }
    public WeatherState createStateObj(){
	   WeatherState subState = null;
	   if( state.compareTo(SUNNY) == 0)
	      subState = new SunnyState();
	   else if( state.compareTo(RAINY) == 0)
	      subState = new RainyState();
	   else if(state.compareTo(WINDY) == 0)
	      subState = new WindyState();
	   return subState;
    }
    public abstract String act();
    public abstract String getCurrentState();
    public abstract Color setColor();
    public abstract ImageIcon setImgIcon();
}

