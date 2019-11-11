public class SecurityFacade
{
   private Camera camera1;
   private Camera camera2;
   private Light light1, light2, light3;
   private SmokeSensor ss;
   private TeperatureSensor ts;
   private ChemicalSensor cs;
   private HumidSensor hs;
   private WindowSensor ws;
   private WaterSafeSensor wss;
   private PoliceCaller pc;
   private HospitalCaller hc;
   private FireCaller fc;
   private Alarm alarm;
   //private String result="";


   public SecurityFacade() {
      camera1 = new Camera();
      camera2 = new Camera();

      light1 = new  Light();
      light2 = new  Light();
      light3 = new  Light();

      ss = new SmokeSensor() ;
      ts = new TeperatureSensor() ;
      cs = new ChemicalSensor() ;
      hs = new HumidSensor() ;
      ws = new WindowSensor() ;
      wss = new WaterSafeSensor() ;
      pc= new PoliceCaller();
      hc = new HospitalCaller();
      fc = new FireCaller() ;
      alarm = new Alarm();
   }

   public String activate()
   {
	  String[] str1=new String[20];
	  String result1="The following activation activities happened: \n";

	  str1[0] = camera1.turnOn();
      str1[1] = camera2.turnOn();
      str1[2] = light1.turnOn();
      str1[3] = light2.turnOn();
      str1[4] = light3.turnOn();
      str1[5] = ss.activate();
      str1[6] = ts.activate();
      str1[7] = cs.activate();
      str1[8] = hs.activate();
      str1[9] = ws.activate();
      str1[10] = wss.activate();
      str1[11] = pc.activate();
      str1[12] = hc.activate();
      str1[13] = fc.activate();
      str1[14] = alarm.activate();

      for(int k=0; k< 15; k++)
      {
         result1 = result1.concat(str1[k]);

         //System.out.println("result 1="+result1);
         //System.out.println(" str1[8] ="+ str1[8] );
	  }

      return result1;

   }

   public String deactivate()
   {
	  String[] str2 = new String[20];
	  String result2="";

	  str2[0] = camera1.turnOff();
      str2[1] = camera2.turnOff();
      str2[2] = light1.turnOff();
      str2[3] = light2.turnOff();
      str2[4] = light3.turnOff();
      str2[5] = ss.deactivate();
      str2[6] = ts.deactivate();
      str2[7] = hs.deactivate();
      str2[8] = ws.deactivate();
      str2[9] = wss.deactivate();
      str2[10] = pc.deactivate();
      str2[11] = hc.deactivate();
      str2[12] = fc.deactivate();
      str2[13] = alarm.deactivate();

      for(int k=0; k< 14; k++)
	     result2 = result2.concat(str2[k]);

      return result2;
   }

   public String aquireData() {
      String[] str3 = new String[20];
	  String result3="";

      str3[0] = camera1.sendData();
      str3[1] =  camera2.sendData();
      str3[2] =  light1.sendData();
      str3[3] =  light2.sendData();
      str3[4] = light3.sendData();
      str3[5] = ss.sendData();
      str3[6] = ts.sendData();
      str3[7] = hs.sendData();
      str3[8] = ws.sendData();
      str3[9] = wss.sendData();
      str3[10] = alarm.sendData();

      for(int k=0; k< 11; k++)
	     result3 = result3.concat(str3[k]);

      return result3;
  }
   public String call() {
	  String[] str4 = new String[20];
	  String result4="";

      str4[0] = pc.call();
      str4[1] = hc.call();
      str4[2] = fc.call();

      for(int k=0; k< 3; k++)
	  	 result4 = result4.concat(str4[k]);

      return result4;

  }
}



