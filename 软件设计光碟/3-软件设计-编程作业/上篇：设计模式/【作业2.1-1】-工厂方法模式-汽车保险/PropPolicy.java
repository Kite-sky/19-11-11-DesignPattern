
//This is a sub class in the factory class hierarchy PolicyProducer



public class PropPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new Property();
   }
}