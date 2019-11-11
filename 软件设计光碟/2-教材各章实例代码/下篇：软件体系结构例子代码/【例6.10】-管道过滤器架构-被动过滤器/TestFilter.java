import java.io. *;

public class TestFilter {
	   public static void main(String[] args) {
              Filter f1 = new Filter1();
              Filter f2 = new Filter2();
              Filter f3 = new Filter3();
              Filter f4 = new Filter4();

			  Pipe p1= new Pipe(f1, f2);
			  Pipe p2= new Pipe(f2, f3);
			  Pipe p3= new Pipe(f3, f4);

			  p1.start();
			  p2.start();
			  p3.start();
	   }
}