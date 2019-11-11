//==============================================
// A context class in the Strategy pattern. Need a parameter
// from the user interface. This context class is in charge of
// creating object of an object of the sub class of the
// strategy class hierarchy
//==============================================
import java.io.*;
import javax.swing.ImageIcon;

class Context {
    ChineseZodiac zodiac;
    String year;
    String month = null;
    String date = null;
    String[]  z = {"rat", "ox", "tiger", "rabbit", "dragon", "snake", "horse",
                        "sheep", "monkey", "rooster", "dog", "pig"};
	String[] yz = new String[2200];
	boolean flag = false;

    // Constructor
    public Context(String year, String month, String date) {
        this.year = year;
        this.month = month;
        this.date = date;
        createZodiacObj();
    }

   public String getZodiacDescription() {
       return zodiac.say();
    }
    public ImageIcon getImageIcon(){
		return zodiac.setImgIcon();
    }

   public ChineseZodiac createZodiacObj(){
	   int intYear = Integer.parseInt(year);
	   setupZodiacToYear();
	   parseZodiac();

	   if(yz[intYear].equals("rat")){
	       if(flag == true)
	           zodiac = new Rat();
	       else
	           zodiac = new Pig();
	   }
	   else if (yz[intYear].equals("ox")){
		   if(flag == true)
		 	   zodiac = new Ox();
		   else
	           zodiac = new Rat();
	   }
	   else if (yz[intYear].equals("tiger")){
		   if(flag == true)
		 	  zodiac = new Tiger();
		   else
	           zodiac = new Ox();
	   }
	   else if (yz[intYear].equals("rabbit")){
		   if(flag == true)
		 	    zodiac = new Rabbit();
		   else
	           zodiac = new Tiger();
	   }
	   else if (yz[intYear].equals("dragon")){
		   if(flag == true)
		 	   zodiac = new Dragon();
		  else
	           zodiac = new Rabbit();
       }
	   else if (yz[intYear].equals("snake")){
		   if(flag == true)
		 		 zodiac = new Snake();
		   else
	             zodiac = new Dragon();
       }
	   else if (yz[intYear].equals("horse")){
		    if(flag == true)
		   		 zodiac = new Horse();
		   else
	             zodiac = new Snake();
       }
	   else if (yz[intYear].equals("sheep")){
		    if(flag == true)
		         zodiac = new Sheep();
		   else
	             zodiac = new Horse();
	   }
	   else if (yz[intYear].equals("monkey")){
		   if(flag == true)
		 		zodiac = new Monkey();
		   else
	             zodiac = new Sheep();
       }
	   else if (yz[intYear].equals("rooster")){
		   if(flag == true)
		 		 zodiac = new Rooster();
		   else
	             zodiac = new Monkey();
       }
	   else if (yz[intYear].equals("dog")){
		   if(flag == true)
		 		 zodiac = new Dog();
		   else
	             zodiac = new Rooster();
       }
	   else if (yz[intYear].equals("pig")){
		   if(flag == true)
		 	  zodiac = new Pig();
		   else
	          zodiac = new Dog();
	   }
       return zodiac;
	}

// Set the zodiac Strings to the years, for example,
// set year 1948 as the rat year, 1949 as the ox year.
// The zodiacs will rotate every 12 years.
private void setupZodiacToYear(){
		for(int k=0; k< 6;k++){
			 yz[1948+ k*12] = z[0];
			 yz[1949+ k*12] = z[1];
			 yz[1950+ k*12] = z[2];
			 yz[1951+ k*12] = z[3];
			 yz[1952+ k*12] = z[4];
			 yz[1953+ k*12] = z[5];
			 yz[1954+ k*12] = z[6];
			 yz[1955+ k*12] = z[7];
			 yz[1956+ k*12] = z[8];
			 yz[1957+ k*12] = z[9];
			 yz[1958+ k*12] = z[10];
			 yz[1959+ k*12] = z[11];
	   }
 }

// The year entered by the user is the Sun calendar, while the Chinese zodiac
// uses the Chinese Moon calendar and thus the moon calendar new year is
// different from that of the Sun calendar. This method divides the Sun calendar year
// into two parts, by using the Moon new year. For example, if a baby is born in 2010,
// then if he was born before the moon new year, January 25, he has a zodiac Ox,
// but if he is born on or after January 25, he has a zodiac tiger. This method will
// assign a boolean flag with true if the person was born on/after the moon new year,
// else if the person was born before the moon new year, the flag will be assign value
// false. This flag will be used by the method createZodiacObj().
public void parseZodiac(){
	  String aFile="ChinaYear.txt";
	  String[] arr = new String[3];
	  try {
		 BufferedReader reader = new BufferedReader(new FileReader(aFile));
		 String line = reader.readLine();
		 while(line != null) {
			if (line.length() != 0)
			   arr = line.split("\\,");

			if(year.equals(arr[0])){
					int m1 = Integer.parseInt(month);
					int m2 = Integer.parseInt(arr[1]);
					int d1  = Integer.parseInt(date);
					int d2  = Integer.parseInt(arr[2]);

					if(m1 < m2)
						 flag = false;
					else if(m1 > m2)
						 flag = true;
					else if(m1 == m2){
						 if(d1 < d2)
							  flag = false;
						 else
							  flag = true;
					}
			 }
			 line = reader.readLine();
		  } //end while loop
	   }
	   catch(FileNotFoundException exc){
		  exc.printStackTrace();
		  System.exit(1);
	   }
	   catch(IOException exc){
		  exc.printStackTrace();
		  System.exit(1);
	  }
   }
}