import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;
import javax.swing.JScrollPane;

/*====================================================*/
/* This is a GUI for testing the facade pattern.      */
/* This class interacts with class GeneralizedEllipse */
/* only.                                              */
/*====================================================*/
public class EllipseDrawerGUI extends JPanel{
   private JSplitPane bigSplitPane;
   private JSplitPane upSplitPane;
   private JScrollPane textPane;

   private JScrollPane btnPane;
   private JTextArea dataTextArea;
   private JPanel btnPanel;
   private EllipseGraph drawPanel;
   private JScrollPane drawPane;

   private JComboBox cmbDrawOption;
   private JTextField parameters;
   private JLabel lblOption;
   private JLabel lblInput;
   private String drawOption;
   private String inputData;
   private GeneralizedEllipse gEllipse;

   public static final String CORNER = "Ellipse by Corner";
   public static final String CENTER = "Ellipse by Center";
   public static final String RECTANGLE = "Ellipse by Rectangle";
   public static final String DRAW = "Draw";
   public static final String EXIT = "Exit";

   public EllipseDrawerGUI(){
	  super(new GridLayout(1,0));
      buildUpScrollGUI();
   }

   private void buildUpScrollGUI(){
	  setUpButtonPanel();

      dataTextArea = new JTextArea();

	  btnPane = new JScrollPane(btnPanel);
	  textPane = new JScrollPane(dataTextArea);

	  drawPane = new JScrollPane(drawPanel);

  	  upSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  upSplitPane.setLeftComponent(btnPane);
	  upSplitPane.setRightComponent(textPane );

	  Dimension minimumSize = new Dimension(130, 100);
	  drawPane.setMinimumSize(minimumSize);
	  btnPane.setMinimumSize(minimumSize);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  upSplitPane.setDividerLocation(230);
	  upSplitPane.setPreferredSize(new Dimension(500, 300));

	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, upSplitPane, drawPane);
	  bigSplitPane.setDividerLocation(160);

	  add(bigSplitPane);
	  setSize(new Dimension(500, 400));
   }
   private void setUpButtonPanel(){
      cmbDrawOption = new JComboBox();
      cmbDrawOption.addItem(CORNER);
      cmbDrawOption.addItem(CENTER);
      cmbDrawOption.addItem(RECTANGLE);

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
      btnPanel.add(cmbDrawOption);
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
      gridbag.setConstraints(cmbDrawOption, gbc);
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

   public String getSelectedDrawMethod(){
	  return (String) cmbDrawOption.getSelectedItem();
   }
   public double[] getInputData(){
      double[] intPar = new double[4];

	  String txtData= parameters.getText();
      String[] arrayData = txtData.trim().split("[\\s\"]+");

      for(int j=0;j<arrayData.length;j++){
	     intPar[j] = Double.parseDouble(arrayData[j]);
	  }
	  return intPar;
   }

   class ButtonListener implements ActionListener{
      EllipseDrawerGUI objCarGUI;
      private double xCorner, yCorner, xLen, yLen;
      private boolean isOvalOK=false;

      public void actionPerformed(ActionEvent e){
         String searchResult = null;
         upSplitPane.setDividerLocation(230);
		 upSplitPane.setPreferredSize(new Dimension(500, 300));

         if (e.getActionCommand().equals(EXIT)){
            System.exit(1);
         }
         if (e.getActionCommand().equals(DRAW)){
            String method = getSelectedDrawMethod();
            double[] data = getInputData();
            showOptionAndData(method, data);
            gEllipse = new GeneralizedEllipse();

            if(method.equals(CORNER)){
		       isOvalOK = gEllipse.initializeOvalByCorner(data[0],data[1], data[2],data[3]);
		    }
		    else if(method.equals(CENTER)){
		       isOvalOK = gEllipse.initializeOvalByCenter(data[0],data[1], data[2],data[3]);
		    }
            else if(method.equals(RECTANGLE)){
			   isOvalOK = gEllipse.initializeOvalByRectangle(data[0],data[1], data[2],data[3]);
		    }
		    checkErr(method, isOvalOK);
		    setUPData();
		    showEllipseData();
		    drawOvalGraph(gEllipse,data);
         }
      }

	  private void setUPData(){
	     xCorner = gEllipse.getCornerX();
	     yCorner = gEllipse.getCornerY();
	     xLen = gEllipse.getWidth();
	     yLen = gEllipse.getHeight();
	  }
	  private void drawOvalGraph(GeneralizedEllipse ge,double[] data){
	     drawPanel = ge.drawOval();
         drawPane = new JScrollPane(drawPanel);
	     bigSplitPane.setDividerLocation(160);
	     bigSplitPane.setRightComponent(drawPane);

         Rectangle rect = new Rectangle(0, 0, (int)(xLen+xCorner), (int)(yLen+yCorner));
         drawPanel.scrollRectToVisible(rect);
         Dimension area = new Dimension((int)(xLen+xCorner)+20, (int)(yLen+yCorner)+20);

		 //Update client's preferred size because the area taken
		 //up by the graphics has gotten larger or smaller.
		 drawPanel.setPreferredSize(area);

         //Tell the drawPane to update itself and its scrollbars.
	     drawPanel.revalidate();
	     drawPanel.repaint();
	  }
      private void showEllipseData(){
	     DecimalFormat df2  = new DecimalFormat("###.00");
	     double area = gEllipse.getOvalArea();
	   	 double perimeter = gEllipse.getOvalPerimeter();
	   	 double eccentricity = gEllipse.getEccentricity ();
	   	 Point2D[] focalPoints = gEllipse.getFocalPoints();

		 dataTextArea.append("\nArea = "+ df2.format(area));
		 dataTextArea.append("\nPerimeter = "+ df2.format(perimeter));
		 dataTextArea.append("\nEccentricity = "+df2.format(eccentricity));
         dataTextArea.append("\nFocal Points: ");
		 for(int i=0;i<2;i++){
		    double focalX = focalPoints[i].getX();
		    double focalY = focalPoints[i].getY();
            dataTextArea.append("\nF"+(i+1) +"( " + df2.format(focalX)+", "
                                + df2.format(focalY) +")" );
	     }
	  }
	  private void showOptionAndData(String method, double[] data){
	     dataTextArea.append(method +"\n");
	     dataTextArea.append("Input data\n ");
	     for(int i=0;i<4;i++)
            dataTextArea.append(data[i]+", ");
	  }
	  private void checkErr(String option, boolean g){
	     if(g==false){
	        if(option.compareTo(CORNER)==0){
		       dataTextArea.append("\nWrong initial data. Width and height must be positive");
			   return;
		    }
		    else if (option.compareTo(CENTER)==0){
			   dataTextArea.append("\nWrong initial data. all radius should be positive");
			  return;
		    }
		    else if(option.compareTo(RECTANGLE)==0){
		  	   dataTextArea.append("\nWrong initial data. Should be xLeft<xRight, yTop<yBottom.");
			   return;
			}
		 }
	  }
    } // End of class ButtonListener

    private static void createAndShowGUI(){
       JFrame.setDefaultLookAndFeelDecorated(true);
       JFrame frame = new JFrame("Facade pattern demo");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       EllipseDrawerGUI newContentPane = new EllipseDrawerGUI();
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

