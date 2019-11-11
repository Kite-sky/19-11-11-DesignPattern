

public class Germany extends WorldOrganization{

    String GREETINGS = "Ein gl¨¹ckliches neues Jahr";
    String ERRMESSAGE1 = "The add operation in class Germany is not supported";
	String ERRMESSAGE2 = "The remove operation in class Germany is not supported";

	 public void add(WorldOrganization child) {
	   		 System.err.println(ERRMESSAGE1);
	 }
	 public void remove(WorldOrganization child) {
	   		  System.err.println(ERRMESSAGE2);
   	 }

    public String say(){
       return GREETINGS;
    }
}