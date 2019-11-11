import java.util.*;



  public class TestcaseBubble implements Testcase{
	 private long startTime;
	 private long timeTaken=0;

     public int[] execute(int len) {
		  startTime = System.currentTimeMillis();

		  int[] input = IntegerArrGenerator.generateInput(len);

     	  SortAlgorithm sa = new BubbleSort();
     	  Context context = new Context(sa);
     	  int[] intArray = context.sortIntArray(input);

          timeTaken = System.currentTimeMillis() - startTime;
     	  return intArray;
    }

    public long getTimeTaken(){
		  return 	timeTaken;
	}
  }






