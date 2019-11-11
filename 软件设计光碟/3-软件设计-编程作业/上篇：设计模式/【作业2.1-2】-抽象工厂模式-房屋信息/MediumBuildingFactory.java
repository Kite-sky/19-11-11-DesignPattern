

//This is a sub class in the factory class hierarchy abstract factory pattern

public class MediumBuildingFactory extends BuildingFactory {

   public House getHouse(){
      return new MediumHouse();
   }

   public Condo getCondo(){
	  return new MediumCondo();
   }
}
