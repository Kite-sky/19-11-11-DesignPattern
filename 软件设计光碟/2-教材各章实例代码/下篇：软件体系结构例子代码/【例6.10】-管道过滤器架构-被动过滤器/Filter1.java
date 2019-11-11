
import java.io. *;

public class Filter1 extends Filter {
    int count=0;

	public Filter1() {
	      super();
	}
    public int work(int c) {
		  return c;
    }
    public int read(){
		 if(count < 30) {
			   try{
					piped_writer.write(count);
					count++;
			   }
			   catch(Exception e) {}
		 }
		 return count;
    }
}