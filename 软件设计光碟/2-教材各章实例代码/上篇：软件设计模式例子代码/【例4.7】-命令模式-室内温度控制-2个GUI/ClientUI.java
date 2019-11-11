import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ClientUI extends JFrame {
  private JPanel btnPanel;
  private JPanel panel;
  public static final String WINDOWOPEN = "Open Window";
  public static final String WINDOWCLOSE = "Close Window";
  public static final String FANROTATE = "Start Fan";
  public static final String FANSTOP = "Stop Fan";
  public static final String EXIT = "Exit";

  public ClientUI() {
        super("Command Pattern- Air Conditioning ");
        setUpChoicePanel();
        setUpScrollPanes();
   }
  private void setUpChoicePanel() {
	    //Create button objects
	    JButton windowOpenBtn = new JButton(WINDOWOPEN);
	    JButton windowCloseBtn = new JButton(WINDOWCLOSE);
	    JButton fanRotateBtn = new JButton(FANROTATE);
	    JButton fanStopBtn = new JButton(FANSTOP);
	    JButton exitButton = new JButton(EXIT);

	    windowOpenBtn.setMnemonic(KeyEvent.VK_S);
	    windowCloseBtn.setMnemonic(KeyEvent.VK_S);
	    fanRotateBtn.setMnemonic(KeyEvent.VK_S);
	    fanStopBtn.setMnemonic(KeyEvent.VK_S);
	    exitButton.setMnemonic(KeyEvent.VK_S);

	    ButtonListener btnListener = new ButtonListener();
	    windowOpenBtn.addActionListener(btnListener);
	    windowCloseBtn.addActionListener(btnListener);
	    fanRotateBtn.addActionListener(btnListener);
	    fanStopBtn.addActionListener(btnListener);
	    exitButton.addActionListener(btnListener);

	    btnPanel = new JPanel();
	    btnPanel.setBackground(Color.gray);
	    btnPanel.setLayout(new FlowLayout());
	    btnPanel.add(windowOpenBtn);
	    btnPanel.add(windowCloseBtn);
	    btnPanel.add(fanRotateBtn);
	    btnPanel.add(fanStopBtn);
	    btnPanel.add(exitButton);
   }
   private void setUpScrollPanes() {
	    panel = new JPanel();
  	    JScrollPane showInfoPane = new JScrollPane( panel);
  	    JSplitPane bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
  	    bigSplitPane.setDividerLocation(420);

        getContentPane().add(bigSplitPane);
  	    setSize(new Dimension(500, 520));
        setVisible(true);
   }
   class ButtonListener implements ActionListener {
	     private Invoker invoker;
	     private Command command;
	     private GFan fan;
         private GWindow window;

         public void actionPerformed(ActionEvent ae) {
				panel.removeAll();
				window = new GWindow (panel);
				fan = new GFan (panel);
				if (ae.getActionCommand().equals(EXIT)) {
					   System.exit(1);
				}
				if (ae.getActionCommand().equals(WINDOWOPEN))
						command = new WindowOpenCmd ( window);
				if (ae.getActionCommand().equals(WINDOWCLOSE))
						command = new WindowCloseCmd ( window);
				if (ae.getActionCommand().equals(FANROTATE))
					   command = new FanOnCmd (fan);
				if (ae.getActionCommand().equals(FANSTOP))
					   command = new FanOffCmd (fan);

				invoker = new Invoker(command);
			    invoker.callCommand( );
      }
   }
   public static void main(String args[]) {
      try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      } catch (Exception evt) {}

      ClientUI frame = new ClientUI();
      frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { System.exit(0);   }} );
      frame.setSize(500, 520);
      frame.setVisible(true);
   }
}

