

public class President{
    private static President instance;
    private String presidentName = null;

    private President (String name){
            presidentName = name;
    }
    public static President getInstance(String name) {
        if (instance == null && !name.equals(null))  {
            instance = new President (name);
		}
        return instance;
    }
    public void makeSpeech() {
          System.out.println("My name is  "+ presidentName );
          System.out.println("I am the president of the United States." );
    }
}
