import java.io. *;


public class NumFilter3 extends Thread {
    PipedReader piped_reader;
    PipedWriter piped_writer;

	public NumFilter3(PipedReader pr, PipedWriter pw) {
		 piped_reader = pr;
		 piped_writer = pw;
	}

    public void run() {
          try {
             while (true) {
				 synchronized(this){
					  int c = piped_reader.read();
					  if ( c != -1){
							 System.out.println(" "  );
							 System.out.println("Filter 3 reading = " + c );
							 int m = c+200;
							 piped_writer.write(m);
							 System.out.println("Filter 3 writing = " + m+"\n" );
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