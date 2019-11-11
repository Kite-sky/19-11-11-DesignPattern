



public class EconomyHouse implements House
{
  		private String name;

  		public EconomyHouse(String cName)
  		{
    			name = cName;
  		}

  		public String getHouseInfo()
  		{
			return "economyHouse.html";
	    }
	    public String getHouseFeatures()
	    {
			return "Economy House ";
  		}

} // End of class