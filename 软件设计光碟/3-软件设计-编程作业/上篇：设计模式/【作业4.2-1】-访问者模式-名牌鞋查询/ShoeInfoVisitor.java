



import java.util.Vector;

public class ShoeInfoVisitor extends Visitor{

   private String[] s = new String[9];

   public String describeShoes() {
	   String infoStr ="\n";
	   for(int n=0; n< 9; n++){
	      if(s[n] != null){
	         infoStr = infoStr + s[n]+"\n";
		  }
	   }
	   return infoStr;
    }

	public void visitAdidas(Adidas e){
	   // write code here. 给s[0]赋值
	}
	public void visitSalomon(Salomon e){
        // write code here。给s[1]赋值
	}
	public void visitPonyMexico(PonyMexico e){
        // write code here
    }
	public void visitNorthFace (NorthFace e){
        // write code here
	}
	public void visitNike(Nike e){
        // write code here
    }
	public void visitMephisto(Mephisto e){
        // write code here
	}
	public void visitGlobeBlitz (GlobeBlitz e){
        // write code here
    }
	public void visitGlobeAppleyard(GlobeAppleyard e){
        // write code here
	}
    public void visitDCShoesRover(DCShoesRover e){
        // write code here。给s[8]赋值
	}
}

