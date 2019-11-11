//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Rabbit implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac Rabbit. \n "+

		"People born in the year of the rabbit are the luckiest among the twelve animals. "+
		"The rabbit is a symbol for mercy, elegance, amiability and worship of beauty. People born"+
		"in this year are kind, speak gently, peaceful, quiet and loving persons. They like to live "+
		"easy lives. They are reserved people, love arts and have a strong sense of justice. "+
		"Whatever they do, they will start well and end well. This feature can make them learned "+
		"scholars. They are also well adapted to work in government departments, and to be active"+
		"on the political stage."+

		"They keep out of disputes, even if they have to turn a blind eye. Rabbits are emotional and even selfish "+
		"when it comes to enjoying themselves, but they would never deliberately hurt anyone. "+
		"Even though they seem quiet (and even unattentive), their intuition and intelligence "+
		"gives them the diplomatic skills to distance themselves from bad situations. "+

		"Personality: "+
		"Calm, composed, reserved, cautious, elegant, artistic, talented, friendly,"+
		"popular, kind, and compassionate. Can be afraid of risks, conservative,"+
		"self-indulgent, wary, and superficial."+

		"Most Compatible With: Dog, Pig, Sheep"+
		"Most Incompatible With: Dragon, Horse, Rat, Rooster"+

		"Suitable occupations: \nActor,Herbalist, Judge, Diplomat,Therapist, Writer,  "+
		"Fashion designer, Teacher, Administrator. \n";
      return description;
   }

   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/rabbit.jpg");
            return angryFace;
   }
}