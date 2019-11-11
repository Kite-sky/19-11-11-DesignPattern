//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Dog implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac Dog. \n Dogs are born honest and faithful to the people they love. "+
      "Dogs may find a hobby or interest that they enjoy and stick to it. However, "+
      "most Dog people are bothered by worry, a sharp tongue. They likely find fault in things."+
     " Dog people have a sense of justice, and are particularly good at finding logical solutions"+
      "to problems. As long as Dogs are concerned, it is the people that count. As trustworthy friends, "+
      "dogs have a tendency to hold grudges until appeased. Despite having"+
      "a temper at times, they need loving, stable relationships. Once they've found their mate, they"+
      "are faithful for life.\n"+

     "Personality: \n"+
	 "Loyal, honest, calm, friendly, intelligent, open-minded, straightforward, unpretentious, "+
	 "practical, and determined. A good leader. Feel strongly about justice and fairness for all."+
	 "Can be head-strong, snobbish, cold, prying, inquisitive, judgmental, or critical of others.\n"+

	 "Most Compatible With: Horse, Rabbit, Tiger \n"+
	 "Most Incompatible With: Dragon, Ox, Rooster, Sheep"+

     "Suitable occupations: "+
     "Lawyer, Activist, Teacher, Scientist, Secret Agent, Priest, Doctor, Politician\n";

      return description;
   }

   public ImageIcon setImgIcon(){
         ImageIcon angryFace = new ImageIcon("images/dog.jpg");
         return angryFace;
   }
}