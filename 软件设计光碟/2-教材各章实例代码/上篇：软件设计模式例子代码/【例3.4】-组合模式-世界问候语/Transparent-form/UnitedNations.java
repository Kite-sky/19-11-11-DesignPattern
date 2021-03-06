
/*================================*/
/* This is a subclass of the composite class
/*================================*/

public class UnitedNations extends Composite{

    static String DESCRIPTION = "This is the United Nations \n";

    WorldOrganization china = new China();
    WorldOrganization usa = new USA();
    WorldOrganization england = new England();
    WorldOrganization france = new France();
    WorldOrganization germany = new Germany();

    public UnitedNations(){
		 super.add(china);
		 super.add(usa);
		 super.add(england);
		 super.add(france);
	     super.add(germany);
    }

    public String say(){
	    return DESCRIPTION + super.say();
	}
}