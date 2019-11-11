
//This is a sub class in the factory class hierarchy PolicyProducer

public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
       return new BodyInjur();
    }
}
