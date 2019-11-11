import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;


public class AssemblyOfPipeLines {
   private String option;
   public AssemblyOfPipeLines(String pipelineOpt) throws IOException{
	  option= pipelineOpt;
   }

   public void assembly(String inFile, JTextArea orig, JTextArea destn) throws IOException {

	  if(option.compareTo(PipeFilterTestGui.PIPELINE1)==0){
         try{
            //Create 4 pipe objects
            Pipe p1 = new Pipe();
      	    Pipe p2 = new Pipe();
      	    Pipe p3 = new Pipe();

      	    //Input from source stream
      	    FileInputStream in = new FileInputStream(PipeFilterTestGui.LEGACYFILES + inFile);

            //Create 5 filter objects
            InputFilter input = new InputFilter(in, p1,orig);
            Y2kFixFilter y2k = new Y2kFixFilter(p1, p2);
            AnnotFilter annot= new AnnotFilter(p2, p3 );
            //SortingFilter sbc = new SortingFilter(p2, p3 );
            OutputFilter output = new OutputFilter(p3, destn,inFile);

            //Start all the filter threads
            input.start();
            y2k.start();
            annot.start();
            ///sbc.start();
            output.start();
         }
         catch(IOException exc) {
            exc.printStackTrace();
         }
      }
      // Switch the order of SortingFilter and Y2kFixFilter objects
      else if(option.compareTo(PipeFilterTestGui.PIPELINE2)==0){
	       // Students add code here
      }
   }
}
