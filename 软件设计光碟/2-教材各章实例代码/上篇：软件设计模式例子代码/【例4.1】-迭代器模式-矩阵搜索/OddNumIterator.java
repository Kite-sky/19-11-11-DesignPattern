import java.util.*;
import java.lang.Integer;
/*=========================================================*/
/* This class represents an iterator that is designed for iterating through a
/* collection of type Matrix. The purpose is to search for odd numbers
/*=========================================================*/
public class OddNumIterator implements NumberIterator {
   private ArrayList<Integer> numList =new ArrayList<Integer>();
   private int lowBound=0;
   private int numOfEvens = 0;
   int nextNum;

   public OddNumIterator(Matrix mx){
	   int[][] mat = mx.getMatrixData();
	   int len = mx.getLength();
	   for(int i=0; i<len; i++){
	      for(int j=0; j<len; j++){
	   			numList.add(new Integer(mat[i][j]));
	   	  }
	   }
   }
   public boolean hasNext() {
      boolean matchFound = false;
      //Find an odd number
      for( int n = lowBound; n < numList.size(); n++ ){
	     int num = (int)numList.get(n);
	     if ( num%2 == 1) {
			numOfEvens++;
		    matchFound = true;
		    nextNum = num;
		    lowBound = n+1;
		    break;
         }
      }
      if (matchFound == true)
	     return matchFound;
	  else
	     nextNum = -1;
      return matchFound;
  }
  public int next(){
     if (nextNum == -1)
        throw new NoSuchElementException();
     else
        return nextNum;
  }
  public void remove() {
     numList.remove(nextNum);
  }
  public  int getNumOfItems(){
     return numOfEvens;
  }
}
