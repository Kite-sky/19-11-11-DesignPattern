

import javax.swing.*;

// This is the command class in the command pattern.
// Note that this is actually a JButton class, inside which
// the execute(JPanel panel) method will be called by the
// ButtonInvoker class to call the concerned methods
// in a receiver class

public class WindowCloseBtn extends JButton implements Command {
     public WindowCloseBtn(String name){
          super(name);
     }
     public void execute(JPanel panel){
         GWindow window = new GWindow(panel);
         window.close();
     }
}
