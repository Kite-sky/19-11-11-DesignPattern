import java.io. *;

public class NumFilter1 extends Thread {
      PipedWriter piped_writer;

      public NumFilter1(PipedWriter pw) {
		  piped_writer = pw;
	  }
      public void run() {

			try {
					for (int j = 1; j<100; j++){
						synchronized(this){
						      piped_writer.write(j ) ;
						      System.out.println(" " );
						      System.out.println("Filter 1 writing = " + j+"\n" );
						      Thread.sleep(1000);
					     }
					}
					piped_writer.write(-1) ;
			}
			catch(Exception e) {
			}
	  }
}