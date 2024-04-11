package adaptorclasses;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Carolina Cretu
 */
public class MainAdaptorClasses extends JPanel {


    public MainAdaptorClasses() {
        // pasam clasa Adaptor in locul interfetei MouseListener
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                System.out.println(me);
            }
        });
    }

    public static void main(String[] args) {

        // facem un frame pe care punem un size, il facem vizibil si ii setam un eveniment de close...
        JFrame frame = new JFrame();
        frame.getContentPane().add(new MainAdaptorClasses());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}
