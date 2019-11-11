import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.util.Iterator;

// Chess board for Wu Zi Qi
class Board extends JPanel implements MouseListener{
	  final static int BLACK = 1, WHITE = -1, R=13;
      private String blackPlayer = null, whitePlayer = null;
      private Composite arrPieces = new Composite();
      private GChessPiece graphicPiece = null;
      private ChessComponent conceptPiece = null;
	  int[][] whitePieces = new int[15][15];
	  int[][] blackPieces = new int[15][15];
	  boolean isGameOver = false;
	  public static int LENGTH = 15;
	  int inset=10, leftEdge, rightEdge, top, bottom;
	  int width, height, unit;
	  int x = -1, y = -1, chessColor = BLACK;
	  int m=0, n=0;
	  int count =0;

	  public Board(){
		      setSize(420,420);
			  width = getWidth()-  2*inset;
			  height = getHeight()- 2*inset;
			  unit = width/14;
			  top = inset;
			  bottom = height+inset;
			  leftEdge = inset;
			  rightEdge =  width+inset;
		      setBackground(Color.orange);
		      addMouseListener(this);
	  }
      // Paint the Wuzi Qi board
      public void paint(Graphics g){
		      drawBoard(g);
		      drawPlayers();
      }
	  public void mousePressed(MouseEvent e){
			  if(e.getModifiers()==InputEvent.BUTTON1_MASK){
				  if( (isGameOver == false) && (blackPlayer != null) && (whitePlayer != null) ) {
				       x = (int)e.getX();
				       y = (int)e.getY();
				       addPieceToBoard(x, y);
			      }
			 }
	  }
	  private void addPieceToBoard(int x, int y){
	      convertToGrid(x, y);
		  if ( x>= leftEdge-5 && x<= rightEdge+5 && y>=top-5 && y<=bottom +5)  {
				if(chessColor == BLACK) {
					 conceptPiece = new BlackPiece();
					 blackPieces[m][n]=1;
					 graphicPiece  = new GChessPiece(Color.black);
				}
				else if(chessColor == WHITE){
					 conceptPiece = new WhitePiece();
					 whitePieces[m][n]=1;
					 graphicPiece  = new GChessPiece(Color.white);
				}
				this.add(graphicPiece);
				graphicPiece.setBounds(m*unit+inset-R, n*unit+inset-R, 2*R, 2*R);
			    conceptPiece.setPosition(x, y);
			    arrPieces.attach(conceptPiece);   /// save to array
			    evaluateGame();
			    chessColor = chessColor*(-1);
		   }
	  }
	  private void convertToGrid(int x, int y){
	 		   for(int i=0; i< 15; i++){
				   int k=(inset+i*unit)/unit;
				   if( (x >=k*unit -unit/2) && (x <k*unit+ unit/2 ) )
				        m=k;
			   }
			    for(int j=0; j< 15; j++){
			   		int p =(inset+j*unit)/unit;
			   	    if( (y >=p*unit -unit/2) && (y <p*unit+ unit/2 ) )
			   			n=p;
			   }
	  }
	  private void evaluateGame(){
			  GameOperations g = new GameOperations(this);
			  if(chessColor == WHITE){
				     g.checkMatixLines(whitePieces);
				     g.checkLeftSlantDiagonal(whitePieces);
				     g.checkRightSlantDiagonal(whitePieces);
				     if(isGameOver == true)
					        anounceWinner();
			 }
			 if(chessColor == BLACK){
				     g.checkMatixLines(blackPieces);
				     g.checkLeftSlantDiagonal(blackPieces);
				     g.checkRightSlantDiagonal(blackPieces);
				     if(isGameOver == true)
					        anounceWinner();
			 }
      }
	     // This replay method will recover the whole game step by step
	     // One call of this method will do only one step
	  public void replay(){
		   if(count ==0)
		         this.removeAll();
		   if (count >=0 && count < arrPieces.getSize()){
               GChessPiece gBlackPiece = new GChessPiece(Color.black);
               GChessPiece gWhitePiece = new GChessPiece(Color.white);

		       ChessComponent element = arrPieces.getElement(count);
               int[] coordinates = element.getPosition();
               int c = element.getColor();
               int x=coordinates[0];
			   int y=coordinates[1];
			    convertToGrid(x, y);
				if(c == BLACK ){
					  this.add(gBlackPiece);
					  gBlackPiece.setBounds(m*unit+inset-R, n*unit+inset-R, 2*R, 2*R);
				}
				else if(c == WHITE ){
					  this.add(gWhitePiece);
					   gWhitePiece.setBounds(m*unit+inset-R, n*unit+inset-R, 2*R, 2*R);
				}
				count++;
		  }
		  drawPlayers();
	  }
	  private void drawBoard(Graphics g){
			  for(int m=leftEdge; m<=rightEdge; m=m+unit)   // draw ||||
					g.drawLine(m, top, m, bottom-10);
			  for(int n=top; n<=bottom; n=n+unit)  //draw -----
					g.drawLine(leftEdge, n, rightEdge-10, n);
      }
      public void setPlayers(String blackPlayer, String whitePlayer){
			   this.blackPlayer = blackPlayer;
			   this.whitePlayer = whitePlayer;
			   drawPlayers();
	  }
	  private void drawPlayers() {
		       Graphics2D  g2  =  (Graphics2D)getGraphics();
		       g2.drawString("Black Player: "+blackPlayer, 55, bottom+20);
		       g2.drawString("White Player: "+whitePlayer, 250, bottom+20);
	  }
	  private void anounceWinner() {
               Graphics2D  g2  =  (Graphics2D)getGraphics();
               if(chessColor == BLACK)
		             g2.drawString("Black player won the game: ",  55, bottom+30);
		       else if(chessColor == WHITE)
		             g2.drawString("White player won the game: ", 250 , bottom+30);
	  }
	  public void resetGame(){
		       isGameOver = false;
		       whitePieces = new int[15][15];
	           blackPieces = new int[15][15];
	           arrPieces.removeAllElements();
	           count=0;
	  }
	  public void setGameOver(boolean b){
		       isGameOver = b;
	  }
	  public void mouseReleased(MouseEvent e){}
	  public void mouseEntered(MouseEvent e){}
	  public void mouseExited(MouseEvent e){}
	  public void mouseClicked(MouseEvent e){ }
}