//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Monkey implements ChineseZodiac {

   public String say(){
      String description ="You have a zodiac Monkey. \n"+
	"Monkey people are intelligent, witty and possess an general attractive personality. They are "+
	"talktive and very easy to communicate with. Monkeys are also fast learners. Some "+
	"people don't like  the Monkey personality, such as restless, sly, inquistive behaviour. "+
	"Sometimes a monkey don't know why some other people don't like them. With a wide range "+
	"of interests, monkeys can perform very well in many kinds of jobs, but are reluctant to work from 9 - 5. "+

	"Personality: \n"+
	"Eloquent, smart, quick-witted, sociable, agile mentally and physically, creative, innovative and "+
	"competitive. An inventor, motivator and problem solver. Can be snobbish, egotistical, overly "+
	"optimistic, impatient, reckless, inquisitive and vain."+

	"Most Compatible With: Dragon, Rat\n"+
	"Most Incompatible With: Snake, Pig, Tiger\n"+

	"The following occupations best suit the Monkey personality."+
	"Scientist, Journalist, Editor, Filem director, Jeweller, Actor, Writer, "+
	"Air traffic controller, Engineer, Market trader \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/monkey.jpg");
            return angryFace;
   }
}