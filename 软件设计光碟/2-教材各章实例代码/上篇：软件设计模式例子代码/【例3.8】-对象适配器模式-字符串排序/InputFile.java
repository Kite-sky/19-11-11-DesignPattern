
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;


public class InputFile{

	 private String[] stringArray;
	 private ArrayList arList;

     public String[] input(String file){
     arList = new ArrayList();

     try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while(line != null){
           StringTokenizer tokenizer = new StringTokenizer(line); //default delimiters:" \t\n\r\f"

           while(tokenizer.hasMoreTokens()){
		      String tk = tokenizer.nextToken();
              arList.add(tk);
           }
           line = reader.readLine();
        }

        int len = arList.size();
        stringArray = new String[len];

        for(int m=0; m < len; m++) {
		   stringArray[m]= (String)arList.get(m);
		}
    }
    catch(FileNotFoundException exc){
       exc.printStackTrace();
       System.err.println("KWIC Error: Could not open " + file + "file.");
       System.exit(1);
    }
    catch(IOException exc){
       exc.printStackTrace();
       System.err.println("KWIC Error: Could not read " + file + "file.");
       System.exit(1);
    }
    return stringArray;
  }
}