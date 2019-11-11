

public class PolicyProducer{

   public static AutoInsurance getPolicyObj(String option){
      AutoInsurance policy = null;

	  if(option.compareTo("bodyInjure") == 0){
	     policy = new BodyInjur();
	  }
	  else if(option.compareTo("collision") == 0){
	     policy = new Collision();
	  }
	  else if(option.compareTo("com") == 0){
	   	 policy = new Comprehensive();
	  }
	  else if(option.compareTo("personInjure") == 0){
	     policy = new PersonInjur();
	  }
	  return  policy;
    }
}
