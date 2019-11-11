import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ClientUI extends JFrame {
  private JSplitPane  bigSplitPane;
  private JScrollPane showInfoPane;
  private JPanel btnPanel;
  private JLabel lblPlayers;
  private JTextField txtPlayerBlack, txtPlayerWhite;
  private Dimension minimumSize;
  private Board board;
  public static final String PLAY = "Start Game";
  public static final String EXIT = "Exit";
  public static final String REPLAY = "Replay";
  public static final String NEXTGAME = "Next Game";

  public ClientUI() {
      super("Composite Pattern- Wuzi Qi ");
      minimumSize = new Dimension(130, 100);
      board = new Board();
      setUpChoicePanel();
      setUpScrollPanes();
   }
  private void setUpChoicePanel() {
	  lblPlayers = new JLabel("Enter players before Playing");
	  txtPlayerBlack = new JTextField("player-black");
	  txtPlayerWhite = new JTextField("player-white");

	  ButtonListener btnListener = new ButtonListener();

	  //Create button objects
	  JButton playButton = new JButton(PLAY);
	  JButton nextButton = new JButton(NEXTGAME);
	  JButton exitButton = new JButton(EXIT);
	  JButton replayButton = new JButton(REPLAY);
	  playButton.setMnemonic(KeyEvent.VK_S);
	  nextButton.setMnemonic(KeyEvent.VK_S);
	  exitButton.setMnemonic(KeyEvent.VK_X);
      replayButton.setMnemonic(KeyEvent.VK_X);
	  playButton.addActionListener(btnListener);
	  exitButton.addActionListener(btnListener);
	  replayButton.addActionListener(btnListener);
      nextButton.addActionListener(btnListener);

	  btnPanel = new JPanel();
	  btnPanel.setBackground(Color.gray);

	  GridBagLayout gridbag = new GridBagLayout();
	  btnPanel.setLayout(gridbag);
	  GridBagConstraints gbc = new GridBagConstraints();
	  btnPanel.add(lblPlayers);
	  btnPanel.add(txtPlayerBlack);
	  btnPanel.add(txtPlayerWhite);
	  btnPanel.add(playButton);
	  btnPanel.add(nextButton);
	  btnPanel.add(exitButton);
	  btnPanel.add(replayButton);

      gbc.insets.top = 5;
      gbc.insets.bottom = 5;
      gbc.insets.left = 5;
      gbc.insets.right = 5;
      gbc.gridx = 0;
      gbc.gridy = 1;
      gridbag.setConstraints(lblPlayers, gbc);
      gbc.gridx = 1;
      gbc.gridy = 1;
      gridbag.setConstraints(txtPlayerBlack, gbc);
      gbc.gridx = 2;
	  gbc.gridy = 1;
      gridbag.setConstraints(txtPlayerWhite, gbc);

      gbc.insets.left = 2;
      gbc.insets.right = 2;
      gbc.insets.top = 15;
      gbc.gridx = 0;
      gbc.gridy = 5;
      gridbag.setConstraints(playButton, gbc);
      gbc.gridx = 1;
	  gbc.gridy = 5;
	  gridbag.setConstraints(nextButton, gbc);
      gbc.gridx = 2;
      gbc.gridy = 5;
      gridbag.setConstraints(exitButton, gbc);
      gbc.gridx = 3;
	  gbc.gridy = 5;
      gridbag.setConstraints(replayButton, gbc);
   }
   private void setUpScrollPanes() {
  	  showInfoPane = new JScrollPane( board);
  	  showInfoPane.setBackground(Color.orange);
  	  bigSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, showInfoPane, btnPanel);
  	  bigSplitPane.setDividerLocation(450);

      getContentPane().add(bigSplitPane);
  	  setSize(new Dimension(450, 600));
      setVisible(true);
   }
   class ButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals(EXIT)) { System.exit(1); }
			if (ae.getActionCommand().equals(PLAY)) {
				 String blackPlayer = txtPlayerBlack.getText();
				 String whitePlayer = txtPlayerWhite.getText();

				 if(blackPlayer.length() != 0 && whitePlayer.length() !=0){
				       board.setPlayers(blackPlayer, whitePlayer);
                       board.resetGame();
			     }
			}
			if (ae.getActionCommand().equals(NEXTGAME)) {
					   board.removeAll();
					   String blackPlayer = txtPlayerBlack.getText();
				       String whitePlayer = txtPlayerWhite.getText();
					   if(blackPlayer.length() != 0 && whitePlayer.length() !=0)
				             board.setPlayers(blackPlayer, whitePlayer);
				       board.resetGame();
			}
			if (ae.getActionCommand().equals(REPLAY)) {
					  board.replay();
			}
      }
   }
   public static void main(String args[]) {
      try { UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
      } catch (Exception evt) {}

      ClientUI frame = new ClientUI();
      frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) { System.exit(0);   }} );
      frame.setSize(450, 600);
      frame.setVisible(true);
   }
}

