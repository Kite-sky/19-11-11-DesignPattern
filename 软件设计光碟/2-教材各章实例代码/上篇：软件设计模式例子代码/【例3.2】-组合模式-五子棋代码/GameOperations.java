// This class encapsulates all the operations
// needed by the game logic. All the methods
// here are to called by the class Board

public class GameOperations{
      private int LEN = Board.LENGTH;
      private Board b = null;

      public GameOperations(Board b){
		     this.b = b;
	  }

      // Get a right slant line from a 2D integer array, 0 <= k < 29
	  public int[] getALeftSlantLine(int[][] intArr, int k){
			  int n=0;
			  int[] temp = new int[LEN];

			  for(int i=0; i<LEN; i++) {
					for(int j=0; j<LEN; j++) {
						  if(i + j == k){
							   temp[n] = intArr[i][j];
						  } // if
					} // for j ended, only assign term n of temp
					n++;
			   } // for i ended, temp is filled with a left matrix diagonal line
			   return temp;
	  }
      // Get a right slant line from a 2D integer array, k=-14 to 14 inclusive
	  public int[] getARightSlantLine(int[][] intArr, int k){
	  		  int n=0;
	  		  int[] temp = new int[LEN];

			  for(int i=0; i<LEN; i++) {
					for(int j=0; j<LEN; j++) {
						  if(i == j+ k){
							   temp[n] = intArr[i][j];
						  } // if
					} // for j ended, only assign term n of temp
				    n++;
			   } // for i ended, temp is filled with a right matrix diagonal line
				  return temp;
	  }
	  // Check a line to decide if a player wins or not
	  public void checkAline(int[]  a){
	  		  int len = a.length;
	  	 	  for(int m=3; m< len-2; m++){
	  	 				if( (a[m-2]==1)&&(a[m-1]==1)&&(a[m]==1)&&(a[m+1]==1)&&(a[m+2]==1) ){
	  	 				       b.setGameOver(true);
	  					}
	  	 	  }
      }
	  // Check all horizental and vertical lines of the matrix to
	  // see if the black player or white player wins or not
	  public void checkMatixLines(int[][] intArr){
	  		  for(int n=0; n<LEN; n++){
	  				  int[] b = new int[LEN];
	  				  for(int i=0; i<LEN; i++)
	  						b[i] = intArr[i][n];
	  				  checkAline(b);
	  		  }
	  		  for(int m=0; m<LEN; m++){
	  				  int[] c = new int[LEN];
	  				  for(int j=0; j<LEN; j++)
	  						c[j] = intArr[m][j];
	  				  checkAline(c);
	  		  }
      }
	  // Check all left slant lines of the matrix to see if
      // the black player or white player wins or not
	  public void checkLeftSlantDiagonal(int[][] board){
			  for (int k=0; k<2*LEN-1; k++) {
					  int[] temp = new int[LEN];
					  temp=getALeftSlantLine(board, k);
					  checkAline(temp);
			  }
	  }
	   // Check all right slant lines of the matrix to see if
      // the black player or white player wins or not
	  public void checkRightSlantDiagonal(int[][] board){
			 for (int k=-(LEN-1); k<LEN; k++) {
					  int[] temp = new int[LEN];
					  temp=getARightSlantLine(board, k);
                      checkAline(temp);
			 }
	  }
}