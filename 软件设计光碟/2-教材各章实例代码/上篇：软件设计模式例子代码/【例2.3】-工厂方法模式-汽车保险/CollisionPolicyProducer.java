






public class CollisionPolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit factory()
    {
        return new CollisionCoverage();
    }
}
