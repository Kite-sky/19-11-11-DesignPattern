//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Dragon implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac Dragon. \n A dragon is"+
      "full of energy, vitality and enthusiasm. Generally speaking, dragons are popular individuals, despite being "+
      "seen as foolhardy or big-mouthed at times. They are intelligent perfectionists that are demanding of others. "+
      "Even though their intolerance usually causes them some trouble, but Dragons enjoy attracting attention, "+
      "and prefer demanding situations to everyday routines. To Dragons, rules and regulations are made only for "+
      "others. They live, act, and think big, but their pride may prevent them from accepting help when they"+
      "need it the most. Self-reliant and sufficient, they can survive without close relationships, but are energized"+
      "with companions that share their wavelength."+

		"Personality:\n"+
		"Talented, ambitious, vigorous, vital, proud, dignified, sincere, sensitive, direct, brave, loyal, "+
		"and not easily deceived. Can be intimidating, over-bearing, demanding, arrogant, "+
		"eccentric, impetuous, and overly anxious. "+

		"Most Compatible With: Rat, Monkey, Rooster"+
		"Most Incompatible With: Dog, Dragon, Ox, Rabbit"+

     "Suitable Occupations: \n"+
     "Computer analyst, Engineer, Inventor, Psychoanalist, Sales Person"+
     " Advertsing Agent, Politition Manager, Philosopher Lawyer. \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/dragon.jpg");
            return angryFace;
   }
}