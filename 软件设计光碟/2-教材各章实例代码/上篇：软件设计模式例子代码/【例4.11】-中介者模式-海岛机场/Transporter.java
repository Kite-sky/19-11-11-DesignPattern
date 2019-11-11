

import javax.swing.*;


public class Transporter implements Airplane{
   private String type;
   private String codednum;
   private double altitude = 0;
   private double airspeed = 0;
   ControlTower tower;
   private JTextArea notes;

   public Transporter(String type, String codednum, ControlTower ctower,JTextArea notes){
      this.type = type;
      this.codednum = codednum;
      tower=ctower;
      this.notes = notes;
      tower.registerTransporter(this);
   }

   public void takeoff(){
      altitude = 30000;
      airspeed = 500;
      notes.append("\nTransporter "+ codednum+ " is taking off");
   }
   public void fly(){
      notes.append("\nTransporter"+ codednum+ "is flying");
   }
   public void land(){
      altitude = 0;
      airspeed = 0;
      notes.append("\nTransporter "+ codednum+ " is landing");
   }
   public void enterHome(){
      altitude = 0;
      airspeed = 0;
      notes.append("\nTransporter "+ codednum+ " is entering home");
   }
   public void moveOutToRunway(){
   	  altitude = 0;
   	  airspeed = 0;
   	  notes.append("\nTransporter "+ codednum+ " is moving to runway.");
   }
   public String toString(){
      String s;
      s = "[airspeed = " + airspeed + " kph, altitude = " + altitude + " feet]";
      return s;
   }
   public void executeTakeoff(){
   	  tower.doTakingoff("transporter");
   }
   public void executeLanding(){
   	  tower.doLanding("transporter");
   }
}

