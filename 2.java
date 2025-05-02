package exp2;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class MousePress extends WindowAdapter implements MouseListener {
    Frame f;
    Label l1, l2;
    TextArea ta;

    MousePress() {
        f = new Frame();
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("Mouse Press Event");

        init();
        add_components();
        register();
    }

    public void init() {
        l1 = new Label("Mouse Pressed: ");
        l1.setBounds(50, 50, 200, 30);

        l2 = new Label("Mouse Released: ");
        l2.setBounds(50, 100, 200, 30);

        ta = new TextArea(10, 30);
        ta.setBounds(50, 150, 300, 200);
    }

    public void add_components() {
        f.add(l1);
        f.add(l2);
        f.add(ta);
    }

    public void mouseClicked(MouseEvent e) {
        l2.setText("Mouse Clicked");
        ta.setBackground(Color.YELLOW);
    }

    public void mousePressed(MouseEvent e) {
        l2.setText("Mouse Pressed");
        ta.setBackground(Color.GREEN);
    }

    public void mouseReleased(MouseEvent e) {
        l2.setText("Mouse Released");
        ta.setBackground(Color.RED);
    }

    public void mouseEntered(MouseEvent e) {
        l2.setText("Mouse Entered");
        ta.setBackground(Color.BLUE);
    }

    public void mouseExited(MouseEvent e) {
        l2.setText("Mouse Exited");
        ta.setBackground(Color.WHITE);
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void register() {
        f.addWindowListener(this);
        f.addMouseListener(this);
    }

    public static void main(String[] args) {
        new MousePress();
    }
}