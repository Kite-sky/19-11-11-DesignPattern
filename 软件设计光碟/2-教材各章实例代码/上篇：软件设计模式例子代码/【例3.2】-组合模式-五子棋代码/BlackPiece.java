
import java.awt.*;

// Black Piece for Game of Go
// Used to encapsulate the data needed for a
// black chess piece: position and color

class BlackPiece extends ChessComponent  {
	 int[] position = null;
	 private static final int BLACK = 1;

	 BlackPiece() {
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
		    return "This is black piece.";
	 }
	 public int getColor(){
		   return BLACK;
	 }
}

