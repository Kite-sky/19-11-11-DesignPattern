import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ClientUI extends JFrame{
   private static final String CONNECT = "Create Connection";
   private static final String EXIT = "Exit";
   private JTextField txtInstruction;
   private SingleLogonGUI  objLogon = null;

   public ClientUI() {
      super("ClientUI - Singleton Pattern");
      JButton btnConnect = new JButton(CONNECT);
      JButton btnExit = new JButton(EXIT);
      btnConnect.setMnemonic(KeyEvent.VK_S);
      btnExit.setMnemonic(KeyEvent.VK_X);

      ButtonHandler vf = new ButtonHandler();
      btnConnect.addActionListener(vf);
      btnExit.addActionListener(vf);
      JPanel buttonPanel = new JPanel();
      buttonPanel.setBackground(Color.green);
      buttonPanel.add(btnConnect);
      buttonPanel.add(btnExit);

      txtInstruction = new JTextField("Click to get a connection");
      txtInstruction.setBackground(Color.green);
      Container contentPane = getContentPane();
      contentPane.setLayout(new BorderLayout());
      contentPane.add(buttonPanel, "South");
      contentPane.add(txtInstruction, "Center");
      setSize(320, 120);
      setVisible(true);
   }
   private void issueWarning(){
       txtInstruction.setText("Error. You cannot start a second connection.");
	}
   class ButtonHandler implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals(EXIT)) {
            System.exit(1);
         }
         else if (e.getActionCommand().equals(CONNECT)) {
			 if(objLogon == null)
			      objLogon = SingleLogonGUI.getInstance();
			 else
			 	  issueWarning();
      }
    }
  }
  public static void main(String[]  args) {
	     ClientUI connection = new  ClientUI();
  }
}// end of class

