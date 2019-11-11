
import java.awt.*;

// White Stone of Game of Go
// Used to encapsulate the data needed for a
// white chess piece: position and color

class WhitePiece extends ChessComponent {
	 int[] position = new int[2];
	 private static final int WHITE = -1;

	 WhitePiece() {
		   position = new int[2];
	 }
	 public int[ ] getPosition(){
	       return  position;
	 }
	 public void setPosition(int x, int y){
	 	   position[0] = x;
	 	   position[1] = y;
	 }
	 public String showInfo(){
	 	   return "This is white piece.";
	 }
	 public int getColor(){
	 	   return WHITE;
	 }
}
