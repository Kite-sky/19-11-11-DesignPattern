import java.util.ArrayList;
import java.util.Iterator;

// This is the composite class in the composite
// design pattern
public class Composite extends WorldOrganization{

        private ArrayList<WorldOrganization> countryList;
		private String saying ="";

		public Composite(){
			countryList = new ArrayList<WorldOrganization>();
	    }
		public void add(WorldOrganization country){
	        if(country != null)
			countryList.add(country);
	    }
	    public void remove(WorldOrganization country){
		    if(country != null)
			    countryList.remove(country);
	    }
		public Iterator<WorldOrganization>  elements(){
		    return countryList.iterator();
	    }
	    public String say(){
			int len =countryList.size();
			for (int i=0; i < len; i++){
				WorldOrganization ctry = countryList.get(i);
				saying = saying + ctry.say()+"\n";
	        }
	        return saying;
		}

		public int getSize(){
		    return countryList.size();
	    }
}