import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import com.sun.java.swing.plaf.windows.*;

public class PlainGUI extends JFrame implements Observable{
   private JComboBox stateCmBox;
   private Vector observersList;
   private String grassState;
   public static final String SUBMIT = "Submit";
   public static final String EXIT = "Exit";

   public PlainGUI() throws Exception {
      super("PlainGUI - Observable");
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

      Container contentPane = getContentPane();
      contentPane.add(btnPanel, BorderLayout.CENTER);
      try {
         UIManager.setLookAndFeel(new WindowsLookAndFeel());
         SwingUtilities.updateComponentTreeUI(
         PlainGUI.this);
      }
      catch (Exception ex) {
         System.out.println(ex);
      }

      setSize(250, 180);
      setVisible(true);
   }
   public String getGrassState(){
      return grassState;
   }
   public void setGrassState(String st){
      grassState = st;
   }

   //==========================================
   //Methods for implementing Observable
   public void register(Observer obs) {
      observersList.addElement(obs);
   }
   public void unRegister(Observer obs){
      observersList.removeElement(obs);
   }
   public void notifyObservers() {
      for (int i = 0; i < observersList.size(); i++) {
         Observer observer = (Observer) observersList.elementAt(i);
         observer.takeAction(this);
      }
   }
   //==========================================

   class ButtonHandler implements ActionListener
   {
      public void actionPerformed(ActionEvent e){
         if (e.getActionCommand().equals(SUBMIT)){
            String state = (String)stateCmBox.getSelectedItem();

        setGrassState(state);
        notifyObservers();
      }
    }
  }
}// end of class

