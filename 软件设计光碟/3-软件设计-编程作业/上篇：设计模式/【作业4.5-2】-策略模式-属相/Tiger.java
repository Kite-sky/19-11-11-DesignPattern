//============================== //
// A subclass of the strategy hierarchy
//==============================//

import java.awt.Color;
import javax.swing.ImageIcon;

public class Tiger implements ChineseZodiac {

   public String say(){
      String description =
        "You have a zodiac Tiger. \n "+

		"Born to lead, Tigers can be stubborn if they realize they are not in charge. They have a little bit"+
		"tendency to be selfish but overall, tigers are extremely generous. They are very intelligent "+
		"and always on alert. Tigers are very charming and are well-liked by others. They are not motivated "+
		"by money or power."+
		"Tigers are sensitive, emotional and capable of great love. They are extremely competitive, "+
		"especially when it boils down to honor or protecting the ones they love. They need "+
		"independence but love to dominate. This strong sense of dignity, coupled with their "+
		"eagerness to face challenges, make them natural (although difficult) leaders. Always "+
		"restless and alert, they aren't afraid to go for what they want. Tigers make honest, "+
		"generous friends and passionate lovers. In turn, they expect others to be honest with "+
		"them, but criticism or disapproval gets them depressed. Still, Tigers always bounce "+
		"back to face new challenges and take bigger chances."+

		"Personality: \n"+
		"Affectionate, vigorous, sympathetic, humanitarian, sensitive, cautious, brave, thoughtful "+
		"and optimistic. Will earn other’s respect as a leader. But can be short-tempered or easily flustered"+
		"over calculated, rebellious, selfish, reckless or too daring."+
		"Do not like to be supervised or be a subordinate.\n"+

		"Most Compatible With: Dog, Horse"+
		"Most Incompatible With: Monkey, Snake"+

		"Suitable occupations: \n"+
		"Lectuer, Pilot, Writer, Explorer, Race car driver, Politician, Actor, Musician. \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/tiger.jpg");
            return angryFace;
   }
}