import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.awt.event.*;

public class ClientGUI extends JPanel{
   private JEditorPane editorPane;
   private JScrollPane btnPane;
   private JScrollPane imagePane;
   private JScrollPane textPane;
   private JSplitPane upSplitPane;
   private JSplitPane downSplitPane;
   private JSplitPane bigSplitPane;
   private JPanel buttonPanel;
   private JTextArea txtDisplayZodiac;
   private JScrollPane zodiacInfoPane;

   private JLabel imgLabel;
   private JLabel yearlbl = new JLabel("Year");
   private JLabel monthlbl = new JLabel("Month");
   private JLabel datelbl = new JLabel("Date");
   private JComboBox cmbMonthList;
   private JComboBox cmbYearList;
   private JComboBox cmbDateList;
   URL url;

   static final String[] year = new String[72];
   static final String[] month={"1", "2", "3", "4", "5", "6",  "7","8", "9", "10", "11", "12"};
   static final String[] date = new String[31];
   static final String FIND = "Find Zodiac";
   static final String EXIT = "Exit";

   public ClientGUI(){
	  txtDisplayZodiac=new JTextArea("Chinese Zodiac info ", 6, 20);
	  txtDisplayZodiac.setLineWrap(true);
	  buildUpScrollGUI();

	  try {
	  	    url = (new File("ChinaZodiacs.html")).toURL();
	  }
	  catch (IOException e) {
	  	    e.printStackTrace();
      }
	  setFileToEditorPane(url);
   }

   private void buildUpScrollGUI(){
      setUpButtonPanel();

	  imgLabel = new JLabel();
      imgLabel.setBackground(Color.green);
	  imgLabel.setMinimumSize(new Dimension(250, 250));

      editorPane = new JEditorPane();
	  editorPane.setEditable(false);

      imagePane = new JScrollPane(imgLabel);
	  btnPane = new JScrollPane(buttonPanel);
	  textPane = new JScrollPane(editorPane);
	  textPane.setMinimumSize(new Dimension(250, 200));

	  zodiacInfoPane = new JScrollPane(txtDisplayZodiac);

	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setLeftComponent(btnPane);
      upSplitPane.setRightComponent(textPane);
	  downSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  downSplitPane.setLeftComponent(imagePane);
	  downSplitPane.setRightComponent(zodiacInfoPane);
	  downSplitPane.setDividerLocation(150);

	  Dimension minimumSize = new Dimension(130, 100);
	  imagePane.setMinimumSize(minimumSize);
	  btnPane.setMinimumSize(minimumSize);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  upSplitPane.setDividerLocation(230);
	  upSplitPane.setPreferredSize(new Dimension(500, 300));

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downSplitPane);
	  bigSplitPane.setDividerLocation(200);

	  add(bigSplitPane);
	  setSize(new Dimension(400, 400));
      setVisible(true);
  }

  private void setUpButtonPanel(){
	 cmbMonthList = new JComboBox();
	 cmbYearList = new JComboBox();
	 cmbDateList = new JComboBox();

	 for(int j=0; j<72; j++){
		 year[j] = String.valueOf(1948+j);
		 cmbYearList.addItem(year[j]);
	 }
	 for(int k=0; k<12; k++){
		 cmbMonthList.addItem(month[k]);
	 }
	 for(int i=0; i<31; i++){
	 		 date[i] = String.valueOf( i + 1);
	 		 cmbDateList.addItem(date[i]);
	 }
     //Create button objects
     JButton findButton = new JButton(FIND);
     findButton.setMnemonic(KeyEvent.VK_S);
     JButton exitButton = new JButton(EXIT);
     exitButton.setMnemonic(KeyEvent.VK_X);

     ButtonListener btnListener = new ButtonListener();
     findButton.addActionListener(btnListener);
     exitButton.addActionListener(btnListener);

     buttonPanel = new JPanel();
     GridBagLayout gridbag = new GridBagLayout();
     buttonPanel.setLayout(gridbag);
     GridBagConstraints gbc = new GridBagConstraints();

     buttonPanel.add(yearlbl);
     buttonPanel.add(monthlbl);
     buttonPanel.add(datelbl);
     buttonPanel.add(cmbYearList);
     buttonPanel.add(cmbMonthList);
     buttonPanel.add(cmbDateList);
     buttonPanel.add(findButton);
     buttonPanel.add(exitButton);

     gbc.insets.top = 5;
     gbc.insets.bottom = 5;
     gbc.insets.left = 5;
     gbc.insets.right = 5;

     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
     gbc.gridy = 0;
     gridbag.setConstraints(yearlbl, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 0;
	 gridbag.setConstraints(cmbYearList, gbc);
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
     gbc.gridy = 1;
     gridbag.setConstraints(monthlbl, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
	 gbc.gridy = 1;
	 gridbag.setConstraints(cmbMonthList, gbc);
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridx = 0;
	 gbc.gridy = 2;
	 gridbag.setConstraints(datelbl, gbc);
	 gbc.anchor = GridBagConstraints.WEST;
	 gbc.gridx = 1;
	 gbc.gridy = 2;
	 gridbag.setConstraints(cmbDateList, gbc);
     gbc.anchor = GridBagConstraints.EAST;
     gbc.insets.left = 2;
     gbc.insets.right = 2;
     gbc.insets.top = 20;
     gbc.anchor = GridBagConstraints.EAST;

     gbc.gridx = 0;
     gbc.gridy = 4;
     gridbag.setConstraints(findButton, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridx = 1;
     gbc.gridy = 4;
     gridbag.setConstraints(exitButton, gbc);
  }
  public void setImageInfo(ImageIcon imIcon){
     imgLabel.setIcon(imIcon);
     imgLabel.validate();
  }
 public void setFileToEditorPane(URL url){
     try{
        editorPane.setPage(url);
        validate();
     }
     catch (IOException e) {
	    e.printStackTrace();
     }
  }
  public void showZodiacInfo(String zodiacInfo ){
        txtDisplayZodiac.append(zodiacInfo);
  }
  public String getYear() {
    	return (String) cmbYearList.getSelectedItem();
  }
  public String getMonth() {
  	    return (String) cmbMonthList.getSelectedItem();
  }
  public String getDate() {
    	return (String) cmbDateList.getSelectedItem();
  }
  class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals(FIND)) {
				String year = getYear();
				String month = getMonth() ;
				String date = getDate();

				Context context = new Context(year, month, date );
                String saying = context.getZodiacDescription();
                ImageIcon icon =  context.getImageIcon();
                setImageInfo(icon);

				txtDisplayZodiac.setText("");
				showZodiacInfo(saying);
			}
			if (ae.getActionCommand().equals(EXIT)) {
			   System.exit(1);
			}
		}
   }
  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Strategy pattern demo-Chinese Zodiac");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     ClientGUI newContentPane = new ClientGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);

     frame.pack();
     frame.setVisible(true);
  }
  static public void main(String argv[]) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		   createAndShowGUI();
		}
        });
  }
}

