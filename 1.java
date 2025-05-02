package exp1;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class KeyboardPress extends WindowAdapter implements KeyListener {
    Frame f;
    Label l1, l2;
    TextArea ta;

    KeyboardPress() {
        f = new Frame();
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);
        f.setTitle("Key Press Event");

        init();
        add_components();
        register();
    }

    public void init() {
        l1 = new Label("Key Pressed: ");
        l1.setBounds(50, 50, 200, 30);

        l2 = new Label("Key Released: ");
        l2.setBounds(50, 100, 200, 30);

        ta = new TextArea(10, 30);
        ta.setBounds(50, 150, 300, 200);
    }

    public void add_components() {
        f.add(l1);
        f.add(l2);
        f.add(ta);
    }

    public void keyTyped(KeyEvent e) {
        l2.setText("Key Typed: " + e.getKeyChar());  
    }

    public void keyPressed(KeyEvent e) {
        l2.setText("Key Pressed: " + e.getKeyChar());
    }

    public void keyReleased(KeyEvent e) {
        l2.setText("Key Released: " + e.getKeyChar());
    }

    public void windowClosing(WindowEvent e) {
        f.dispose();
    }

    public void register() {
        f.addWindowListener(this);
        f.addKeyListener(this);
    }

    public static void main(String args[]) {
        new KeyboardPress();
    }
}