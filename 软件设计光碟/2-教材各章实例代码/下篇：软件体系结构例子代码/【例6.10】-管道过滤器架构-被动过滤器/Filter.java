import java.io. *;

public abstract class Filter {
    protected PipedReader piped_reader;
    protected PipedWriter piped_writer;

	public Filter() {
			 piped_reader = new PipedReader();
			 piped_writer = new PipedWriter();
	}

   public int read(){
	     int character =0;
	     try{
	           character = piped_reader.read();
	     }
	     catch(Exception e) {}
	     return character;
    }
    public void write(int c){
		  try{
		       piped_writer.write(c);
		  }
		  catch(Exception e) {}
    }
    public PipedReader getReader(){
		  return piped_reader;
	}
	public PipedWriter getWriter(){
		  return piped_writer;
	}

    abstract public int work(int c);
}