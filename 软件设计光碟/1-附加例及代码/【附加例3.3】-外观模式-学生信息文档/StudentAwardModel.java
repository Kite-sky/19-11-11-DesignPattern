//=====================================================
// One object of this class represents a commodity that has name,
// productType, production location, price and sale date as attributes
//=====================================================

public class StudentAwardModel {
   private String studFirstName;
   private String studLastName;
   private String studSerialNum;
   private String awardName;
   private String awardDate;

   public StudentAwardModel (String studFirstName, String studLastName, String studSerialNum,
                                                         String awardName, String awardDate) {
      this.studFirstName = studFirstName;
      this.studLastName = studLastName;
      this.studSerialNum = studSerialNum;
      this.awardName = awardName;
      this.awardDate = awardDate;
   }

   public String getStudFirstName() {
      return studFirstName;
   }
   public String getStudLastName() {
      return studLastName;
   }
   public String getStudSerialNum() {
      return studSerialNum;
   }
   public String getAwardName() {
      return awardName;
   }
   public String getAwardDate() {
         return awardDate;
   }
}
