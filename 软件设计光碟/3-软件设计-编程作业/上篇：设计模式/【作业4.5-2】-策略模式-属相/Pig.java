//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Pig implements ChineseZodiac {

   public String say(){
      String description =
       "You have a zodiac Pig. \n "+

		"The Pig is a fun and enlightening personality blessed with patience and understanding. "+
		"People born under the sign of the Pig enjoy life and all it has to offer, including family and friends. "+
		"They are honest and thoughtful and expect the same of other people. Pigs can be perceived as "+
		"oblivious or gullible because they do care about others so much that they will do just about "+
		"anything for a friend in need. "+

		"They are sincere, tolerant, and honest. By expecting the same from others, they are incredibly "+
		"naive and sometimes taken advantage of. However, they seldom hold a grudge, and will overlook"+
		"other people's faults for the sake of social harmony. They love their homes, but spend most of"+
		" their time and energy indulging themselves with the best of everything "+

		"Personality: "+
		"Smart, knowledgeable, sociable, understanding, trusting, loyal, sturdy, persistent, "+
		"hardworking, composed, striking and popular. Can be judgmental, self-indulgent, "+
		"gullible, impatient, or irritable. "+

		"Most Compatible With: Rabbit, Sheep\n"+
		"Most Incompatible With: Monkey, Pig, Snake\n"+

		"Suitable occupations: \n"+
		"Teacher, Designer, Artist, Actor, Entertainer, Dentist, Butcher, Farmer, Doctor\n";

      return description;
   }

   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/pig.jpg");
            return angryFace;
   }
}