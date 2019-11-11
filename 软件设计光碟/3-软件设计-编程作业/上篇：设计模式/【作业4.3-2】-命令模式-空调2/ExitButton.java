
import javax.swing.*;

// This is a command class in the command pattern.
// Note that this is actually a JButton class, inside which
// the execute(JPanel panel) method will be called by the
// ButtonInvoker class to exit the program

class ExitButton extends JButton implements Command {
    public ExitButton(String name){
       super(name);
    }

	public void execute(JPanel p){
       System.exit(1);
    }
}