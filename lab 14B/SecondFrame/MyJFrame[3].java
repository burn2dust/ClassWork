//Authors
//Bill Vilwock and Nick Kaide

import javax.swing.*;
import java.awt.*;

class MyJFrame extends JFrame {

    // private instance variables
    JButton oneButton;
    
    public static void main (String [] args) {
        MyJFrame mine = new MyJFrame();
        mine.setVisible(true);
    }

    public MyJFrame () {
        setTitle ("This is a \"MyJFrame\" object (V2)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct a button
        oneButton = new JButton("Hi");
        oneButton.setBounds(110,200,80,50);
        contentPane.add(oneButton);
    }
}
