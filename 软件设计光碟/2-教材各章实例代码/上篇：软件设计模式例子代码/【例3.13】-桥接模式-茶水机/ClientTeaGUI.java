import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.sun.java.swing.plaf.windows.*;

public class ClientTeaGUI extends JFrame {
  public static final String FINDPRICE = "Find Price";
  public static final String EXIT = "Exit";
  public static final String SUPERCUP = "Super Cup";
  public static final String MEDIUMCUP = "Medium Cup";
  public static final String REDTEA = "Red Tea";
  public static final String GREENTEA = "Green Tea";

  private JLabel lblCupSize,lblTeaKind,lblTeaPrice,lblChosenTeaPrice;
  private JComboBox cmbCupSize, cmbTeaKind;
  private JButton findBtn, exitButton;

  public ClientTeaGUI() {
    super(" Bridge Pattern: Tea Seller Machine ");

    cmbCupSize = new JComboBox();
    cmbCupSize.addItem(SUPERCUP);
    cmbCupSize.addItem(MEDIUMCUP);

    cmbTeaKind = new JComboBox();
	cmbTeaKind.addItem(REDTEA);
    cmbTeaKind.addItem(GREENTEA);

    lblCupSize = new JLabel("Choose Cup Size");
    lblTeaKind = new JLabel("Choose Tea Kind");
    lblTeaPrice = new JLabel("Tea Price:");
    lblChosenTeaPrice = new JLabel("Tea Price will be shown here");

    //Create the open button
    findBtn = new JButton(FINDPRICE);
    findBtn.setMnemonic(KeyEvent.VK_V);
    exitButton = new JButton(EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonListener objButtonListener = new ButtonListener();

    findBtn.addActionListener(objButtonListener);
    exitButton.addActionListener(new ButtonListener());

    JPanel buttonPanel = new JPanel();
	buttonPanel.add(findBtn);
	buttonPanel.add(exitButton);

    JPanel UIPanel = new JPanel();

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    UIPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    UIPanel.add(lblCupSize);
    UIPanel.add(cmbCupSize);
    UIPanel.add(lblTeaKind);
    UIPanel.add(cmbTeaKind);
    UIPanel.add(lblTeaPrice);
    UIPanel.add(lblChosenTeaPrice);
    UIPanel.add(buttonPanel);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;
    gbc.anchor = GridBagConstraints.WEST;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblCupSize, gbc);
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbCupSize, gbc);

    gbc.gridx = 0;
    gbc.gridy = 1;
	gridbag.setConstraints(lblTeaKind, gbc);
	gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(cmbTeaKind, gbc);
    gbc.gridx = 0;
	gbc.gridy = 2;
	gridbag.setConstraints(lblTeaPrice, gbc);
    gbc.gridx = 1;
	gbc.gridy = 2;
	gridbag.setConstraints(lblChosenTeaPrice, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    gbc.gridx = 1;
    gbc.gridy = 5;
    gridbag.setConstraints(buttonPanel, gbc);

    Container contentPane = getContentPane();
    contentPane.add(UIPanel, BorderLayout.CENTER);

    try {
      UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        ClientTeaGUI.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new ClientTeaGUI();
    frame.addWindowListener(new WindowAdapter() {
          public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }     );
    frame.setSize(350, 300);
    frame.setVisible(true);
  }

  public String getTeaSize() {
     return (String) cmbCupSize.getSelectedItem();
  }
  public String getTeaKind() {
     return (String) cmbTeaKind.getSelectedItem();
  }

  class ButtonListener implements ActionListener {

     TeaKind tKind;
     TeaSize tSize;

     public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(EXIT)) {
        System.exit(1);
     }
     if (e.getActionCommand().equals(FINDPRICE)) {

        String size = getTeaSize();
        String kind = getTeaKind();

        //Create a customer object
        if( kind.compareTo(GREENTEA)==0 )
	       tKind = new GreenTea();
	    if( kind.compareTo(REDTEA)==0 )
           tKind = new RedTea();
        if(size.compareTo(SUPERCUP)==0)
           tSize = new SuperCup(tKind);
        if(size.compareTo(MEDIUMCUP)==0)
           tSize = new MediumCup(tKind);

        float price = tSize.getPrice();
        lblChosenTeaPrice.setText("" + price + "  dollars");
     }
    }
  } // End of class ButtonListener
}

