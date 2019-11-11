
import java.awt.event.*;
import javax.swing.*;

  //================================================
  // ButtonInvoker is the Invoker class in the Command pattern.
  // THe design for this invoker takes advantage of the
  // actionPerformed(ActionEvent e) method in the ActionListener
  // interface. This button handler first use getSource to find
  // the button object that has been clicked, then use this
  // concrete button object to call execute method, which is in
  // every Button object. Every button class is a Command class
  // in the Command pattern. By doing this way, the event processing
  // job is dispatched to the concerned button class.
  //================================================

  public class ListenerInvoker implements ActionListener {
	 private JPanel panel;

     public ListenerInvoker( JPanel panel){
		   this.panel = panel;
     }

     public void actionPerformed(ActionEvent e){
		 panel.removeAll();
        Command commandObj = (Command) e.getSource();
        commandObj.execute(panel);
     }
  }