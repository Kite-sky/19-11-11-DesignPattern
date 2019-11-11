
//This is a sub class in the factory class hierarchy PolicyProducer

public class ComPolicy implements PolicyProducer {

    public AutoInsurance getInsurObj() {
        return new ComCover();
    }
}
