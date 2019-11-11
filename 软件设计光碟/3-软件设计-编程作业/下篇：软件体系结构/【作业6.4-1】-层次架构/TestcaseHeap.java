
import java.util.*;

public class TestcaseHeap implements Testcase{
     //static long time;
     private long startTime;
	 private long timeTaken=0;

     public int[] execute(int len){

		startTime = System.currentTimeMillis();
		int[] input = IntegerArrGenerator.generateInput(len);

		SortAlgorithm sa = new HeapSort();
		Context context = new Context(sa);
		int[] intArray = context.sortIntArray(input);
		timeTaken = System.currentTimeMillis()-startTime;

        return intArray;
    }
    public long getTimeTaken(){
			  return 	timeTaken;
	}
  }