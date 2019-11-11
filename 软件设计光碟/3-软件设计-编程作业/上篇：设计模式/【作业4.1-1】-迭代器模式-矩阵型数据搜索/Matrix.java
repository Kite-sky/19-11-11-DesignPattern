import java.io.*;
import java.util.*;
import java.util.Random;

/*=======================================================*/
/* This class incapsulates an ArrayList named lineStorage. The collection
/* here will input all the data from a text file to an ArrayList . Thus, an
/* object of this class will contain all data from the input text file
/*=======================================================*/
public class Matrix  implements Aggregate{
   private int length = 7;
   private int[][] matrix = new  int[length][length];

   public Matrix(){
         Random generator = new Random();
		 for(int i = 0; i < length; i++){
			 for(int j = 0;  j < length; j++){
				  matrix[i][j]=generator.nextInt( 99 );
			 }
		 }
   }
   public int[][] getMatrixData() {
	  return matrix;
   }
  public EvenNumIterator createEvenNumIterator() {
     return new EvenNumIterator(this);
  }
  public OddNumIterator createOddNumIterator() {
     return new OddNumIterator(this);
  }
  public CircularIterator createCircularIterator() {
       return new CircularIterator(this);
  }
  public int getLength() {
       return length;
  }
}






