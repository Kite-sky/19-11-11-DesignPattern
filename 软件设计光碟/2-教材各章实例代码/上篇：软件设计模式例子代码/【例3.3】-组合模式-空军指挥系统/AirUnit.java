

import java.util.ArrayList;
import java.util.Iterator;

/*=====================================*/
/* This is the object structure  class */
/* in the class diagram of the visitor */
/* design pattern                      */
/*=====================================*/

public class AirUnit implements Airforce{

	private ArrayList<Airforce> parts;
	private String answer="";
	private String FEATURES = "Air Formation of Airforce. ";

	public AirUnit(){
		parts = new ArrayList<Airforce>();
    }

	public void attach(Airforce equip){
        if(equip != null)
		parts.add(equip);
    }

    public void detach(Airforce equip){
	    if(equip != null)
		    parts.remove(equip);
    }

	public Iterator<Airforce>  elements(){
	    return parts.iterator();
    }
	public String fight(){
		int len =parts.size();
		for (int i=0; i < len; i++){
			Airforce part = parts.get(i);
			answer = answer + part.fight()+"\n";
        }
        return answer;
	}

	public int getSize(){
	    return parts.size();
    }

    public String getDescription(){
		    return FEATURES;
	}
}