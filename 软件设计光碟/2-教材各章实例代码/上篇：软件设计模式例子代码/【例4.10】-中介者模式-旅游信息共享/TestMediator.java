


public class TestMediator{

   private static BusinessMediator mediator;

   public static void main(String args[])
   {
      try{
	     mediator = new BusinessMediator();

	  	 new AirlineGUI(mediator);
		 new HotelGUI(mediator);
	  	 new TourGUI(mediator);
	  }
	  catch (Exception ee){
	  	 ee. printStackTrace();
	  }
   }
}