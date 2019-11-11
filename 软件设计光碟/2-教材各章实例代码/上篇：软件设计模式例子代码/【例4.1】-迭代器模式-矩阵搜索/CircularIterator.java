import java.util.*;
import java.lang.Integer;
import java.util.Iterator;


/*=========================================================*/
/* This class represents an iterator that is designed for iterating through a
/* collection of type Matrix. The purpose is to search for even numbers
/*=========================================================*/
public class CircularIterator implements NumberIterator {
    private ArrayList<Integer> numList =new ArrayList<Integer>();
    private int numOfElements = 0;
    int nextNum;
    int counter=0;
    int nextIndex=-1;

    int[][] mat ;
   	int len=0;
   	int top=0;
   	int bottom;
   	int leftEdge=0;
	int rightEdge;

    public CircularIterator(Matrix mx){
	   mat = mx.getMatrixData();
	   len = mx.getLength();
	   bottom=len-1;
	   rightEdge=len-1;

       loadDataFromMatrixToArrayList();
    }

    private void loadDataFromMatrixToArrayList() {
			for(int loopCount = 0; loopCount<=len/2; loopCount++) {
					  for(int n=leftEdge; n<=rightEdge; n++)
						  numList.add(new Integer(mat[top][n]));
					  for(int m=top+1; m<=bottom; m++)
						  numList.add(new Integer(mat[m][rightEdge]));
					  for(int n=rightEdge-1; n>=leftEdge; n--)
						  numList.add(new Integer(mat[bottom][n]));
					  for(int m=bottom-1; m>top; m--)
						  numList.add(new Integer(mat[m][leftEdge]));
					  top++;
					  bottom--;
					  leftEdge++;
					  rightEdge--;
			}
   }
   public boolean hasNext() {
		 if(counter < numList.size()){
	         numOfElements++;
	         nextIndex++;
	         nextNum=numList.get(nextIndex);
	         counter++;
	   		 return true;
		}
	   else
	       return false;
    }
    public int next(){
	       return numList.get(nextIndex);
    }
    public void remove() {
        numList.remove(nextNum);
    }
    public  int getNumOfItems(){
       return numOfElements;
    }
}
