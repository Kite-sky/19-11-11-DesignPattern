import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ButtonObserver implements ActionListener  {
      JTextArea txtArea;

      public ButtonObserver(JTextArea txtArea){
		   this.txtArea = txtArea;
	  }
      public void actionPerformed(ActionEvent ae) {
           String act = ae.getActionCommand();
	       if(act.equals(ObservableGUI.RED)) {
		 	    txtArea.setText("I am red");
			    txtArea.setBackground(Color.red);
	       }
	       if(act.equals(ObservableGUI.GREEN)) {
		   	    txtArea.setText("I am green");
		  	    txtArea.setBackground(Color.green);
	       }
	       if(act.equals(ObservableGUI.BLUE)) {
		  	    txtArea.setText("I am bule");
		  	    txtArea.setBackground(Color.blue);
	       }
      }
  }