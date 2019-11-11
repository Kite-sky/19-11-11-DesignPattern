import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AcademicRecord {
  private String firstName;
  private String lastName;
  private String studNum;
  //private String courseName;
  //private String courseNumber;
  //private String courseScore;
  private String aFile;

  private ArrayList<StudentAcademicModel> allScores;

  //constructor
  public AcademicRecord(String firstName, String lastName, String studNum ) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.studNum = studNum;
  }

  //Get basic student academic information from a text file that is
  //passed in from the parameter
  public ArrayList<StudentAcademicModel> getAllScores(String file){
        aFile = file;
        allScores = new ArrayList();
        try {
           BufferedReader reader = new BufferedReader(new FileReader(aFile));
           String line = reader.readLine();
           while(line != null) {
  			if (line.length() != 0) {
  		      String[] arr = line.split("\\,");
  	          StudentAcademicModel sdam = new StudentAcademicModel (arr[0].trim(), arr[1].trim(),
  	                                                                                                                               arr[2].trim(), arr[3].trim(),
  	                                                                                                                               arr[4].trim(), arr[5].trim());
  	          if( sdam.getStudFirstName().equals(firstName) &&
  	              sdam.getStudLastName().equals(lastName) &&
  	              sdam.getStudSerialNum().equals(studNum) )

  			      allScores.add(sdam);
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
         return allScores;
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

