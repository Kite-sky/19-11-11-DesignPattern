import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.sun.java.swing.plaf.windows.*;
import java.util.Observable;
import java.util.Observer;

public class PlainGUI extends Observable{
   private JFrame frame= new JFrame("PlainGUI - Observable");
   private JComboBox stateCmBox;
   private Vector observersList;
   private String grassState;
   public static final String SUBMIT = "Submit";
   public static final String EXIT = "Exit";

   public PlainGUI() throws Exception{
      observersList = new Vector();

      JLabel lblState = new JLabel("Select Grass State:");
      stateCmBox = new JComboBox();
      stateCmBox.addItem("Green");
      stateCmBox.addItem("Yellow");

      JButton btnOK = new JButton(SUBMIT);
      btnOK.addActionListener(new ButtonHandler());

      JPanel btnPanel = new JPanel();
      GridBagLayout gridbag = new GridBagLayout();
      btnPanel.setLayout(gridbag);
      GridBagConstraints gbc = new GridBagConstraints();

      btnPanel.add(lblState);
      btnPanel.add(stateCmBox);
      btnPanel.add(btnOK);

      gbc.gridx = 0;
      gbc.gridy = 0;
      gridbag.setConstraints(lblState, gbc);
      gbc.gridx = 1;
      gbc.gridy = 0;
      gridbag.setConstraints(stateCmBox, gbc);
      gbc.insets.top = 50;
      gbc.gridx = 1;
      gbc.gridy = 4;
      gridbag.setConstraints(btnOK, gbc);

      Container contentPane = frame.getContentPane();

      contentPane.add(btnPanel, BorderLayout.CENTER);
      try {
         UIManager.setLookAndFeel(new WindowsLookAndFeel());
         SwingUtilities.updateComponentTreeUI(frame);
      }
      catch (Exception ex) {
         System.out.println(ex);
      }

      frame.setSize(250, 180);
      frame.setVisible(true);
   }

   public void setGrassState(String st){
      grassState = st;
   }

   class ButtonHandler implements ActionListener{
      public void actionPerformed(ActionEvent e){
         if (e.getActionCommand().equals(SUBMIT)){
            String state = (String)stateCmBox.getSelectedItem();
        setGrassState(state);
        setChanged();
        notifyObservers(grassState);
      }
    }
  }
}// end of class

