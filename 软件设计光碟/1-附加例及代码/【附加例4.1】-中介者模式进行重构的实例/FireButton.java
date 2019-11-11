
import java.awt.event.*;
import javax.swing.*;

public class FireButton extends JButton implements Command
{
    Mediator med;
    FireButton(ActionListener al, Mediator m) {
       super("Fire");
       addActionListener(al);
       med = m;
       med.registerFire(this);
    }

    public void execute(){
       med.fire();
    }
}