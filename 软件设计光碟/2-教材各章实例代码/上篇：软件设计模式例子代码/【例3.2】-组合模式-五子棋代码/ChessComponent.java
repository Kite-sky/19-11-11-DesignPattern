
import java.awt.*;


// The Component interface for the composite pattern
public abstract class ChessComponent {
     public abstract void setPosition(int x, int y);
     public abstract int[ ] getPosition();
	 public abstract String showInfo();
	 public abstract int getColor();
}