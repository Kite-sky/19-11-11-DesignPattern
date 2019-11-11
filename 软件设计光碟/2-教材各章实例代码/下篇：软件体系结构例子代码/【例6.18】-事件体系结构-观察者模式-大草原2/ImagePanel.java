import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel
{
     private String img;

     public ImagePanel(String image)
     {
          img = image;
          addAnImage();

     }

      public void addAnImage()
      {

          //JPanel imagePanel = new JPanel();
          this.setBackground(Color.CYAN);
          ImageIcon icon = new ImageIcon(img);
          JLabel label = new JLabel();
          label.setIcon(icon);
          this.add(label);
          //contentPane.add(imagePanel, BorderLayout.EAST);

          //setVisible(true);
       }
}