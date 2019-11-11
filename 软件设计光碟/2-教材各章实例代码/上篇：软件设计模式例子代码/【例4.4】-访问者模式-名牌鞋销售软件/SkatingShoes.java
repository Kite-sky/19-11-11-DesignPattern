

public abstract class SkatingShoes extends SportShoes{

	public abstract double getPrice();
    public abstract String getDescription();
	public abstract void accept(Visitor v);

}
