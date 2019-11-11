

public class GUIDirector {
  private GUIBuilder builder;

  public GUIDirector(GUIBuilder bldr)  {
    builder = bldr;
  }
  public void build() {
	builder.initialize();
    builder.addGUIComponents();
  }
}

