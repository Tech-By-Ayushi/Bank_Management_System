import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;
public class fastcash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
    String pinnumber;
    fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("ATM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ATMSTRUCTURE.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Please Select Withdrawl Amount");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Rs 100");
        deposit.addActionListener(this);
        deposit.setBounds(170,415,150,30);
        image.add(deposit);

        withdrawl=new JButton("Rs 500");
        withdrawl.addActionListener(this);
        withdrawl.setBounds(355,415,150,30);
        image.add(withdrawl);

        fastcash=new JButton("Rs 1000");
        fastcash.addActionListener(this);
        fastcash.setBounds(170,450,150,30);
        image.add(fastcash);

        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(355,450,150,30);
        image.add(ministatement);

        pinchange=new JButton("Rs 5000");
        pinchange.addActionListener(this);
        pinchange.setBounds(170,485,150,30);
        image.add(pinchange);

        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.addActionListener(this);
        balanceenquiry.setBounds(355,485,150,30);
        image.add(balanceenquiry);
        
        exit=new JButton("Back");
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
            setVisible(false);
            new transition(pinnumber).setVisible(true); 
        } else {
                String amount=((JButton)ae.getSource()).getText().substring(3);
                conn c= new conn();
                try {
                    ResultSet rs= c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                    int balance=0;
                    while(rs.next()){
                        if (rs.getString("type").equals("Deposit")){
                            balance +=Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    Date date= new Date();
                    String query ="insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+ " debited successfully");
                    setVisible(false);
                    new transition(pinnumber).setVisible(true);

                } catch (Exception e) {
                    System.out.println(e);
                }
                setVisible(false);
                new transition(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
     new fastcash("");   
    }
}
