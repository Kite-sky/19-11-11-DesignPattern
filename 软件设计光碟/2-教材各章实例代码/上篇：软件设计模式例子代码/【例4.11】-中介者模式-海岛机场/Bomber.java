

import javax.swing.*;


public class Bomber implements Airplane{
   private String type;
   private String codednum;
   private double altitude = 0;
   private double airspeed = 0;
   ControlTower tower;
   private JTextArea notes;

   public Bomber(String type, String codednum,ControlTower ctower,JTextArea notes){
      this.type = type;
      this.codednum = codednum;
      tower=ctower;
      this.notes = notes;
      tower.registerBomber(this);
   }

   public void takeoff(){
      altitude = 30000;
      airspeed = 500;
      notes.append("\nBomber "+ codednum+ " is taking off");
   }
   public void fly(){
   	  notes.append("\nBomber "+ codednum+ " is flying");
   }
   public void land(){
      altitude = 0;
      airspeed = 0;
      notes.append("\nBomber "+ codednum+ " is landing");
   }
   public void enterHome(){
      altitude = 0;
	  airspeed = 0;
	  notes.append("\nBomber "+ codednum+ " is entering home");
   }
   public void moveOutToRunway(){
	  altitude = 0;
	  airspeed = 0;
	  notes.append("\nBomber "+ codednum+ " is moving to runway.");
   }
   public String toString(){
      String s;
      s = "[airspeed = " + airspeed + " kph, altitude = " + altitude + " feet]";
      return s;
   }
   public void executeTakeoff(){
	  tower.doTakingoff("bomber");
   }
   public void executeLanding(){
	  tower.doLanding("bomber");
   }
}

