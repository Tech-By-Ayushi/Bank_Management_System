import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



public class signupONE extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField, fnameTextField, dobTextField,emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField; 
    JButton next;
    JComboBox<String> genderComboBox, maritalComboBox;
    

    
    signupONE() {
        setTitle("SIGN UP");
        setLayout(null);

        // HEADING
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Osward", Font.BOLD, 30));
        formno.setBounds(130, 10, 600, 40);
        add(formno);

        // PERSONAL DETAILS
        JLabel personaldetails = new JLabel("PAGE 1: PERSONAL DETAILS");
        personaldetails.setFont(new Font("Osward", Font.BOLD, 20));
        personaldetails.setBounds(200, 50, 600, 40);
        add(personaldetails);

        // Name
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Osward", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        nameTextField.setBounds(300, 140, 300, 30);
        add(nameTextField);

        // Father's Name
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Osward", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        fnameTextField.setBounds(300, 190, 300, 30);
        add(fnameTextField);

        // Date of Birth
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Osward", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dobTextField = new JTextField();
        dobTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        dobTextField.setBounds(300, 240, 300, 30);
        add(dobTextField);

        // Gender
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Osward", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        String[] genderOptions = {"Male", "Female", "Other"};
        genderComboBox = new JComboBox<>(genderOptions);
        genderComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        genderComboBox.setBounds(300, 290, 300, 30);
        add(genderComboBox);

        // Email Address
        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Osward", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        emailTextField.setBounds(300, 340, 300, 30);
        add(emailTextField);

        // Marital Status
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Osward", Font.BOLD, 20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);

        String[] maritalOptions = {"Single", "Married", "Divorced", "Widowed"};
        maritalComboBox = new JComboBox<>(maritalOptions);
        maritalComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        maritalComboBox.setBounds(300, 390, 300, 30);
        add(maritalComboBox);

        // Address
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Osward", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        addressTextField.setBounds(300, 440, 300, 30);
        add(addressTextField);

        // City
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Osward", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        cityTextField.setBounds(300, 490, 300, 30);
        add(cityTextField);

        // State
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Osward", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        stateTextField.setBounds(300, 540, 300, 30);
        add(stateTextField);

        // Pin Code
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Osward", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        pincodeTextField.setBounds(300, 590, 300, 30);
        add(pincodeTextField);

        //button
        next = new JButton("Next");
        next.setBounds(540, 660, 80, 30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Railway", Font.BOLD, 14));
        next.addActionListener(this);
        add(next);

        // BACKGROUND/FRAME
        getContentPane().setBackground(Color.WHITE);
        setSize(650, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String formno =""+ random;
        String name= nameTextField.getText();
        String fname= fnameTextField.getText(); 
        String dob= dobTextField.getText();
        String gender = (String) genderComboBox.getSelectedItem();
        String email= emailTextField.getText();
        String maritalStatus = (String) maritalComboBox.getSelectedItem();
        String address= addressTextField.getText();
        String city= cityTextField.getText();
        String state= stateTextField.getText();
        String pin= pincodeTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "NAME IS NULL");
            }else{
                conn c= new conn();
                String query= "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"', '"+gender+"','"+email+"','"+maritalStatus+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signuptwo(formno).setVisible(true);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new signupONE();
    }
}
