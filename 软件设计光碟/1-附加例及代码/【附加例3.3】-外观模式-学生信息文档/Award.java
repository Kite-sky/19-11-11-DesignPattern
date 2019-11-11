import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Award {
	  private String firstName;
	  private String lastName;
	  private String studNum;
	  private String aFile;
	  private ArrayList<StudentAwardModel> allAwards;

	 //constructor
	  public Award(String fname, String lname, String stuNum) {
		firstName = fname;
		lastName = lname;
		studNum = stuNum;
	  }

    //Get basic student awards information from a text file that is
    //passed in from the parameter
	public ArrayList<StudentAwardModel> getAllAwards(String file){
		  aFile = file;
		  allAwards = new ArrayList();
		  try {
			 BufferedReader reader = new BufferedReader(new FileReader(aFile));
			 String line = reader.readLine();
			 while(line != null) {
				if (line.length() != 0) {
				  String[] arr = line.split("\\,");
				  StudentAwardModel sdam = new StudentAwardModel (arr[0].trim(), arr[1].trim(),
				                                                                                                          arr[2].trim(),arr[3].trim(),
				                                                                                                          arr[4].trim());
				  if( sdam.getStudFirstName().equals(firstName) &&
					  sdam.getStudLastName().equals(lastName) &&
					  sdam.getStudSerialNum().equals(studNum) )

					  allAwards.add(sdam);
				}
				line = reader.readLine();
			  }
		   }
		   catch(FileNotFoundException exc){
			  exc.printStackTrace();
			  System.exit(1);
		   }
		   catch(IOException exc){
			  exc.printStackTrace();
			  System.exit(1);
		   }
		   return allAwards;
	   }

	  public String getFirstName() {
		return firstName;
	  }
	  public String getLastName() {
		return lastName;
	  }
	  public String getStudNumber() {
		  return studNum;
	  }
}

