
/*===========================*/
/*This is the Mediator class */
/*===========================*/
import javax.swing.*;

public class ControlTower{
   Battleplane battle;
   Bomber bomber;
   Transporter transporter;
   private JTextArea notes;

   String runWay;
   String[] home;
   String[] air;
   int homeOccupation=0;

   public final String BATTLE ="battle";
   public final String BOMBER ="bomber";
   public final String TRANS ="transporter";

   public ControlTower(JTextArea notes){
	  this.notes = notes;
      home = new String[3];
	  air  = new String[3];
	  runWay = "";
	  home[0]=TRANS;
	  home[1]=BOMBER;
	  home[2]=BATTLE;
	  air[0]="";
	  air[1]="";
	  air[2]="";
   }

   void registerBattleplane(Battleplane bp){
      battle = bp;
   }
   void registerBomber(Bomber bb){
      bomber = bb;
   }
   void registerTransporter(Transporter tp){
      transporter = tp;
   }
   void doLanding(String type){
	  if( (type.compareTo(air[0])==0) || (type.compareTo(air[1])==0) ||
		    (type.compareTo(air[2])==0) )  // air craft in air
	  {
	     sendRunwayPlaneHomeIfAny();
		 if( type.compareTo(BATTLE)==0 ) {
		    battle.land();
			runWay = BATTLE;
			air[2]="";
	     }
		 else if( type.compareTo(BOMBER)==0 ) {
		    bomber.land();
			runWay=BOMBER;
			air[1]="";
		 }
		 if( type.compareTo(TRANS)==0 ) {
		    transporter.land();
			runWay=TRANS;
			air[0]="";
	     }
	  }
	  else{
	     notes.append("\n"+type + " is not in air and cannot do landing.");
	  }
   }
   void doTakingoff(String type){
	  if( (type.compareTo(air[0])!=0) && (type.compareTo(air[1])!=0) &&
	      (type.compareTo(air[2])!=0) ) // type is not in the air
	  {
	      if( runWay.compareTo(type)==0 ) //type is on the runway
		  {
		     setupTakeoff(type);
		  }
		  else if( runWay.compareTo(type)!=0 ) {
		     sendRunwayPlaneHomeIfAny();
			 moveToRunway(type);
			 setupTakeoff(type);
		  }
	  }
	  else{
	     notes.append("\n"+type + " has already been in air");
	  }
   }
   void setupTakeoff(String type){
      if( type.compareTo(BATTLE)==0 ) {
	     battle.takeoff();
		 runWay = "";
		 air[2]=BATTLE;
	  }
	  else if( type.compareTo(BOMBER)==0 ) {
	     bomber.takeoff();
		 runWay="";
		 air[1]=BOMBER;
	  }
	  else if( type.compareTo(TRANS)==0 ) {
	     transporter.takeoff();
		 runWay="";
		 air[0]=TRANS;
	  }
   }
   void moveToRunway(String type){
	  if( type.compareTo(BATTLE)==0 ) {
	     battle.moveOutToRunway();
		 runWay = BATTLE;
		 home[2]= "";
	  }
	  else if( type.compareTo(BOMBER)==0 ) {
	     bomber.moveOutToRunway();
		 runWay=BOMBER;
		 home[1]= "";
	  }
	  else if( type.compareTo(TRANS)==0 ) {
	     transporter.moveOutToRunway();
		 runWay=TRANS;
		 home[0]="";
	  }
   }
   void sendRunwayPlaneHomeIfAny(){
	  if(runWay.compareTo("")!=0){
		 if( runWay.compareTo(BATTLE)==0 ) {
		    battle.enterHome();
			home[2]=BATTLE;
			runWay="";
		 }
		 else if( runWay.compareTo(BOMBER)==0 ) {
			bomber.enterHome();
			home[1]=BOMBER;
			runWay="";
		 }
		 else if( runWay.compareTo(TRANS)==0 ) {
		    transporter.enterHome();
			home[0]=TRANS;
			runWay="";
		 }
	  }
   }
   public String[] getPlaneHomeData(){
	  return home;
   }
   public String[] getPlaneInAirData(){
	  return air;
   }
   public String getRunwayData(){
	  return runWay;
   }
}