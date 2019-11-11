//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Rooster implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac Rooster. \n "+
		 "People born in the year of the rooster usually are in good appearance. They always appear "+
		 "to be decent and smart in public, even the most timid one of them."+

		 "Roosters are hard workers; smart and determined in their decision making, "+
		 "often speaking out their minds. Therefore, Roosters seem to be exaggerated.  "+
		 "They love to attract attention and admiration, and are often offended when someone "+
		 "steals his/her ideas. Despite of being idealized, they are actually very practical, "+
		 "and logical. This leaves them with high standards of excellence which at times"+
		 "frustrates others. \n"+

		" Personality: \n"+
		 "Direct, acute, organized, meticulous, focused, self-assured, skillful, perfectionist, "+
		 "brave, responsible, hardworking, witty, curious, and thoughtful. Can be egotistical,"+
		 "opinionated, abrasive or critical. Or can be excessively proud of appearance or "+
		 "accomplishments.\n"+

		 "Most Compatible With: Dragon, Ox, Snake\n"+
		 "Most Incompatible With: Rabbit, Rat, Rooster, Dog\n"+

		 "Suitable occupations:\n"+
		 "Actor, Dentist, Dancer, Insurance agent, Singer, Army man, "+
		 "Financial advisor, Musician, Dancer \n";

      return description;
   }

   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/rooster.jpg");
            return angryFace;
   }
}