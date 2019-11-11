
import java.io. *;

public class NumFilter4 extends Thread {
    PipedReader piped_reader;

	public NumFilter4(PipedReader pr) {
		 piped_reader = pr;
	}
    public void run() {
          try {
             while (true) {
				 synchronized(this){
					  int c = piped_reader.read();
					  if ( c != -1){
							 System.out.println(" "  );
							 System.out.println("Filter 4 reading = " + c );
							 int m = c+300;
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