//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Sheep implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac Sheep. \n "+

		"Those born in the Year of the Sheep are often artistic, sensitive, sweet and charming. "+
		"Shy by nature, Sheeps are not the most practical of people and, although well-mannered, "+
		"they occasionally may suffer from saying the wrong thing at the wrong time. Still, with "+
		"their considerable charm and innocence Sheep never lack for protective friends and admirers."+

		"Sheep sometimes hide their emotions. They are first to complain about discomfort. "+
		"Lovers of art and nature, sheep people tend to spoil themselves. Still, they are creative,"+
		"cultured and well-mannered, which can affect others. Some Sheep people may appear "+
		"timid and easily upset, but others can be well adaptable to surrounding situations. "+
		"Either way, Sheep prefer to live and work with other people. "+

		"Personality: "+
		"Gentle, elegant, smart, assertive, artistic, creative, curious, shy, determined, "+
		"and compassionate. Can be indecisive, pessimistic or moody. Tend to run "+
		"away from problem instead of facing and fixing it. "+

		"Most Compatible With: Horse, Pig, Rabbit\n"+
		"Most Incompatible With: Dog, Ox, Rat\n"+

		"Suitable occupations: \n"+
		"Architect,  Town Planer, Art Historian, Illustrator, Actor, Musician, Floist, Doctor \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/sheep.jpg");
            return angryFace;
   }
}