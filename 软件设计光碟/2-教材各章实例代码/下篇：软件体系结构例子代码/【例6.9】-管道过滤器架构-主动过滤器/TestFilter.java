import java.io. *;

public class TestFilter {
	   public static void main(String[] args) {
			   PipedWriter pipe1_leftEnd = new PipedWriter();
			   PipedReader pipe1_rightEnd  = null;
			   PipedWriter pipe2_leftEnd = new PipedWriter();
			   PipedReader pipe2_rightEnd  = null;
			   PipedWriter pipe3_leftEnd  = new PipedWriter();
			   PipedReader pipe3_rightEnd  = null;
			   try{
					pipe1_rightEnd = new PipedReader(pipe1_leftEnd);
					pipe2_rightEnd = new PipedReader(pipe2_leftEnd);
					pipe3_rightEnd = new PipedReader(pipe3_leftEnd);
			   }
			   catch(IOException io){  }

			   //create filter objects
			   NumFilter1 f1 = new NumFilter1(pipe1_leftEnd );
			   NumFilter2 f2 = new NumFilter2(pipe1_rightEnd, pipe2_leftEnd);
			   NumFilter3 f3 = new NumFilter3(pipe2_rightEnd, pipe3_leftEnd);
			   NumFilter4 f4 = new NumFilter4(pipe3_rightEnd);

			   f1.start();
			   f2.start();
			   f3.start();
			   f4.start();
	   }
}