
import javax.swing.*;

// This is the command interface in the command pattern.
// This interface has some implementer classes.
public interface Command {
        public abstract void execute (JPanel panel);
}
