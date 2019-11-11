


public class TestObserverObservable
{
  public static void main(String[] args) throws Exception {

    //create an observable object
    PlainGUI plainObj= new PlainGUI();

    //Create Observer objects
    new TigerGUI(plainObj);
    new AntelopeGUI(plainObj);
  }
}