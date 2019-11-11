
public class China extends WorldOrganization{

    String GREETINGS = "ÄãºÃ£¬¹§Ï²·¢²Æ";
    String ERRMESSAGE1 = "The add operation in class China is not supported";
    String ERRMESSAGE2 = "The remove operation in class China is not supported";

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