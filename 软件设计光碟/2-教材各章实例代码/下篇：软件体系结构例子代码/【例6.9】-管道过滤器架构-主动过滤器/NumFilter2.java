import java.io. *;


public class NumFilter2 extends Thread {
    PipedReader piped_reader;
    PipedWriter piped_writer;

	public NumFilter2(PipedReader pr, PipedWriter pw) {
		 piped_reader = pr;
		 piped_writer = pw;
	}

    public void run() {
          try {
             while (true) {
				 synchronized(this){
				     int c = piped_reader.read();
			         if ( c != -1){
				           System.out.println(" " );
				           System.out.println("Filter 2 reading = " + c );
				           int m = c+100;
				           piped_writer.write(m);
				           System.out.println("Filter 2 writing = " + m +"\n");
				           Thread.sleep(1000);
				     }
				     else
				           return;
			     }//sync
			}
         }
        catch(Exception e) {}
    }
}