
import java.util.ArrayList;
import java.util.Iterator;

// Chess board for Game of Go
class Composite extends ChessComponent{
	  private int[] position = null;
      private ArrayList<ChessComponent> arrGoStone = null;
	  private ChessComponent currentPiece = null;

	  public Composite(){
		  arrGoStone = new ArrayList<ChessComponent>();
	  }

	 public void attach(ChessComponent  piece){
	      if(piece != null)
	 		    arrGoStone.add(piece);
	 }
	 public void detach(ChessComponent  piece){
	 	  if(piece != null)
	 		    arrGoStone.remove(piece);
    }
    public void removeAllElements(){
		   arrGoStone.clear();
    }
	 public Iterator<ChessComponent >  elements(){
	 	    return arrGoStone.iterator();
	 }
	 public ChessComponent getElement(int k){
		    return arrGoStone.get(k);
	 }
     public void setPosition(int x, int y){ }
	 public int[ ] getPosition(){
	 	  return  position;
	 }
	 public String showInfo(){
	 	  return "This is composite.";
	 }
	 public int getSize(){
	 	    return arrGoStone.size();
      }
      public int getColor(){
	  	   return 0;
	 }
}

