import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ClientUI extends JFrame {
  private JPanel btnPanel;
  private JPanel panel;

  public static final String WINDOWOPEN = "Open Window";
  public static final String WINDOWCLOSE = "Close Window";
  public static final String FANON = "FanOn";
  public static final String FANOFF = "FanOff";
  public static final String EXIT = "Exit";

  public ClientUI() {
        super("Command Pattern- Air Conditioning ");
        setUpChoicePanel();
        setUpScrollPanes();
   }
  private void setUpChoicePanel() {
	    //Create button objects
	    FanOnBtn btnFanOn = new FanOnBtn(FANON);
	    FanOffBtn btnFanOff = new FanOffBtn(FANOFF);
	    WindowOpenBtn btnWindowOpen = new WindowOpenBtn(WINDOWOPEN);
		WindowCloseBtn btnWindowClose = new WindowCloseBtn(WINDOWCLOSE);

		ExitButton btnExit = new ExitButton(EXIT);
		btnFanOn.setMnemonic(KeyEvent.VK_D);
		btnFanOff.setMnemonic(KeyEvent.VK_D);
		btnWindowOpen.setMnemonic(KeyEvent.VK_D);
		btnWindowClose.setMnemonic(KeyEvent.VK_D);
		btnExit.setMnemonic(KeyEvent.VK_X);

        panel = new JPanel();
	    ListenerInvoker bh = new ListenerInvoker(panel );
	    btnFanOn.addActionListener(bh);
	    btnFanOff.addActionListener(bh);
	    btnWindowOpen.addActionListener(bh);
	    btnWindowClose.addActionListener(bh);
	    btnExit.addActionListener(bh);

	    btnPanel = new JPanel();
	    btnPanel.setLayout(new FlowLayout());
	    btnPanel.add(btnFanOn);
		btnPanel.add(btnFanOff);
		btnPanel.add(btnWindowOpen);
		btnPanel.add(btnWindowClose);
        btnPanel.add(btnExit);
   }
   private void setUpScrollPanes() {
  	    JScrollPane showInfoPane = new JScrollPane( panel);
  	    JSplitPane bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
  	    bigSplitPane.setDividerLocation(420);

        getContentPane().add(bigSplitPane);
  	    setSize(new Dimension(500, 500));
        setVisible(true);
   }
   public static void main(String args[]) {
      try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      } catch (Exception evt) {}

      ClientUI frame = new ClientUI();
      frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { System.exit(0);   }} );
      frame.setSize(500, 500);
      frame.setVisible(true);
   }
}

