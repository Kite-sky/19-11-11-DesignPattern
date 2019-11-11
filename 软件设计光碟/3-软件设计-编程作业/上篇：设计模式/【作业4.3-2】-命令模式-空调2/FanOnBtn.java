
import javax.swing.*;

// This is the command class in the command pattern.
// Note that this is actually a JButton class, inside which
// the execute(JPanel panel) method will be called by the
// ButtonInvoker class to call the concerned methods
// in a receiver class

public class FanOnBtn extends JButton implements Command {
     public FanOnBtn(String name){
          super(name);
     }
     public void execute(JPanel panel){
         GFan fan = new GFan(panel);
         fan.startRotate();
     }
}
