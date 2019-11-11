
import java.io. *;

public class Pipe extends Thread {
    Filter leftFilter, rightFilter;

	public Pipe( Filter leftFilter,  Filter rightFilter) {
		 this.leftFilter = leftFilter;
		 this.rightFilter = rightFilter;
		 try{
	    	 leftFilter.getWriter().connect(rightFilter.getReader() );
	     }
		 catch(Exception e) {}
	}
    public void run() {
             int d=0;
             int c=0;
             while (true) {
				   synchronized(this){
					     System.out.println("Filter_in  = " + leftFilter);
					     c = leftFilter.read();
					     System.out.println("reading = " + c );

					     d = leftFilter.work(c);
					     leftFilter.write(d);
					     System.out.println("writing = " + d +"\n\n");
					     try {
						  	   Thread.sleep(5000);
					     }
					     catch(Exception e) {}
				   }
		     }///while
	 }
}