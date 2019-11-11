import java.util.ArrayList;
import java.util.Iterator;

public class StudentInfoFacade {
     private String firstName;
     private String lastName;
     private String studentNum;
     private StudentBasicInfo  studentInfo;
     private AcademicRecord   academicRecord;
	 private Award   award;
	 private Tuition tuition;
	 private final String AWARDS = "StudentAward.txt";
	 private final String RECORDS = "StudentAcademicRecord.txt";

     public  StudentInfoFacade(String firstName, String lastName, String studentNum){
           this.firstName = firstName;
           this.lastName = lastName;
           this.studentNum = studentNum;
     }

  // Get comprehensive student information by calling 3 methods
  // in this class, including basic student information, student
  // academic records, and possible awards info. Client class can
  // just call this method to get all the information.
  public String getStudentInfo(){
	    String nm = firstName+" "+lastName;
	    if( StudentBasicInfo.isExistingStudentName(nm)==false) {
			   String msg = "The student with the name doesn't exist.";
		       return msg;
		}

	     String allInfo = null;
         String info = extractStudentInfo();
         String record = extractAcademicRecord();
         String awards = extractAllAwards();

         allInfo = "\nBasic Student Info: \n"+info+"\nAcademic record: \n"+record+"\nAwards: \n"+awards;
         return allInfo;
  }

  //Extract basic student information from a file, which is called from
  //class StudentBasicInfo
  public String extractStudentInfo(){
	      String allInfo = " ";
	      String name = firstName + " " + lastName;
  		  studentInfo = new StudentBasicInfo(name, "1600", studentNum) ;
	      ArrayList<StudentBasicInfoModel> basicInfo = studentInfo.getStudentBasicInfo();

          Iterator infoIterator = basicInfo.iterator();
	      while (infoIterator.hasNext()) {
                   StudentBasicInfoModel infoModel = (StudentBasicInfoModel) infoIterator.next();
                   String nm = infoModel. getName().trim();
                   String birth = infoModel. getBirthDate().trim();
                   String studNum = infoModel. getSerialNum().trim();
                   String ssn = infoModel. getSocialSecurityNum().trim();
                   String mj = infoModel.getMajor().trim();
                   String degree = infoModel.getDegree().trim();

                   allInfo = allInfo +" " + nm+" "+ birth + " " + studNum+ " "+ ssn+" "+mj+" " + degree+"\n";
          }
          return allInfo;
  }

  //Extract academic records from text file RECORDS, accessed from this method
  public String extractAcademicRecord(){
	      String allInfo = " ";

    	  academicRecord = new AcademicRecord(firstName, lastName, studentNum);
    	  ArrayList<StudentAcademicModel> records = academicRecord.getAllScores(RECORDS);
    	  Iterator recordIterator = records.iterator();

  	      while (recordIterator.hasNext()) {
                     StudentAcademicModel recordModel = (StudentAcademicModel)recordIterator.next();
                     String name = recordModel. getStudFirstName().trim();
                     String birth = recordModel. getStudLastName().trim();
                     String studNum = recordModel. getStudSerialNum().trim();

                     String coarseName = recordModel. getCourseTitle().trim();
                     String courseNo = recordModel.getCourseNum().trim();
                     String score = recordModel.getScore().trim();

                     allInfo =allInfo +" " + name +" "+ birth + " " + studNum+ " "+ coarseName+" "+courseNo+" " + score +"\n";
            }
            return allInfo;
  }

  //Extract student awards from text  file AWARDS, accessed from this method
 public String extractAllAwards(){
	      String allInfo = " ";
         award = new Award(firstName, lastName, studentNum);
         ArrayList<StudentAwardModel> awd = award.getAllAwards(AWARDS);
         Iterator awardIterator = awd.iterator();

	      while (awardIterator.hasNext()) {
                   StudentAwardModel awardModel = (StudentAwardModel) awardIterator.next();

                   String firstNm = awardModel. getStudFirstName().trim();
                   String lastNm = awardModel. getStudLastName().trim();
                   String  studNum = awardModel. getStudSerialNum().trim();
                   String awardName = awardModel. getAwardName().trim();
                   String awadDate = awardModel.getAwardDate().trim();

                   allInfo = allInfo +" " + firstNm+" "+ lastNm+ " " + studNum+ " "+ awardName+" "+awadDate+"\n";
          }
          return allInfo;
  }

   // Students are supposed to finish this homework
  public String extractTuitionInfo(){
  	      String allInfo = " ";
          // Students are supposed to finish this part
            return allInfo;
  }
}

