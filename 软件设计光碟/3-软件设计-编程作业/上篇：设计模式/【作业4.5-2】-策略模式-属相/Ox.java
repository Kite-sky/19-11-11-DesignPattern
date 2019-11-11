//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Ox implements ChineseZodiac {

   public String say(){
      String description =
        "You have a zodiac OX. \n"+
        "People born in the year of the ox are steady, plain and quiet. They arrange things systematically"+
        "and they are patient and tireless. They are usually ready to take other's advice and act with justice."+
        "But it is not easy to change their minds because they are stubborn and sometimes prejudice. "+
		"Some Ox people can be leaders. Most of them are conservative, methodical, and good with their hands."+
		"However, sometimes they can be demanding and will not be in good relationship with the people around"+
		"them. Ox people tend to defense for what they believe in. Oxen are strong, dutiful and reliable. "+

        "Personality: \n"+
        "Patient, logical, methodical, hardworking, dependable, conventional, and calm. "+
        "Shortcomings include: stubborn, biased or demanding, and "+
        "appear cold and careless."+

		"Compatibility for Relationship\n"+
		"Most Compatible With: Rat, Rooster, Snake."+
		"Most Incompatible With: Dog, Dragon, Horse, Sheep"+

		"Suitable occupations: \n"+
		"Painter, Mechanic, Architect, Farmer, Army officer, Banker, Real estate agent, " +
		"Archeologist, Manager, Engineer. \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/ox.jpg");
            return angryFace;
   }
}