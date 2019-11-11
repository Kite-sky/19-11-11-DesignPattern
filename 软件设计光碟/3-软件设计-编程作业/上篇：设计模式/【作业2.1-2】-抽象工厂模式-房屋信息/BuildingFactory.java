
//This is the super class of the factory classes in the abstract factory pattern

public abstract class BuildingFactory{
  	public static final String SUPER = "Super Class";
  	public static final String MEDIUM = "Medium Class";

  	public abstract House getHouse();
  	public abstract Condo getCondo();

  	public static BuildingFactory getBuildingFactory(String type){
  		 BuildingFactory bf = null;

  		 if (type.equals(BuildingFactory.SUPER)){
			bf = new SuperBuildingFactory();
		 }
  		 else if (type.equals(BuildingFactory.MEDIUM)){
			bf = new MediumBuildingFactory();
		 }

         return bf;
    }
}
