import java.awt.*;
import javax.swing.*;

public class StateAnimatGUI extends JFrame{
   private JPanel panel;
   private JLabel imgLabel,voiceLabel, stateLabel;
   private Context cxt;
   private String state, saying;
   private Color bkColor;
   private ImageIcon faceIcon;

   public static void main(String[] args){
	  JFrame.setDefaultLookAndFeelDecorated(true);
      new StateAnimatGUI();
   }

   public StateAnimatGUI(){
	  super ("State Pattern - Weather State");
      setUpGui();
	  setUpStateContext();
      startAnimation();
   }
   // No conditional statements here. Better for extention
   // Add a new state will not need to change any code here
   public void startAnimation(){
      while (true){
	     try{
			saying = cxt.doAction();
		    state = cxt.getWeatherState();
		    bkColor = cxt.getColor();
		    faceIcon = cxt.getImgIcon();

            panel.setBackground(bkColor);
            imgLabel.setIcon(faceIcon);
	        stateLabel.setText("  " + state + " State");
	        voiceLabel.setText(saying);
	        Thread.sleep(1500);
		 }
		 catch(InterruptedException e){}
	   }
	}
	private void setUpStateContext(){
       cxt = new Context();
	}
	private void setUpGui(){
	   imgLabel = new JLabel();
	   voiceLabel = new JLabel();
	   stateLabel = new JLabel();
	   stateLabel.setBackground(Color.cyan);
	   panel = new JPanel();
	   panel.setLayout(new GridLayout(3,1));
	   panel.add(stateLabel);
	   panel.add(imgLabel);
	   panel.add(voiceLabel);

	   add(panel, BorderLayout.CENTER);
	   setSize(300, 350);
	   setVisible(true);
	   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}