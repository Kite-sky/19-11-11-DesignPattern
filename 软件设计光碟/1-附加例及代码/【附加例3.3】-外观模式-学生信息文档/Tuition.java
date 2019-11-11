import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Tuition {
	  private String firstName;
	  private String lastName;
	  private String studNum;
	  private final String STUDENT_TUITION_FILE = "Tuition.txt";
	  private ArrayList<String> studentTuition;

	 //constructor
	  public Tuition(String fname, String lname, String stuNum) {
		firstName = fname;
		lastName = lname;
		studNum = stuNum;
	  }

 //Get tuition information paid by students
 public ArrayList<String> getStudentTuitionInfo(){
			studentTuition = new ArrayList();
			try {
			   BufferedReader reader = new BufferedReader(new FileReader(STUDENT_TUITION_FILE));
			   String line = reader.readLine();
			   while(line != null) {
				if (line.length() != 0) {
				  String[] arr = line.split("\\,");

				  if( arr[0].trim().equals(firstName) && arr[1].trim().equals(lastName)&& arr[2].trim().equals(studNum)   )
					  studentTuition.add(line);
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
			 return  studentTuition;
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

