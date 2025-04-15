
package atm_simulator_system;

import javax.swing.*;                       //swing package comes from extended packages hence javax  .* imports all packages being used here
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{         //JFrame is a class of swing,we are importing it from swing package

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login(){         //we9* want that when object is created and constructor is instantiated length and frame is decided
       setTitle("AUTOMATED TELLER MACHINE");   //sets a name of frame
       
       setLayout(null);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
       Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel label = new JLabel (i3);
       label.setBounds(70, 10, 100, 100);
       add(label);
       
       
       JLabel text = new JLabel ("Welcome to ATM");
       text.setFont(new Font("Osward", Font.BOLD, 38));
       text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel ("Card No:");
       cardno.setFont(new Font("Raleway", Font.BOLD, 28));
       cardno.setBounds(120, 150, 150, 30);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds (300, 150 , 230 , 30);
        cardTextField.setFont (new Font ("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        
        
        JLabel pin = new JLabel ("PIN:");
       pin.setFont(new Font("Osward", Font.BOLD, 28));
       pin.setBounds(120, 220, 250, 30);
        add(pin);
        
          pinTextField = new  JPasswordField();
        pinTextField.setBounds (300, 220 , 230 , 30);
         pinTextField.setFont (new Font ("Arial", Font.BOLD, 14));
        add(pinTextField);
        
        login = new JButton ("SIGN IN");
        login.setBounds (300, 300 , 100 , 30);
        login.setBackground(Color.BLACK);
        login.setForeground (Color.white);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton ("CLEAR");
        clear.setBounds (430, 300 , 100 , 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground (Color.white);
         clear.addActionListener(this);
        add(clear);
        
         
        signup = new JButton ("SIGNUP");
        signup.setBounds (300, 350 , 230 , 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground (Color.white);
         signup.addActionListener(this);
        add(signup);
        
        
       getContentPane().setBackground(Color.white);
       
        setSize(800,480);  //decides size for frame
       setVisible(true);  //by default frame is invisible to user,this is a function for seeing it
       setLocation(350,200);  //function to change default location(up left) to center
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear){
            cardTextField.setText("");
             pinTextField.setText("");
        }
        else if (ae.getSource() == login){
            
        }
        else if (ae.getSource() == signup){
            
        }
        
    }
    public static void main(String args[]){
        new Login();   //object for class Login                       
        
    }
}
