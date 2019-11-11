


public class TestSignleton{

    public static void main(String[] argv){
            President president1 = President.getInstance("Bill Clinton");
            president1.makeSpeech();

            President president2 = President.getInstance("Mike Sun");
            president2.makeSpeech();

            President president3 = President.getInstance("Barack Obama");
            president3.makeSpeech();
    }
}