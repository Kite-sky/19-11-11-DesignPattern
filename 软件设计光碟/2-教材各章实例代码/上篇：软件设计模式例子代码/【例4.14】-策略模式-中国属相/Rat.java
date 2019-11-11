//============================== //
// A subclass of the strategy hierarchy
//==============================//
import java.awt.Color;
import javax.swing.ImageIcon;

public class Rat implements ChineseZodiac {

   public String say(){
      String description =
     "You have a zodiac Rat. \n"+
     "The Rat type is very sociable. Such people are full of charm and vivacity, and love being surrounded "+
     "by people. In case of something not goes like planed they are able to quickly assess both the hindrances "+
     "and the new chances, and while others are wondering how to react and what to do, these people have "+
    " already seen and taken advantage of the opportunity that lies there. They are usually strong-willed and "+
     "ambitious. On the other hand they should be careful not to force their ideas on other people. Generally "+
     "these people enjoy all forms of social interaction, and no party is complete without their lively wit and humor. "+

	 "A person born under this sign is extremely hard-working. They want to achieve their goals so much that "+
	 "can seem to be selfish or stubborn, but those who knows rat - people understand that they believe in what "+
	 "they are doing and approach it whole-heartedly. They are very talented and experienced organizers and are "+
	 "able to handle even the most difficult problems. These people are fair in their conduct and expect the same "+
	 "from those they work with in return. So it is important to remember that these people can be deeply affronted "+
	 "if they suspect that they have been deceived or their trust has been abused. It happened that this type of "+
	 "people can set their goals too high, whether in relationship to their friends or in career, but as they are getting "+
	 "older they become more tolerant and wise. \n"+



     "Rats are imaginative, charming, and truly generous to the ones they love. However, "+
      "Rats have a tendency to be quick-tempered and overly critical. At ease with company "+
      "and groups of people, their intelligence and observation allows them to quickly grasp"+
      "a situation from multiple perspectives. Rats know how to spot opportunities and seize "+
     " them, but their opportunism, ambition and restlessness can lead to too many commitments. "+
      "Don't be fooled -- although shrewd in business at times, Rats are passionate lovers, with a "+
      "depth of feeling that is seldom recognized by others."+

      "Personality\n"+
	  "Affectionate, charismatic, eloquent, shrewd, systematic, disciplined, "+
	  "meticulous, sociable, and hardworking with a high aim. Can be intolerant,"+
	  "selfish, vindictive, manipulative, scheming, critical of others, or gossipy."+

	 " Compatibility for Relationship \n "+
	  "Most Compatible With:  Dragon, Monkey, Ox \n"+
	  "Most Incompatible With: Horse, Rabbit, Rooster, Sheep"+
      "Suitable occupations: \n"+
      "Writer, Broadcaster, Actor, Lawyer, Politician, Engineer, Researcher, Manager. \n";

      return description;
   }
   public ImageIcon setImgIcon(){
            ImageIcon angryFace = new ImageIcon("images/rat.jpg");
            return angryFace;
   }
}