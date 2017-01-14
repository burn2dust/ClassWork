//Authors
//Bill Vilwock and Nick Kaide


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyJFrame extends JFrame implements ActionListener{

    // private instance variables
    JButton button;
    int buttonCount;
    JTextField inputLine;
    JLabel title;
    JMenu menu;
    JMenuItem clearItem;
    JMenuItem exitItem;
    JMenuBar display;
    
    public static void main (String [] args) {
        MyJFrame mine = new MyJFrame();
        mine.setVisible(true);

    }

    public MyJFrame () {

        setTitle ("This is a \"MyJFrame\" object (V5)");
        setSize (300, 500);
        setDefaultCloseOperation( EXIT_ON_CLOSE );

        // get the content pane and set properties
        Container contentPane = getContentPane();
        contentPane.setBackground (Color.blue);
        contentPane.setLayout(null); // so that we can use absolute positioning

        // construct a button, and set the number of click on it to 0
        button = new JButton("0");
        button.setBounds(110,230,80,40);
        button.addActionListener(this);
        contentPane.add(button);
        buttonCount = 0;

        // construct a text field
        inputLine = new JTextField();
        inputLine.setBounds(100,100,100,20);
        inputLine.addActionListener(this);
        contentPane.add(inputLine);
        
        //construct instructions
        title= new JLabel("Enter a number to update the button");
        title.setBounds(50,60,220,20);
        title.setBackground(Color.red);
        contentPane.add(title);
        
        //creates menu
        display= new JMenuBar();
        menu= new JMenu("a menu");
        display.add(menu);
        display.setBounds(0,0,50,20);
        clearItem= new JMenuItem("Clear");
        exitItem= new JMenuItem("Exit");
        menu.add(clearItem);
        menu.add(exitItem);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);
        contentPane.add(display);
       
        
    }

    public void actionPerformed(ActionEvent event) {
      if(event.getSource()==inputLine){  
        String str=inputLine.getText();
        inputLine.setText("");
        buttonCount=Integer.parseInt(str);
      }
      if(event.getSource()==button){
        buttonCount++;
      }
      if(event.getSource()==clearItem){
        buttonCount=0;
      }
      if(event.getSource()==exitItem){
        System.exit(0);
      }
      button.setText(Integer.toString(buttonCount));
      
    }
}
