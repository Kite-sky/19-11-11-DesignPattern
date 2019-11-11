
import java.awt.event.*;
import javax.swing.*;

public class ReportButton extends JButton implements Command
{
    Mediator med;
    ReportButton (ActionListener al, Mediator m) {
       super("Report");
       addActionListener(al);
       med = m;
       med.registerReport(this);
    }
    public void execute() {
       med.report();
    }
}