import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SearchGUI extends JPanel{
   private JScrollPane btnPane, searchResultPane;
   private JTextArea txtSearchResult;
   private JSplitPane bigSplitPane, upSplitPane;
   private JPanel downPanel, buttonPanel, searchOptPanel;
   private JComboBox cmbSearchType, cmbProductKind;
   private JTextField txtDateFrom;
   private JTextField txtDateTo;
   private static String[] product={"Television","Washing Machine","Microwave Oven"};

   private ButtonHandler btnHandler;
   static final Dimension minimumSize = new Dimension(230, 200);
   public static final String SUBMIT= "Submit";
   public static final String EXIT = "Exit";
   public static final String SEARCH_BY_PRODUCT = "Search by Product ";
   public static final String SEARCH_BY_DATE = "Search by Date";
   public static final String BLANK1 = "Choose Search Type";
   public static final String BLANK2 = "Choose Product";

   public SearchGUI(){
      super(new GridLayout(1,0));
	  txtSearchResult=new JTextArea(6, 30);
	  txtSearchResult.setFont(new Font("Arial", Font.BOLD, 12));
      txtSearchResult.setBackground(Color.pink);
      txtSearchResult.setText(" Search result will be shown here");
      btnHandler = new ButtonHandler();
      setupLowerPanel();
	  setupUpperLeftPanel();
      buildUpScrollGUI();
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
      cmbSearchType.addItem(BLANK1);
      cmbSearchType.addItem(SEARCH_BY_PRODUCT);
      cmbSearchType.addItem(SEARCH_BY_DATE);

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
   public String getProdKind(){
         return (String) cmbProductKind.getSelectedItem();
   }
   public  String searchForProduct(TextFileIterator iterator){
   	  String products = "\n\n=== New Search. Result: === ";
      while (iterator.hasNext()){
   	     SalesDataModel s = iterator.next();
   	     products = products + "\n" + s.getName() + " - "
   		   	                        + s.getProductType() + " - "
   				                    + s.getLocation() + " - "
   				                    + s.getPrice()+ " - "
   				                    + s.getSaleDate();
      }
      float totalPriceSold = iterator.getPriceTotal();
      products = products + "\nTotal amount sold:  " + totalPriceSold + " USD";
      return products;
   }

   public JComboBox getSearchTypeCombox(){
      return cmbSearchType;
   }
   public void displayNewGUI(JPanel panel){
      searchOptPanel.removeAll();
      searchOptPanel.add(panel);
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
     private TextFileIterator iterator = null;
     private TotalSalesInfo saleInfo = new TotalSalesInfo("SaleInfo.txt");

     public void actionPerformed(ActionEvent e) {
		 selection = getSearchType();
        if (e.getActionCommand().equals(EXIT)) {
           System.exit(1);
        }
        if (e.getActionCommand().equals(SUBMIT)) {
		   if(selection.equals(SEARCH_BY_PRODUCT) ){
		      String prodKind = getProdKind();
			  iterator = saleInfo.createTypeIterator(prodKind);
			}
			else if(selection.equals(SEARCH_BY_DATE) ){
			   String startDate = txtDateFrom.getText();
			   String endDate   = txtDateTo.getText();
			   iterator = saleInfo.createDateIterator(startDate,endDate);
			}
			String selectedProducts = searchForProduct(iterator);
			showSearchResult(selectedProducts);
        }
	    if (e.getSource() == getSearchTypeCombox()) {
            selection = getSearchType();
		    if(selection.equals(SEARCH_BY_PRODUCT) )
			   displayNewGUI( getTypePanel(SEARCH_BY_PRODUCT));
		    else if(selection.equals(SEARCH_BY_DATE) )
			   displayNewGUI( getTypePanel(SEARCH_BY_DATE));
		    buttonPanel.repaint();
        }
     }
  }
  private JPanel getTypePanel(String type){
	  JPanel typePanel = new JPanel();
	  if(type.equals( SEARCH_BY_PRODUCT)){
	      cmbProductKind = new JComboBox();
	      cmbProductKind.addItem(BLANK2);
	      cmbProductKind.addItem(product[0]);
	      cmbProductKind.addItem(product[1]);
          cmbProductKind.addItem(product[2]);
          typePanel.add(cmbProductKind);
	  }
	  else if(type.equals(SEARCH_BY_DATE)){
		   JLabel lblDate = new  JLabel("Enter Date: yyyymmdd");
		   JLabel lblDateFrom = new  JLabel("Input Starting Date");
		   JLabel lblDateTo = new  JLabel("Input End Date");
		   txtDateFrom = new JTextField(8);
		   txtDateTo = new JTextField(8);

		   GridBagLayout gridbag = new GridBagLayout();
		   typePanel.setLayout(gridbag);
		   GridBagConstraints gbc = new GridBagConstraints();
		   typePanel.add(lblDate);
		   typePanel.add(lblDateFrom);
		   typePanel.add(lblDateTo);
		   typePanel.add(txtDateFrom);
		   typePanel.add(txtDateTo);

		   gbc.insets.top = 5;
		   gbc.insets.bottom = 5;
		   gbc.insets.left = 1;
		   gbc.insets.right = 8;

		   gbc.anchor = GridBagConstraints.WEST;
		   gbc.gridx = 0;
		   gbc.gridy = 0;
		   gridbag.setConstraints(lblDate, gbc);
		   gbc.gridx = 0;
		   gbc.gridy = 1;
           gridbag.setConstraints(lblDateFrom, gbc);
           gbc.gridx = 1;
		   gbc.gridy = 1;
           gridbag.setConstraints(txtDateFrom, gbc);

           gbc.gridx = 0;
		   gbc.gridy = 2;
		   gridbag.setConstraints(lblDateTo, gbc);
		   gbc.gridx = 1;
		   gbc.gridy = 2;
           gridbag.setConstraints(txtDateTo, gbc);
	  }
	   return typePanel;
 }
}
