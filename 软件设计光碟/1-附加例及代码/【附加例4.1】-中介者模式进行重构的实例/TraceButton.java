
import java.awt.event.*;
import javax.swing.*;

public class TraceButton extends JButton implements Command
{
    Mediator med;
    TraceButton (ActionListener al, Mediator m) {
       super("Trace");
       addActionListener(al);
       med = m;
       med.registerTrace(this);
    }
    public void execute() {
       med.trace();
    }
}