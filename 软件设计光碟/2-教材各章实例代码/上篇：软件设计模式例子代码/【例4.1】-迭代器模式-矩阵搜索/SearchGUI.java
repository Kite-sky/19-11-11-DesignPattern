import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchGUI extends JPanel{
   private JScrollPane btnPane, searchResultPane;
   private JTextArea txtSearchResult;
   private JSplitPane bigSplitPane, upSplitPane;
   private JPanel downPanel, buttonPanel, searchOptPanel;
   private JComboBox cmbSearchType;
   private ButtonHandler btnHandler;
   static final Dimension minimumSize = new Dimension(230, 200);
   public static final String SUBMIT= "Submit";
   public static final String EXIT = "Exit";
   public static final String SEARCH_BY_EVEN = "Search by Even Number";
   public static final String SEARCH_BY_ODD = "Search by Odd Number";
   public static final String TRAVERSE_CIRCULARLY = "Traverse CIrcularly";
   public static final String BLANK = "Choose Search Type";
   Matrix matrix;

   public SearchGUI(){
      super(new GridLayout(1,0));
	  txtSearchResult=new JTextArea(6, 30);
	  txtSearchResult.setFont(new Font("Arial", Font.BOLD, 12));
	  txtSearchResult.setLineWrap(true);
      txtSearchResult.setBackground(Color.pink);
      txtSearchResult.setText(" Search result will be shown here");
      btnHandler = new ButtonHandler();
      setupLowerPanel();
	  setupUpperLeftPanel();
      buildUpScrollGUI();
      inputAndShowData();
   }
   private void setupLowerPanel(){
      downPanel = new JPanel();
      downPanel.setBackground(Color.gray);
	  JButton btnSubmit = new JButton(SearchGUI.SUBMIT);
	  btnSubmit.setMnemonic(KeyEvent.VK_G);
	  JButton btnExit = new JButton(SearchGUI.EXIT);
	  btnExit.setMnemonic(KeyEvent.VK_X);
	  btnSubmit.addActionListener(btnHandler);
	  btnExit.addActionListener(btnHandler);
      downPanel.add(btnSubmit);
      downPanel.add(btnExit);
   }
   private void setupUpperLeftPanel(){
      cmbSearchType = new JComboBox();
      cmbSearchType.addItem(BLANK);
      cmbSearchType.addItem(SEARCH_BY_EVEN);
      cmbSearchType.addItem(SEARCH_BY_ODD);
      cmbSearchType.addItem(TRAVERSE_CIRCULARLY);

      JLabel lblHouseType = new JLabel("House Type:");
      JLabel lblHouseOptions = new JLabel("Options:");
      cmbSearchType.addActionListener(btnHandler);

      //For layout purposes, put the buttons in a separate panel
      buttonPanel = new JPanel();
      // searchOptPanel is used for loading another panel dynamically
      searchOptPanel = new JPanel();
      searchOptPanel.setPreferredSize(new Dimension(250, 180));

      GridBagLayout gridbag = new GridBagLayout();
      buttonPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();
      buttonPanel.add(cmbSearchType);
      buttonPanel.add(searchOptPanel);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.left = 1;
      gbc.insets.right = 5;
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbSearchType, gbc);
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(searchOptPanel, gbc);
   }
   public void showSearchResult(String str){
      txtSearchResult.setText(str);
   }
   public String getSearchType(){
      return (String) cmbSearchType.getSelectedItem();
   }
   public  String searchForProduct(NumberIterator iterator){
   	  String nums = "\n\n=== New Search. Result: === \n";
      while (iterator.hasNext()){
   	     int s = iterator.next();
   	     nums = nums + s + "   ";
      }
      return nums;
   }
   public void inputAndShowData( ){
       JTextArea txt = new  JTextArea();
       txt.setFont(new Font("Arial", Font.BOLD, 14));
       matrix = new Matrix();
       int len = matrix.getLength();
       int[][] mtrx = matrix.getMatrixData() ;
       for(int i = 0; i < len; i++){
	   			 for(int j = 0; j < len; j++){
	   				  txt.append(""+ mtrx[i][j]+ " "  );
	   			 }
	   			  txt.append("\n");
		 }
        searchOptPanel.add(txt);
        searchOptPanel.validate();
        validate();
   }
   private void buildUpScrollGUI(){
      btnPane = new JScrollPane(buttonPanel);
	  btnPane.setMinimumSize(minimumSize);
	  searchResultPane = new JScrollPane(txtSearchResult);

	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setDividerLocation(280);
	  upSplitPane.setPreferredSize(new Dimension(600, 200));
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(searchResultPane);

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, downPanel);
	  bigSplitPane.setDividerLocation(200);

	  add(bigSplitPane);
	  setSize(new Dimension(600, 300));
      setVisible(true);
  }
  private static void createAndShowGUI(){
     JFrame.setDefaultLookAndFeelDecorated(true);
     JFrame frame = new JFrame("Iterator Pattern-Sales Infor Search");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     SearchGUI newContentPane = new SearchGUI();
     newContentPane.setOpaque(true);
     frame.setContentPane(newContentPane);
     frame.pack();
     frame.setVisible(true);
  }
  static public void main(String argv[]){
	 javax.swing.SwingUtilities.invokeLater(new Runnable(){
	    public void run() {
		   createAndShowGUI();
		}  });
  }
  class ButtonHandler implements ActionListener{
        String selection = null;
        NumberIterator iterator;
        public void actionPerformed(ActionEvent e) {
			selection = getSearchType();
			if (e.getActionCommand().equals(EXIT)) {
			   System.exit(1);
			}
			if (e.getActionCommand().equals(SUBMIT)) {
			   if(selection.equals(SEARCH_BY_EVEN) ){
				  iterator = matrix.createEvenNumIterator() ;
				}
				else if(selection.equals(SEARCH_BY_ODD) ){
				  iterator = matrix.createOddNumIterator() ;
				}
				else if(selection.equals(TRAVERSE_CIRCULARLY) ){
				  iterator = matrix.createCircularIterator() ;
				}
				String selectedNums = searchForProduct(iterator);
				showSearchResult(selectedNums);
			}
     }
  }
}
