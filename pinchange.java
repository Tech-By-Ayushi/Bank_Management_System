import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class pinchange extends JFrame implements ActionListener{
    String pinnumber;
    JPasswordField newpinField,repinfield;
    JButton change,back;

    pinchange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        setTitle("ATM");

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("ATMSTRUCTURE.jpg"));
        Image i2= i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text= new JLabel("Change Your Pin");
        text.setBounds(250,280,500,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        JLabel pintext= new JLabel("New Pin: ");
        pintext.setBounds(165,320,180,25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        image.add(pintext);

        newpinField=new JPasswordField();
        newpinField.setFont(new Font("Rainway",Font.BOLD,25));
        newpinField.setBounds(330,320,180,25);
        image.add(newpinField);

        JLabel retext= new JLabel("Re-Enter New Pin: ");
        retext.setBounds(165,360,180,25);
        retext.setForeground(Color.WHITE);
        retext.setFont(new Font("System",Font.BOLD,16));
        image.add(retext);

        repinfield=new JPasswordField();
        repinfield.setFont(new Font("Rainway",Font.BOLD,25));
        repinfield.setBounds(330,360,180,25);
        image.add(repinfield);

        change=new JButton("Change");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== change){
            try {
            String npin=newpinField.getText();
            String rpin= repinfield.getText();
            
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "entered Pin Doesnt Match");
                    return;
                }

                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter Pin");
                    return;
                }

                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter Pin");
                    return;
                }

                conn c= new conn();
                String query1= "update bank set pin = '"+rpin+"' where pin= '"+pinnumber+"'";
                String query2= "update login set Pin_Number = '"+rpin+"' where Pin_Number= '"+pinnumber+"'";
                String query3= "update signupthree set Pin_Number = '"+rpin+"' where Pin_Number= '"+pinnumber+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null, "Changed Successfully");
                
                setVisible(false);
                new transition(rpin).setVisible(true);

        } catch (Exception e) {
            System.out.println(e);
        }
    }else if(ae.getSource()==back) {
        setVisible(false);
        new transition(pinnumber).setVisible(true);
    }
}
    public static void main(String[] args) {
        new pinchange("");
    }
}
