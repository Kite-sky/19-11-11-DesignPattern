import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.awt.event.*;
import com.sun.java.swing.plaf.windows.*;

public class CarGUIView extends JFrame implements View{
   private JEditorPane editorPane;
   private JScrollPane imagePane;
   private JScrollPane textPane;
   private JSplitPane splitPane;
   private JLabel imgLabel;
   private CarModel model;

   public CarGUIView(CarModel cmodel){
      super("Car information- Observer 1");
	  model = cmodel;
      buildUpScrollGUI();
   }
   private void buildUpScrollGUI(){
      imgLabel = new JLabel();
      imgLabel.setBackground(Color.green);
	  imgLabel.setMinimumSize(new Dimension(250, 200));

      editorPane = new JEditorPane();
	  editorPane.setEditable(false);

      imagePane = new JScrollPane(imgLabel);
	  imagePane.getViewport().setBackground(Color.green);

	  textPane = new JScrollPane(editorPane);
	  textPane.setMinimumSize(new Dimension(250, 200));

	  splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
	  splitPane.setLeftComponent(imagePane);
	  splitPane.setRightComponent(textPane);

	  Dimension minimumSize = new Dimension(130, 100);
	  imagePane.setMinimumSize(minimumSize);
	  textPane.setMinimumSize(new Dimension(100, 100));
	  splitPane.setDividerLocation(160);
	  splitPane.setPreferredSize(new Dimension(500, 300));

	  Container contentPane = getContentPane();
	  contentPane.add(splitPane);
	  setSize(400, 150);
	  setVisible(true);
   }

    public void update(){
       try{
	      URL url = model.getCarFileURL();
          editorPane.setPage(url);
          System.out.println("We have been called.");
	   }
	   catch (IOException e){
	      e.printStackTrace();
       }
       ImageIcon imIcon = model.getImageIcon();
       imgLabel.setIcon(imIcon);
	   imgLabel.validate();
    }

}

