//=====================================================
// One object of this class represents the format of a student academic
// record, which is formed by:
//       studFirstName;
//       studLastName;
//       studSerialNum;
//       courseTitle;
//       courseNum;
//       score;
//=====================================================

public class StudentBasicInfoModel{
   private String name;
   private String birthDate;
   private String serialNumber;
   private String ssNumber;
   private String major;
   private String degree;

   public StudentBasicInfoModel(String name, String birthDate, String serialNumber,
                                 String ssNumber, String major, String degree) {
      this.name = name;
      this.birthDate = birthDate;
      this.serialNumber = serialNumber;
      this.ssNumber = ssNumber;
      this.major = major;
      this.degree = degree;
   }

   public String getName() {
      return name;
   }
   public String getBirthDate() {
      return birthDate;
   }
   public String getSerialNum() {
      return serialNumber;
   }
   public String getSocialSecurityNum() {
      return ssNumber;
   }
   public String getMajor() {
         return major;
   }
   public String getDegree() {
            return degree;
   }
}
