//Authors
//Bill Vilwock and Nick Kaide
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyJFrame extends JFrame implements ActionListener{

    // private instance variables
    JButton button1;
    JButton button2;
    int button1Count;
    int button2Count;
    
    public static void main (String [] args) {
        MyJFrame mine = new MyJFrame();
        mine.setVisible(true);
    }

    public MyJFrame () {
        setTitle ("This is a \"MyJFrame\" object (V4)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct two buttons
        button1 = new JButton("0");
        button1.setBounds(110,230,80,40);
        button1.addActionListener(this);
        contentPane.add(button1);
        button2 = new JButton("0");
        button2.setBounds(110,300,80,40);
        button2.addActionListener(this);
        contentPane.add(button2);

        // start their counts at 0
        button1Count = 0;
        button2Count = 0;
    }

    public void actionPerformed(ActionEvent event) {
      if(event.getSource()==button1) {
          button1Count++;
          button1.setText(Integer.toString(button1Count));
      }
      if(event.getSource()==button2){
          button2Count++;
          button2.setText(Integer.toString(button2Count));
      }
      
    }
}
