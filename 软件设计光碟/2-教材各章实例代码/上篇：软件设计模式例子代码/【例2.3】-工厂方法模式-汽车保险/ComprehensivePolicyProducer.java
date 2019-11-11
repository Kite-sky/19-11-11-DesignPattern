





public class ComprehensivePolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit factory()
    {
        return new ComprehensiveCoverage();
    }
}
