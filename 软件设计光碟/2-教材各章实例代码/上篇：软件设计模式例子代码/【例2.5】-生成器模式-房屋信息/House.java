
import java.util.*;


class House{
   private String type = null;
   private String area;
   private String bedroom;
   private String bathroom;
   private String garage;
   private String garden;
   private String swimmingPool;
   private List features = new ArrayList();

   final int LuxAreaUnitPrice = 8000;
   final int LuxBedrmUnitPrice = 7000;
   final int LuxBathrmUnitPrice = 5000;
   final int LuxGarage1Price = 20000;
   final int LuxGarage2Price = 40000;
   final int LuxSmallGardenPrice = 20000;
   final int LuxBigGardenPrice = 40000;
   final int LuxSmallSwimpoolPrice = 30000;
   final int LuxBigSwimpoolPrice = 80000;

   final int NormAreaUnitPrice = 6000;
   final int NormBedrmUnitPrice = 5000;
   final int NormBathrmUnitPrice = 3000;
   final int NormGarage1Price = 15000;
   final int NormGarage2Price = 28000;
   final int NormSmallGardenPrice = 15000;
   final int NormBigGardenPrice = 30000;

   final int EconAreaUnitPrice = 4000;
   final int EconBedrmUnitPrice = 3500;
   final int EconBathrmUnitPrice = 2000;
   final int EconGarage1Price = 10000;
   final int EconGarage2Price = 20000;

   public House(){
   }
   public void setType(String type){
       this.type = type;
   }
   public void setArea(String area){
	   this.area = area;
   }
   public void setBedroom(String bedroom){
	   this.bedroom = bedroom;
   }
   public void setBathroom(String bathroom){
	   this.bathroom = bathroom;
   }
   public void setGarage(String garage){
	   this.garage = garage;
   }
   public void setGarden(String garden){
	   this.garden = garden;
   }
   public void setSwimmingPool(String swimmingPool){
	   this.swimmingPool = swimmingPool;
   }
   public String getType(){
       return type;
   }
   public String getArea(){
	   return area;
   }
   public String getBedroom(){
	   return bedroom;
   }
   public String getBathroom(){
	   return bathroom;
   }
   public String getGarage(){
	   return garage;
   }
   public String getGarden(){
	   return garden;
   }
   public String getSwimmingPool(){
	   return swimmingPool;
   }

   public int getHousePrice(){
	  int totalPrice = 0;
	  int intArea = 0;
	  int intBedrmNum = 0;
	  int intBathroomNum = 0;
	  int garagePrice = 0;
	  int gardenPrice = 0;
	  int swimpoolPrice = 0;

	  if(area != null){
	     String[] a = area.split("\\s");
	     intArea = Integer.parseInt(a[0]);
	  }
	  if(bedroom != null){
	     intBedrmNum = Integer.parseInt(bedroom);
	  }
	  if(bathroom != null){
	   	 intBathroomNum = Integer.parseInt(bathroom);
	  }

	  if(type.compareTo(EconHouseBuilder.ECONOMY_TYPE)==0){
		 if(garage.compareTo(EconHouseBuilder.SMALL_GARAGE)==0){
		    garagePrice = EconGarage1Price;
		 }
		 else if(garage.compareTo(EconHouseBuilder.BIG_GARAGE)==0){
		    garagePrice = EconGarage2Price;
		 }
		 totalPrice =  intArea* EconAreaUnitPrice
		                + intBedrmNum*EconBedrmUnitPrice
		                + intBathroomNum*EconBathrmUnitPrice
		                + garagePrice;
	   }
	   else if(type.compareTo(NormHouseBuilder.NORMAL_TYPE)==0){
	      if(garage.compareTo(NormHouseBuilder.SMALL_GARAGE)==0){
	         garagePrice = NormGarage1Price;
		  }
	   	  else if(garage.compareTo(NormHouseBuilder.BIG_GARAGE)==0){
	   		 garagePrice = NormGarage2Price;
		  }
		  if(garden.compareTo(NormHouseBuilder.SMALL_GARDEN)==0){
		  	 gardenPrice = NormSmallGardenPrice;
		  }
		  else if(garden.compareTo(NormHouseBuilder.BIG_GARDEN)==0){
		  	 gardenPrice = NormBigGardenPrice;
		  }
	   	  totalPrice =  intArea* NormAreaUnitPrice
	   		            + intBedrmNum*NormBedrmUnitPrice
	   		            + intBathroomNum*NormBathrmUnitPrice
	   		            + garagePrice
	   		            + gardenPrice;
	   }
	   else if(type.compareTo(LuxHouseBuilder.LUXURY_TYPE)==0){
	      if(garage.compareTo(LuxHouseBuilder.SMALL_GARAGE)==0){
	   	     garagePrice = LuxGarage1Price;
	   	  }
	   	  else if(garage.compareTo(LuxHouseBuilder.BIG_GARAGE)==0){
	   	     garagePrice = LuxGarage2Price;
	   	  }

	   	  if(garden.compareTo(LuxHouseBuilder.SMALL_GARDEN)==0){
			 gardenPrice = LuxSmallGardenPrice;
		  }
		  else if(garden.compareTo(LuxHouseBuilder.BIG_GARDEN)==0){
			 gardenPrice = LuxBigGardenPrice;
	   	  }

	   	  if(swimmingPool.compareTo(LuxHouseBuilder.SMALL_SWIMING_POOL)==0){
		     swimpoolPrice = LuxSmallSwimpoolPrice;
		  }
		  else if(swimmingPool.compareTo(LuxHouseBuilder.BIG_SWIMING_POOL)==0){
			 swimpoolPrice = LuxBigSwimpoolPrice;
	   	  }
	   	  totalPrice =  intArea* LuxAreaUnitPrice
	   	   		        + intBedrmNum*LuxBedrmUnitPrice
	   	   		        + intBathroomNum*LuxBathrmUnitPrice
	   	   		        + garagePrice
	   	   		        + gardenPrice
	   	   		        + swimpoolPrice;
	   }
	   return totalPrice;
   }
}