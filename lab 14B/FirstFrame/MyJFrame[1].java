//Authors
//Bill Vilwock and Nick Kaide

import javax.swing.*;
import java.awt.*;

class MyJFrame extends JFrame {

    public static void main (String [] args) {
        MyJFrame mine = new MyJFrame();
        mine.setVisible(true);
    }

    public MyJFrame () {
        setTitle ("This is a \"MyJFrame\" object");
        setSize (300, 500);

        setDefaultCloseOperation( EXIT_ON_CLOSE );
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
    }
}
