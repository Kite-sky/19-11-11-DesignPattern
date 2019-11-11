
import java.awt.event.*;
import javax.swing.*;

public class UserGUI extends JFrame implements ActionListener
{
    private Mediator med;
    private SearchButton srchBtn;
	private TraceButton traceBtn;
	private ReportButton reportBtn;
	private SupportButton supportBtn;
    private FireButton fireBtn;

    UserGUI() {
	   med = new Mediator();
	   srchBtn = new SearchButton(this,med);
	   traceBtn = new TraceButton(this,med);
	   reportBtn = new ReportButton(this,med);
	   supportBtn = new SupportButton(this,med);
	   fireBtn = new FireButton(this,med);

       JPanel p = new JPanel();
       p.add(srchBtn);
	   p.add(traceBtn );
	   p.add(reportBtn);
	   p.add(supportBtn);
       p.add(fireBtn);

       getContentPane().add(new LblDisplay(med), "North");
       getContentPane().add(p,"South");
       setSize(400,200);
       setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
       Command comd = (Command)ae.getSource();
       comd.execute();
    }

	public static void main(String[] args) {
	   new UserGUI();
    }
}
