

import javax.swing.*;


public class Battleplane implements Airplane{
   private String type;
   private String codednum;
   private double altitude = 0;
   private double airspeed = 0;
   private JTextArea notes;

   ControlTower tower;

   public Battleplane(String type, String codednum, ControlTower ctower, JTextArea notes){
      this.type = type;
      this.codednum = codednum;
      tower=ctower;
      this.notes = notes;
      tower.registerBattleplane(this);
   }

   public void takeoff(){
      altitude = 30000;
      airspeed = 500;
      notes.append("\nBattleplane "+ codednum+ " is taking off");
   }
   public void fly(){
	  notes.append("\nBattleplane "+ codednum+ " is flying");
   }
   public void land(){
      altitude = 0;
      airspeed = 0;
      notes.append("\nBattleplane "+ codednum+ " is landing");
   }
   public void enterHome(){
      altitude = 0;
      airspeed = 0;
      notes.append("\nBattleplane "+ codednum+ " is entering home");
   }
   public void moveOutToRunway(){
      altitude = 0;
      airspeed = 0;
      notes.append("\nBattleplane "+ codednum+ " is moving to runway.");
   }
   public String toString(){
      String s;
      s = "[airspeed = " + airspeed + " kph, altitude = " + altitude + " feet]";
      return s;
   }
   public void executeTakeoff(){
	  tower.doTakingoff("battle");
   }
   public void executeLanding(){
	  tower.doLanding("battle");
   }
}

