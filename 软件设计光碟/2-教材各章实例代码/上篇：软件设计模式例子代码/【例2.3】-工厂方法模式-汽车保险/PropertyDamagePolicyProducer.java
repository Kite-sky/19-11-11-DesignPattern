





public class PropertyDamagePolicyProducer implements PolicyProducer
{
    public AutoInsurance getPolicyObj() //Fruit factory()
    {
        return new PropertyDamageLiability();
    }
}
