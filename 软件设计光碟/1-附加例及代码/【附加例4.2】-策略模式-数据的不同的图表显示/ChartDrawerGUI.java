import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JScrollPane;

/*=================================================*/
/* This is a GUI for testing the strategy pattern. */
/* This class interacts with class BarChartGraph   */
/* and PieChartGraph                               */
/*=================================================*/
public class ChartDrawerGUI extends JPanel{
   private JSplitPane bigSplitPane;
   private JSplitPane upSplitPane;
   private JScrollPane textPane;
   private JScrollPane btnPane;
   private JTextArea dataTextArea;
   private JPanel btnPanel;
   private JPanel graphPanel;
   private ChartGraph chartPanel;
   private JScrollPane graphPane;

   private JComboBox cmbChartOption;
   private JTextField parameters;
   private JLabel lblOption;
   private JLabel lblInput;
   private int inputLen;

   public static final String BARCHART = "Bar Chart";
   public static final String PIECHART = "Pie Chart";
   public static final String DRAW = "Draw";
   public static final String EXIT = "Exit";

   public ChartDrawerGUI(){
	  super(new GridLayout(1,0));
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
	  setUpButtonPanel();

      dataTextArea = new JTextArea();

	  btnPane = new JScrollPane(btnPanel);
	  textPane = new JScrollPane(dataTextArea);
	  graphPane = new JScrollPane(graphPanel);

  	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(textPane );

	  Dimension minimumSize = new Dimension(130, 200);
	  graphPane.setMinimumSize(minimumSize);
	  btnPane.setMinimumSize(minimumSize);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  upSplitPane.setDividerLocation(230);
	  upSplitPane.setPreferredSize(new Dimension(400, 300));

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, graphPane);
	  bigSplitPane.setDividerLocation(160);

	  add(bigSplitPane);
	  setSize(new Dimension(400, 500));
   }
   private void setUpButtonPanel(){
      cmbChartOption = new JComboBox();
      cmbChartOption.addItem(BARCHART);
      cmbChartOption.addItem(PIECHART);

      parameters = new JTextField(13);

      lblOption = new JLabel("Option:");
      lblInput = new JLabel("Parameters");

      JButton srchButton = new JButton(DRAW);
      srchButton.setMnemonic(KeyEvent.VK_S);
      JButton exitButton = new JButton(EXIT);
      exitButton.setMnemonic(KeyEvent.VK_X);

      ButtonListener listener = new ButtonListener();
      srchButton.addActionListener(listener);
      exitButton.addActionListener(listener);

      btnPanel = new JPanel();
      GridBagLayout gridbag = new GridBagLayout();
      btnPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      btnPanel.add(lblOption);
      btnPanel.add(cmbChartOption);
      btnPanel.add(lblInput);
      btnPanel.add(parameters);
      btnPanel.add(srchButton);
      btnPanel.add(exitButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;

      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblOption, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(cmbChartOption, gbc);
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblInput, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(parameters, gbc);
      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 25;
      gbc.anchor = GridBagConstraints.EAST;
      gbc.gridx = 0;
      gbc.gridy = 3;
      gridbag.setConstraints(srchButton, gbc);
      gbc.anchor = GridBagConstraints.WEST;
      gbc.gridx = 1;
      gbc.gridy = 3;
      gridbag.setConstraints(exitButton, gbc);
   }

   public String getSelectedChart(){
	  return (String) cmbChartOption.getSelectedItem();
   }
   public double[] getInputData(){
	  String txtData= parameters.getText();
      String[] arrayData = txtData.trim().split("[\\s\"]+");
      inputLen = arrayData.length;
      double[] intPar = new double[inputLen];

      for(int j=0; j<inputLen; j++){
	     if(!arrayData[j].equals(""))
	        intPar[j] = Double.parseDouble(arrayData[j]);
	  }
	  return intPar;
   }

   class ButtonListener implements ActionListener{
      ChartDrawerGUI objCarGUI;
      private boolean isOvalOK=false;

      public void actionPerformed(ActionEvent e){
         String searchResult = null;
         upSplitPane.setDividerLocation(230);
		 upSplitPane.setPreferredSize(new Dimension(400, 300));

         if (e.getActionCommand().equals(EXIT)){
            System.exit(1);
         }
         if (e.getActionCommand().equals(DRAW)){
            String chart = getSelectedChart();

            double[] data = getInputData();
            boolean isValidData = checkErr(data);

            if(isValidData == true){
               if(chart.equals(BARCHART)){
			      chartPanel = new BarChartGraph(data);
			      graphPanel= (JPanel)chartPanel;
		       }
		       else if(chart.equals(PIECHART)){
			      chartPanel = new PieChartGraph(data);
			      graphPanel= (JPanel)chartPanel;
		       }
		       refreshPanel(data);
		       showOptionAndData(chart, data);
		    }
         }
      }

	  private void refreshPanel(double[] data){
         graphPane = new JScrollPane(graphPanel);
	     bigSplitPane.setDividerLocation(160);
	     bigSplitPane.setRightComponent(graphPane);

         Rectangle rect = new Rectangle(0, 0, 400, 300);
         //graphPanel.scrollRectToVisible(rect);
         Dimension area = new Dimension(400, 300);

		 //Update client's preferred size because the area taken
		 //up by the graphics has gotten larger or smaller.
		 graphPanel.setPreferredSize(area);
		 graphPanel.scrollRectToVisible(rect);

         //Tell the graphPane to update itself and its scrollbars.
	     graphPanel.revalidate();
	     graphPanel.repaint();
	  }

	  private void showOptionAndData(String chart, double[] data){
	     dataTextArea.append("\n" + chart +"\n");
	     dataTextArea.append("Input data\n ");
	     for(int i=0;i<data.length;i++)
            dataTextArea.append(data[i]+", ");
	  }

	  private boolean checkErr(double[] input){
		 boolean isValidData = true;
	     for(int j=0;j<input.length;j++){
		    if(input[j] <= 0){
			   dataTextArea.append("\n Wrong input. all input data should be positive");
			   isValidData =false;
			}
	     }
	     return isValidData;
	  }
    } // End ButtonListener

    private static void createAndShowGUI(){
       JFrame.setDefaultLookAndFeelDecorated(true);
       JFrame frame = new JFrame("Strategy Pattern- Chart Drawer");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       ChartDrawerGUI newContentPane = new ChartDrawerGUI();
       newContentPane.setOpaque(true);
       frame.setContentPane(newContentPane);
       frame.pack();
       frame.setVisible(true);
    }

    static public void main(String argv[]) {
	   javax.swing.SwingUtilities.invokeLater(new Runnable(){
          public void run(){
		     createAndShowGUI();
		  }
        });
    }
}

