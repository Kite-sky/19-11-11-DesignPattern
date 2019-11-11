import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollPane;

/*==============================================*/
/* A client GUI for testing the state pattern.  */
/*==============================================*/
public class TaxClientGUI extends JPanel{
   private JSplitPane splitPane;
   private JScrollPane textPane;
   private JTextArea taxInfoTextArea;
   private JPanel btnPanel;
   private JComboBox cmbTaxType;
   private JTextField txtTaxable;
   private JTextField txtName;
   private JLabel lblName;
   private JLabel lblTaxType;
   private JLabel lblTaxable;
   public static final String SINGLE = "Single";
   public static final String FAMILY = "Family";
   public static final String SUBMIT = "Submit";
   public static final String EXIT = "Exit";

   private TaxContext contextObj;

   public TaxClientGUI(){
	  super(new GridLayout(1,0));
      buildUpScrollGUI();
   }
   private void buildUpScrollGUI(){
	  setUpButtonPanel();
      taxInfoTextArea = new JTextArea(8, 2);
	  textPane = new JScrollPane(taxInfoTextArea);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, btnPanel, textPane);
	  splitPane.setDividerLocation(160);
	  add(splitPane);
	  setSize(new Dimension(600, 500));
   }
   private void setUpButtonPanel(){
      cmbTaxType = new JComboBox();
      cmbTaxType.addItem(SINGLE);
      cmbTaxType.addItem(FAMILY);

      txtTaxable = new JTextField(13);
      txtName = new JTextField(13);

      lblName = new JLabel("Tax Payer Name:");
      lblTaxType = new JLabel("Tax Type:");
      lblTaxable = new JLabel("Taxable Amount:");

      JButton submitButton = new JButton(SUBMIT);
      submitButton.setMnemonic(KeyEvent.VK_S);
      JButton exitButton = new JButton(EXIT);
      exitButton.setMnemonic(KeyEvent.VK_X);

      ButtonListener listener = new ButtonListener();
      submitButton.addActionListener(listener);
      exitButton.addActionListener(listener);

      btnPanel = new JPanel();
      GridBagLayout gridbag = new GridBagLayout();
      btnPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      btnPanel.add(lblName);
      btnPanel.add(txtName);
      btnPanel.add(lblTaxType);
      btnPanel.add(cmbTaxType);
      btnPanel.add(lblTaxable);
      btnPanel.add(txtTaxable);
      btnPanel.add(submitButton);
      btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblName, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(txtName, gbc);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblTaxType, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(cmbTaxType, gbc);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 2;
      gridbag.setConstraints(lblTaxable, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 2;
      gridbag.setConstraints(txtTaxable, gbc);
      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 25;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 3;
      gridbag.setConstraints(submitButton, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 3;
      gridbag.setConstraints(exitButton, gbc);
   }

  public String getName(){
     return txtName.getText();
  }
  public String getTaxType(){
     return (String) cmbTaxType.getSelectedItem();
  }
  public String getTaxableAmount(){
     return txtTaxable.getText();
  }
  class ButtonListener implements ActionListener {
     public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals(EXIT)){
           System.exit(1);
        }
        if (e.getActionCommand().equals(SUBMIT)){
    	   double taxPaid = 0;
    	   String taxDegree = null;

    	   String name = getName();
    	   String type = getTaxType();
    	   String amount =  getTaxableAmount();
    	   double amt = new Double(amount).doubleValue();
    	   contextObj = new TaxContext(name,type,amt);

           taxPaid = contextObj.getTax();
           taxDegree = contextObj.getState();

           taxInfoTextArea.setText(name+"\n");
           taxInfoTextArea.append(type+"\n");
           taxInfoTextArea.append("Tax degree = :  " + taxDegree);
           taxInfoTextArea.append("\nTax Amount is:  " + taxPaid);
         }
      }
  }
  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("State Pattern- Tax Calculator");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     TaxClientGUI newContentPane = new TaxClientGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);
     frame.pack();
     frame.setVisible(true);
  }
  static public void main(String argv[]) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable(){
        public void run(){
           createAndShowGUI();
      }  });
  }
}

