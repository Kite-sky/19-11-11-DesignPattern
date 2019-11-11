//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Snake implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac Snake. \n "+

		"Snakes tend to spend a lot of time thinking deeply, but they are not a worrier. Rather, "+
		"they pass their quiet time in reflection and contemplation. Of all the signs of the Chinese "+
		"zodiac, yours is most closely associated with wisdom. You probably have many interests "+
		"and an insatiable thirst for knowledge, which result in an increasingly complex person. "+

		"Rich in wisdom and charm, Snakes are romantic and deep thinkers. They use their intuition "+
		"to guide them strongly. Snakes like to do things at their own schedule, and when the moment "+
		"is right, surprize everyone by turning up something completely new. Although "+
		"sociable at times, they have a strong desire to be left alone. Attracted to elegant and refined "+
		"partners, they are deeply jealous and possessive when involved in relationships. \n"+

		"Personality: \n"+
		"Smart, creative, mystic, sympathetic, graceful, patient, calm, cautious, and low-key. "+
		"Respect and take pride in your work. A deep thinker and do not like to communicate "+
		"with others. Can be shy and reserved. Afraid to fail or to be rejected. Like to hide your"+
		"feelings. Can be possessive, jealous or mendacious at times."+

		"Most Compatible With: Ox, Rooster"+
		"Most Incompatible With: Pig, Monkey, Tiger"+

		"Suitable occupations: \n"+
		"Technologist, Painter, Philosopher, Spirital leader, "+
		"Magician, Psychologist, Jereler, Investigator\n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/snake.jpg");
            return angryFace;
   }
}