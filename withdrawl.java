import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class withdrawl extends JFrame implements ActionListener{
    JTextField ammoutField;
    JButton withdrawl, back;
    String pinnumber;

    withdrawl(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ATMSTRUCTURE.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Please Enter Amount to withdraw: ");
        text.setBounds(170,300,400,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        ammoutField = new JTextField();
        ammoutField.setFont(new Font("Raleway",Font.BOLD,22));
        ammoutField.setBounds(170,335,320,25);

        image.add(ammoutField);

        withdrawl=new JButton("Withdraw");
        withdrawl.setBounds(355, 485, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        back=new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){
            String number= ammoutField.getText();
            Date  date = new Date();
            if (number.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter the Amount");
            }else {
                try {
                    conn c= new conn();
                String query= "insert into bank values ('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+number+" withdraw Successfully");
                setVisible(false);
                new transition(pinnumber).setVisible(true);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
            }
        }else if (ae.getSource()== back){
            setVisible(false);
            new transition(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new withdrawl("");
    }
}
