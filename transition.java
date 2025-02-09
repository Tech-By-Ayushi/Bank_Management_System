import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class transition extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    transition(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("ATM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ATMSTRUCTURE.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Please Select Your Transition");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.addActionListener(this);
        deposit.setBounds(170,415,150,30);
        image.add(deposit);

        withdrawl=new JButton("Withdrawl");
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);

        fastcash=new JButton("Fast Cash");
        fastcash.addActionListener(this);
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);

        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.addActionListener(this);
        pinchange.setBounds(170,485,150,30);
        image.add(pinchange);

        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.addActionListener(this);
        balanceenquiry.setBounds(355,485,150,30);
        image.add(balanceenquiry);
        
        exit=new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(355,520,150,30);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            System.exit(0); 
        } else if (ae.getSource()== deposit){
            setVisible(false);
            new deposit(pinnumber).setVisible(true);
        } else if (ae.getSource()==withdrawl){
            setVisible(false);
            new withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash) {
            setVisible(false);
            new fastcash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new balancenquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            new ministatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
     new transition("");   
    }
}
