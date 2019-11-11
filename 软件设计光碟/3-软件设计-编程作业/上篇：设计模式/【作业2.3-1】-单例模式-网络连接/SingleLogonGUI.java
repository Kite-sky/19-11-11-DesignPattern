import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*==================================================*/
// This is a sigleton class, only one instance of the class can be created.
// To use this class, you cannot use constructor because it has been
// claimed private. You can only use the static method getInstance(),
// which, in case if the instance doesent exist, will create and return an
// instance of LogonGUI to the client class. otherwise, if an instance of
// LogonGUI has already been created before, this method will just
// return that instance to the client class.
/*==================================================*/
public class SingleLogonGUI extends JFrame {
   public static final String LOGON = "Log On";
   public static final String EXIT = "Exit";
   private String USERNM="mikesun";
   private String PASSWD = "opensesame";
   private JTextField txtUser;
   private JTextField txtPassWord;
   private static SingleLogonGUI instance = null;
   private JTextField txtInstruction;

   private SingleLogonGUI() {
	    super("SingleLogonGUI - Singleton");
	    initializeGUI();
    }
    public static SingleLogonGUI getInstance() {
	      if (instance == null)
		      instance = new SingleLogonGUI();
		  return instance;
    }
   public void initializeGUI()  {
      JLabel lblUsrName = new JLabel("User Name");
      JLabel lblPassWord = new JLabel("Password");
      txtUser = new JTextField(USERNM);
      txtPassWord = new JTextField(PASSWD);
      JButton btnLogon = new JButton(LOGON);
      btnLogon.setMnemonic(KeyEvent.VK_S);
      JButton btnExit = new JButton(EXIT);
      btnExit.setMnemonic(KeyEvent.VK_X);
      ButtonHandler vf = new ButtonHandler();
      btnLogon.addActionListener(vf);
      btnExit.addActionListener(vf);
      JPanel buttonPanel = new JPanel();
      GridBagLayout gridbag = new GridBagLayout();
      buttonPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      buttonPanel.add(lblUsrName);
      buttonPanel.add(txtUser);
      buttonPanel.add(lblPassWord);
      buttonPanel.add(txtPassWord);
      buttonPanel.add(btnLogon);
      buttonPanel.add(btnExit);
      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblUsrName, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(txtUser, gbc);
      gbc.gridx = 0;
	  gbc.gridy = 1;
	  gridbag.setConstraints(lblPassWord, gbc);
	  gbc.anchor = GridBagConstraints.WEST;
	  gbc.gridx = 1;
	  gbc.gridy = 1;
      gridbag.setConstraints(txtPassWord, gbc);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 40;
      gbc.gridx = 0;
      gbc.gridy = 6;
      gridbag.setConstraints(btnLogon, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 6;
      gridbag.setConstraints(btnExit, gbc);

      Container contentPane = getContentPane();
      contentPane.add(buttonPanel, BorderLayout.CENTER);
      txtInstruction = new JTextField();
      txtInstruction.setBackground(Color.pink);

      contentPane.add( txtInstruction, BorderLayout.NORTH);
      setSize(320, 200);
      setVisible(true);
   }
   public boolean isValideCustomer() {
	  String usr = txtUser.getText();
	  String pwd = txtPassWord.getText();
	  if(usr.equals(USERNM) && pwd.equals(PASSWD))
            return true;
      else
      	    return false;
   }
   private void issueWarning(){
         txtInstruction.setText("Invalide user name or password.");
	}
   private void issueSuccess(){
	     txtInstruction.setText("You have been successfully connected to the web.");
	}
   class ButtonHandler implements ActionListener  {
      public void actionPerformed(ActionEvent e) {
         if (e.getActionCommand().equals(EXIT)) {
            System.exit(1);
         }
         if (e.getActionCommand().equals(LOGON)) {
			 boolean isValideCus = isValideCustomer();
             if(isValideCus == false){ //logon failed
                 issueWarning();
			 }
             else{ //logon successfully
				 issueSuccess();
		     }
      }
    }
  }
}// end of class

