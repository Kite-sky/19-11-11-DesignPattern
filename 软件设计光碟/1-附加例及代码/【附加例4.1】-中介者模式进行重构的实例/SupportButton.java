
import java.awt.event.*;
import javax.swing.*;

public class SupportButton extends JButton implements Command
{
    Mediator med;
    SupportButton (ActionListener al, Mediator m) {
       super("Support");
       addActionListener(al);
       med = m;
       med.registerSupport(this);
    }
    public void execute(){
       med.askSupport();
    }
}