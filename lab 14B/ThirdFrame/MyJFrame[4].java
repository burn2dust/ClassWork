//Authors
//Bill Vilwock and Nick Kaide

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyJFrame extends JFrame implements ActionListener{

    // private instance variables
    JButton button;
    int buttonCount;
    
    public static void main (String [] args) {
        MyJFrame mine = new MyJFrame();
        mine.setVisible(true);
    }

    public MyJFrame () {
        setTitle ("This is a \"MyJFrame\" object (V3)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        
        buttonCount=0;//starts count at 0
        
        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct a button and make this MyJFrame listen for
        // and  handle button events
        button = new JButton(new Integer(0).toString());
        button.setBounds(110,230,80,40);
        button.addActionListener(this);
        contentPane.add(button);
    }

    public void actionPerformed(ActionEvent event) {
        // add code to increment the buttonCount and display it on the button
      buttonCount++;
      button.setText(Integer.toString(buttonCount));

    }
}
