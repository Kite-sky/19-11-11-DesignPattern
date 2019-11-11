






public abstract class BuildingFactory
{
  	public static final String SUPER = "Super Class";
  	public static final String MEDIUM = "Medium Class";
  	public static final String ECONOMY = "Economy Class";

  	public abstract House getHouse();
  	public abstract Condo getCondo();

  	public static BuildingFactory getBuildingFactory(String type)
  	{
  		if (type.equals(BuildingFactory.SUPER))
  		    return new SuperBuildingFactory();

  		 if (type.equals(BuildingFactory.MEDIUM))
  		    return new MediumBuildingFactory();

  		 if (type.equals(BuildingFactory.ECONOMY))
  		    return new EconomyBuildingFactory();

    	  return new SuperBuildingFactory();  //???
    }

} // End of class
