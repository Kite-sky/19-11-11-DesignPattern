


public class TestObserverObservable
{
  public static void main(String[] args) throws Exception {

    //create an observable object
    PlainGUI plainObj= new PlainGUI();

    //Create Observer objects
    AntelopeGUI ag = new AntelopeGUI();
    TigerGUI tg = new TigerGUI();

    //Add observers
    plainObj.addObserver(ag);
    plainObj.addObserver(tg);
  }
}