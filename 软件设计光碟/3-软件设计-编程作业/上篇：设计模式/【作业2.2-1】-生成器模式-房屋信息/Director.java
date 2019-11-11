
//This is the director in the builder pattern

public class Director{
   private HouseBuilder hsBuilder;

   public void setHouseBuilder(HouseBuilder hb){
      hsBuilder = hb;
   }
   public House getHouse(){
      return hsBuilder.getHouse();
   }

   public void constructWholeHouseObj() {
	  hsBuilder.createNewHouseProduct();
	  hsBuilder.buildType();
	  hsBuilder.buildArea();
	  hsBuilder.buildBedroom();
	  hsBuilder.buildBathroom();
	  hsBuilder.buildGarage();
	  hsBuilder.buildGarden();
	  hsBuilder.buildSwimmingpool();
   }
}




