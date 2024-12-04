import java.awt.Color;
import javax.swing.*;

public abstract class Cell extends JButton {
    public abstract void setColorBack(Color color);

    public abstract void setColorFront(Color color);
}