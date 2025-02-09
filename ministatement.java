import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;

public class ministatement extends JFrame{
    String pinnumber;
    ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        setTitle("Mini Statement");
        setLayout(null);

        JLabel text= new JLabel();
        add(text);

        JLabel bank= new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card= new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        try {
            conn c= new conn();
            ResultSet rs= c.s.executeQuery("select * from login where Pin_Number= '"+pinnumber+"'");
            while (rs.next()){
                card.setText("Card Number: "+rs.getString("Card_Number").substring(0, 4)+"XXXXXXXX"+ rs.getString("Card_Number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            conn c=new conn();
            int bal=0;
            ResultSet rs= c.s.executeQuery("select * from bank where pin= '"+pinnumber+"'");
            while(rs.next()) {
                text.setText(text.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br></html>");
                if (rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            
            }
            balance.setText("Your Current Account Balance is Rs: "+bal);
        } catch (Exception e) {
            System.out.println(e);
        }
        text.setBounds(20,140,400,200);

       

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static void main(String[] args) {
        new ministatement("");
    }
}
