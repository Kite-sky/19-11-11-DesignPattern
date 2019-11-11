import java.io.IOException;
import java.io.CharArrayWriter;
import java.lang.Character;
import java.util.Calendar;

public class AnnotFilter extends Filter {

    public AnnotFilter (Pipe input, Pipe output){
          super(input, output);
    }

   /*-----------------------------------------------------------------------*/
   /* Read characters from the input pipe, form a line,
   /* add some annotations to the line and then write
   /* the line as chars into outpipe
   /*-----------------------------------------------------------------------*/
   protected void processData(){
      try{
         CharArrayWriter writer = new CharArrayWriter();
         int c = inPipe.read();

         while(c != -1){ //not end of file
            if(((char) c) == '\n'){ //got a complete line
               String aLine = getALine(writer);
               String lineAnnotated = addAnnotations(aLine);
               writeALineOfCharsToDownStream(lineAnnotated);
               writer.reset();
            }
            else{
               writer.write(c);   // write chars to the data holder writer
		    }
            c = inPipe.read();
         }
         outPipe.closePipedOutputStream();
         inPipe.closePipedInputStream();
      }
      catch(IOException exc){
         exc.printStackTrace();
         System.err.println("Error: failed to make annotation update");
         System.exit(1);
      }
   }

   private String getALine(CharArrayWriter writer){
      String line = writer.toString();
      return line;
   }
   private String addAnnotations(String line1){
       String strline = line1;
       String time = getExecutionTime();
       strline = strline + " Checked at " + time + "\n" ;
	   return strline;
   }
   private void writeALineOfCharsToDownStream(String aLine) throws java.io.IOException{
      int len = aLine.length();
      char[] chars = aLine.toCharArray();

      for(int j = 0; j < chars.length; j++){
         outPipe.write(chars[j]);
      }
   }
   private String getExecutionTime(){
   		  Calendar now = Calendar.getInstance();
		  String time = "time " + now.get(Calendar.YEAR)+ "-"
		                       +(now.get(Calendar.MONTH) + 1)+ "-"
		                       + now.get(Calendar.DATE)+ "-"
		                       + now.get(Calendar.HOUR)+ "-"
		                       + now.get(Calendar.MINUTE)+ "-"
		                       + now.get(Calendar.SECOND)+ "-"
                               + now.get(Calendar.MILLISECOND);
           return time;
    }
}


