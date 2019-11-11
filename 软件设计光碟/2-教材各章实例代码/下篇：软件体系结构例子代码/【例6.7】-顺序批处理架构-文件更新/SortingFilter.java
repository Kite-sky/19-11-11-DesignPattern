
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SortingFilter implements BatchSeqFilter {
   private JTextArea resultTxt;
   private BufferedReader input = null;
   private BufferedWriter output = null;

   public SortingFilter(String inFile, String outFile, JTextArea resultTxtA)throws IOException{
      input = new BufferedReader(new FileReader(inFile));
	  output = new BufferedWriter(new FileWriter(outFile));
      resultTxt = resultTxtA;
   }

   /*----------------------------------------------*/
   /* Read chars from the input pipe, and sort the */
   /* data alphabetically, and then write the      */
   /* resultant data into sink pipe char by char   */
   /*----------------------------------------------*/
   public void processData(){
      try{
	     ArrayList allLines = readLinesAndSetUpLines();
	     Object[] sortedLines = sort(allLines);
	     writeLinesToFile(sortedLines);
	  }
	  catch(IOException exc){
	     exc.printStackTrace();
	     System.err.println("Error: failed to make y2k update");
	     System.exit(1);
      }
   }

   private ArrayList readLinesAndSetUpLines()
                         throws IOException{
      ArrayList<String> lines = new ArrayList<String>();

	  String line = input.readLine();
	  while(line != null){ //not end of file
         lines.add(line);
         line = input.readLine();
      }

      return lines;
   }

   private Object[] sort(ArrayList lines){
      Object[] strArray = lines.toArray();
      Arrays.sort(strArray);//modified mergesort
      return strArray;
   }

   private void writeLinesToFile(Object[] lines)
                   throws java.io.IOException {
      int len = lines.length;
      for(int m = 0; m < len; m++ ){
	     String aLine = (String)lines[m];
	     resultTxt.append(""+aLine+"\n");
	     output.write(aLine+"\n");
	  }
	  if (input != null){
	     input.close();
	  }
	  if (output != null){
	  	 output.close();
	  }
   }
}

















   /*------------------------------------------*/
   /* Sorts lines in alphabetical order using  */
   /* heap sort algorithm                      */
   /*------------------------------------------*/

  /*
  private void sort(ArrayList lines){ // heap sort
    int size = lines.size();

    for(int i = (size / 2 - 1); i >= 0; i--)
      siftDown(lines, i, size);

    for(int i = (size - 1); i >= 1; i--){
      Object tmp = lines.get(0);
      lines.set(0, lines.get(i));
      lines.set(i, tmp);
      siftDown(lines, 0, i);
    }
  }

  //This method builds and reconstucts the heap for the heap sort algorithm.
  private void siftDown(ArrayList lines, int root, int bottom){
    int max_child = root * 2 + 1;

    while(max_child < bottom){
      if((max_child + 1) < bottom)
        if(((String) lines.get(max_child + 1)).compareToIgnoreCase((String) lines.get(max_child)) > 0)
          max_child++;

      if(((String) lines.get(root)).compareToIgnoreCase((String) lines.get(max_child)) < 0){
        Object tmp = lines.get(root);
        lines.set(root, lines.get(max_child));
        lines.set(max_child, tmp);
        root = max_child;
        max_child = root * 2 + 1;
      }else
        break;
    }
  }
}

*/