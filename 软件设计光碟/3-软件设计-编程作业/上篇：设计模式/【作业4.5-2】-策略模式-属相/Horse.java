//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Horse implements ChineseZodiac {

   public String say(){
      String description =
      "You have a zodiac horse. \n"+
		"A horse is a hard worker. Horse people are very independent, intelligent and friendly. "+
		"They tend to be very  selfish and cunning and they actually don't admit this point. "+
		"Usually lively and popular, they are mentally alert and good with words. "+
		"Although they are prepared to devote themselves to success, they sometimes runs in the opposite"+
		"direction. Horses rarely worry about whether they will be failed in their business or not. Good companions"+
		"and leaders, they can have fits of stubborness or explosive temper tantrums. They fall in love carelessly"+
		"and are possible to make mistakes before finding the right partner.\n"+

		"Personality: \n"+
		"Easy-going, open-minded, affectionate, popular, smart, cheerful, confident and independent. "+
		"Talented in many areas, and good at managing wealth. Can be too relaxing or be persuaded "+
		"easily. Need to be led with force, and can be difficult to tame. Also can be talkative, arrogant, "+
		"stuck-up, stubborn or rude.\n"+

		"Most Compatible With: Dog, Sheep, Tiger"+
		"Most Incompatible With: Horse, Ox, Rabbit, Rat"+

		"Suitable occupations: \n"+
		"Translator, Athlete, Pilot, Tour Oerator, Bartender, Journalist, Librarian, Actor. \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/horse.jpg");
            return angryFace;
   }
}