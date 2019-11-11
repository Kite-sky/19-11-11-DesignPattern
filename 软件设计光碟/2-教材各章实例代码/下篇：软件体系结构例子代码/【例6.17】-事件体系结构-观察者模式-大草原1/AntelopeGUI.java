import java.awt.*;
import javax.swing.*;

public class AntelopeGUI extends JFrame implements Observer
{
    private JLabel stateLabel;
    private JTextArea actionText;
    private String grassState="";
    private PlainGUI plainGuiObj;

    public AntelopeGUI(PlainGUI objPlainGUI) throws Exception{
       super("Antelope GUI - Observer 1");
       plainGuiObj = objPlainGUI;

       JPanel buttonPanel = new JPanel();
       stateLabel = new JLabel("Grass state");
       actionText = new JTextArea(4, 20);
       buttonPanel.add(stateLabel);
       buttonPanel.add(actionText);

       Container contentPane = getContentPane();
       JPanel imgPanel=new ImagePanel("Antelope.jpg");
       contentPane.add(buttonPanel, BorderLayout.CENTER);
       contentPane.add(imgPanel, BorderLayout.EAST);

       setSize(400, 150);
       setVisible(true);

       plainGuiObj.register(this);
     }

     public void takeAction(Observable subject){
       if (subject == plainGuiObj){
           grassState = plainGuiObj.getGrassState().trim();
           stateLabel.setText("Grass state - " + grassState);

           if (grassState.compareTo("Green")== 0 ){
	           actionText.setBackground(Color.green);
	           actionText.setText("Antelopes are entering the plain.");
	       }
	       else if (grassState.compareTo("Yellow")== 0 ){
               actionText.setBackground(Color.yellow);
               actionText.setText("Antelopes are leaving the plain.");
           }
        }
     }
}

