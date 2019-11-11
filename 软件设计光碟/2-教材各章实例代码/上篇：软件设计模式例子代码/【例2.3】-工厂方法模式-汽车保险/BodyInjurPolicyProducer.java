






public class BodyInjurPolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit factory()
    {
        return new BodyInjurLiability();
    }
}
