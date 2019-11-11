
import javax.swing.*;
//import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public abstract class GUIBuilder{
  protected JPanel bankUI;
  protected Calendar calendar;
  protected String time;

  public abstract void initialize();
  public abstract void addGUIComponents();

  protected void setupCalendar(){
	    calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd.hh:mm");
        time = formatter.format(calendar.getTime());
  }

  public JPanel getBankUI()  {
        return bankUI;
  }
}

