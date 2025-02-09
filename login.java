import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener{
    JButton login,signup, clear;
    JTextField cardteTextField;
    JPasswordField pintTextField;

    login(){
        setTitle("ATM");
        setLayout(null);

        // IMAGE INSERTION

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ATM.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(60,10,100,100);
        add(label);

        // TEXT (WELCOME) INSERTION
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD,26));
        text.setBounds(180,10,400,100);
        add(text);

        // TEXT (CARD) INSERTION
        JLabel cardno= new JLabel("CARD NO:");
        cardno.setFont(new Font("Rainway", Font.BOLD,20));
        cardno.setBounds(100,150,150,30);
        add(cardno);

        // BOX FOR CARD N0
        cardteTextField= new JTextField();
        cardteTextField.setBounds(220, 150, 200, 30);
        cardteTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardteTextField);

        // TEXT (PIN) INSERTION
        JLabel pin  = new JLabel("PIN:");
        pin.setFont(new Font("Rainway", Font.BOLD,20));
        pin.setBounds(100,210,200,30);
        add(pin);

        // BOX FOR PIN
        pintTextField= new JPasswordField();
        pintTextField.setBounds(220, 210, 200, 30);
        pintTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pintTextField);

        //BUTTON FOR LOGIN
        login= new JButton("SIGN IN");
        login.setBounds(150, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        //BUTTON FOR CLEAR
        clear= new JButton("CLEAR");
        clear.setBounds(300, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        //BUTTON FOR SIGNUP
        signup= new JButton("SIGN UP");
        signup.setBounds(150, 345, 250, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // BACGROUND/FRAME
        getContentPane().setBackground(Color.WHITE);
        setSize(500, 500);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardteTextField.setText("");
            pintTextField.setText("");
        }else if(ae.getSource() == login){
            conn c= new conn();
            String cardnumber= cardteTextField.getText();
            String pinnumber= pintTextField.getText();
            String query = "select * from login where Card_Number= '"+cardnumber+"' and Pin_Number='"+pinnumber+"'";
            try {
                ResultSet rs =c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new transition(pinnumber).setVisible(true);
                }else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource() == signup){
            setVisible(false);
            new signupONE().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new login();
    }
}