import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;


public class ZipCodeTester extends JFrame {

   public static final String VALIDATE = "Validate";
   public static final String EXIT = "Exit";

   private JTextField txtZip;
   private JLabel lblCountry, lblState, lblZip;
   private JComboBox cmbCountry, cmbProvince;
   private JLabel lblResult, lblResultValue;

   public ZipCodeTester() {
      super(" Adapter Pattern - Example ");
	  txtZip = new JTextField(22);

      cmbCountry = new JComboBox();
      cmbCountry.addItem(Customer.US);
      cmbCountry.addItem(Customer.CANADA);
      cmbCountry.addItem(Customer.CHINA);
      cmbCountry.addActionListener(new ChoiceListener());

      cmbProvince = Provinces.getPrvcList("USA");

      lblCountry = new JLabel("Country:");
      lblState = new JLabel("State/Province:");
      lblZip = new JLabel("Zip/PostalCode:");
      lblResult = new JLabel("Result:");
      lblResultValue = new JLabel("Click the Validate Button");

      JButton validateButton = new JButton(ZipCodeTester.VALIDATE);
      validateButton.setMnemonic(KeyEvent.VK_V);
      JButton exitButton = new JButton(ZipCodeTester.EXIT);
      exitButton.setMnemonic(KeyEvent.VK_X);

      ButtonHandler objButtonHandler = new ButtonHandler(this);

      validateButton.addActionListener(objButtonHandler);
      exitButton.addActionListener(new ButtonHandler());

      JPanel UIPanel = new JPanel();
      //****************************************************
      GridBagLayout gridbag = new GridBagLayout();
      UIPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      UIPanel.add(lblZip);
      UIPanel.add(txtZip);
      UIPanel.add(lblState);
      UIPanel.add(lblCountry);
      UIPanel.add(cmbCountry);
      UIPanel.add(cmbProvince);
      UIPanel.add(lblResult);
      UIPanel.add(lblResultValue);
      UIPanel.add(validateButton);
      UIPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;
      gbc.anchor = GridBagConstraints.WEST;

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblCountry, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbCountry, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblState, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(cmbProvince, gbc);
      gbc.gridx = 0;
	  gbc.gridy = 2;
	  gridbag.setConstraints(lblZip, gbc);
	  gbc.gridx = 1;
	  gbc.gridy = 2;
      gridbag.setConstraints(txtZip, gbc);
      gbc.gridx = 0;
      gbc.gridy = 3;
      gridbag.setConstraints(lblResult, gbc);
      gbc.gridx = 1;
      gbc.gridy = 3;
      gridbag.setConstraints(lblResultValue, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 40;

      JPanel buttonPanel = new JPanel();
      buttonPanel.add(validateButton);
      buttonPanel.add(exitButton);
      UIPanel.add(buttonPanel);
      gbc.gridx = 1;
      gbc.gridy = 6;
      gridbag.setConstraints(buttonPanel, gbc);

      Container contentPane = getContentPane();
      contentPane.add(UIPanel, BorderLayout.CENTER);

      try {
         UIManager.setLookAndFeel(new WindowsLookAndFeel());
            SwingUtilities.updateComponentTreeUI(
            ZipCodeTester.this);
      } catch (Exception ex) {
         System.out.println(ex);
     }
  }

  class ChoiceListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		ZipCodeTester.this.cmbProvince.removeAllItems();
		if( cmbCountry.getSelectedItem().equals(Customer.CANADA)){
			cmbProvince = Provinces.getPrvcList("Canada");
		}
		else if(cmbCountry.getSelectedItem().equals(Customer.US)){
			cmbProvince = Provinces.getPrvcList("USA");
		}
		else if (cmbCountry.getSelectedItem().equals(Customer.CHINA)){
			cmbProvince = Provinces.getPrvcList("China");
		}
	}
  }

 class ButtonHandler implements ActionListener {
  ZipCodeTester objZipCodeTester;
  public void actionPerformed(ActionEvent e) {
    String validationResult = null;

    if (e.getActionCommand().equals(ZipCodeTester.EXIT)) {
      System.exit(1);
    }
    if (e.getActionCommand().equals(ZipCodeTester.VALIDATE)) {
      String zip = objZipCodeTester.getZip();
      String state = objZipCodeTester.getAddrState();
      String country = objZipCodeTester.getCountry();

      //Create a customer object
      Customer objCustomer = new Customer(zip, state,country);

      //Check if the zip code or postal code is valid
      if (objCustomer.isValidZip()) {
         validationResult = "Valid Zip/Postal Code Format ";
      } else {
         validationResult = "Invalid Zip/Postal Code Format";
      }
      objZipCodeTester.setResultValue(validationResult);
    }
  }
  public ButtonHandler() {
  }
  public ButtonHandler(ZipCodeTester inObjZipCodeTester) {
    objZipCodeTester = inObjZipCodeTester;
  }
} // End of class ButtonHandler

  public static void main(String[] args) {
     JFrame frame = new ZipCodeTester();
     frame.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
           System.exit(0);
        }
     }
                           );
    frame.setSize(420, 250);
    frame.setVisible(true);
  }

  public String getZip() {
     return txtZip.getText();
  }
  public String getAddrState() {
	 return (String)cmbProvince.getSelectedItem();
  }
  public String getCountry() {
     return (String) cmbCountry.getSelectedItem();
  }
  public void setResultValue(String str) {
     lblResultValue.setText(str);
  }
}



