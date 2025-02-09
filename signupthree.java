import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signupthree extends JFrame implements ActionListener {

    // Declare radio buttons and checkboxes as public instance variables
    public JRadioButton savingAccount, currentAccount, fixedDeposit, recurringDeposit;
    public JCheckBox atmCard, mobileBanking, chequeBook, internetBanking, emailAlerts, eStatement;
    public JButton submitButton, cancelButton;
    String formno;

    // Constructor to initialize the form
    public signupthree(String formno) {
        this.formno=formno;
        setTitle("SIGN UP");
        setLayout(null);

        // HEADING
        JLabel form = new JLabel("Page 3: Account Details");
        form.setFont(new Font("Osward", Font.BOLD, 30));
        form.setBounds(130, 10, 600, 40);
        add(form);

        // Account Type Label and Radio Buttons
        JLabel accountTypeLabel = new JLabel("Account Type:");
        accountTypeLabel.setFont(new Font("Osward", Font.BOLD, 20));
        accountTypeLabel.setBounds(20, 80, 200, 25);
        add(accountTypeLabel);

        savingAccount = new JRadioButton("Saving Account");
        savingAccount.setFont(new Font("Osward", Font.BOLD, 18));
        savingAccount.setBounds(20, 115, 180, 25);
        savingAccount.setBackground(Color.WHITE);
        add(savingAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Osward", Font.BOLD, 18));
        currentAccount.setBounds(20, 145, 180, 25);
        currentAccount.setBackground(Color.WHITE);
        add(currentAccount);

        fixedDeposit = new JRadioButton("Fixed Deposit Account");
        fixedDeposit.setFont(new Font("Osward", Font.BOLD, 18));
        fixedDeposit.setBounds(200, 115, 300, 25);
        fixedDeposit.setBackground(Color.WHITE);
        add(fixedDeposit);

        recurringDeposit = new JRadioButton("Recurring Deposit Account");
        recurringDeposit.setFont(new Font("Osward", Font.BOLD, 18));
        recurringDeposit.setBounds(200, 145, 300, 25);
        recurringDeposit.setBackground(Color.WHITE);
        add(recurringDeposit);

        ButtonGroup accountTypeGroup = new ButtonGroup();
        accountTypeGroup.add(savingAccount);
        accountTypeGroup.add(currentAccount);
        accountTypeGroup.add(fixedDeposit);
        accountTypeGroup.add(recurringDeposit);

        // Card Number
        JLabel cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setFont(new Font("Osward", Font.BOLD, 20));
        cardNumberLabel.setBounds(20, 190, 200, 25);
        add(cardNumberLabel);

        JLabel cardNumberField = new JLabel("XXXX-XXXX-XXXX-4184");
        cardNumberField.setFont(new Font("Rainway", Font.BOLD,15));
        cardNumberField.setBounds(200, 190, 250, 30);
        add(cardNumberField);
        
        JLabel NumberField = new JLabel("Your 16 Digit Card Number");
        NumberField.setFont(new Font("Rainway", Font.BOLD, 15));
        NumberField.setBounds(200, 210, 400, 30);
        add(NumberField);


        // PIN
        JLabel pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Osward", Font.BOLD, 20));
        pinLabel.setBounds(20, 265, 200, 25);
        add(pinLabel);

        JLabel pinField = new JLabel("XXXX");
        pinField.setFont(new Font("Rainway", Font.BOLD, 15));
        pinField.setBounds(200, 255, 100, 30);
        add(pinField);

        JLabel pin = new JLabel("This is your 4 digit Pin Number");
        pin.setFont(new Font("Rainway", Font.BOLD, 15));
        pin.setBounds(200, 275, 400, 30);
        add(pin);
        // Services Required Label and Checkboxes
        JLabel servicesLabel = new JLabel("Services Required:");
        servicesLabel.setFont(new Font("Osward", Font.BOLD, 20));
        servicesLabel.setBounds(20, 340, 200, 25);
        add(servicesLabel);

        atmCard = new JCheckBox("ATM CARD");
        atmCard.setFont(new Font("Osward", Font.BOLD, 18));
        atmCard.setBounds(20, 370, 150, 25);
        atmCard.setBackground(Color.WHITE);
        add(atmCard);

        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setFont(new Font("Osward", Font.BOLD, 18));
        mobileBanking.setBounds(20, 390, 180, 25);
        mobileBanking.setBackground(Color.WHITE);
        add(mobileBanking);

        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setFont(new Font("Osward", Font.BOLD, 18));
        chequeBook.setBounds(20, 410, 150, 25);
        chequeBook.setBackground(Color.WHITE);
        add(chequeBook);

        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setFont(new Font("Osward", Font.BOLD, 18));
        internetBanking.setBounds(200, 370, 180, 25);
        internetBanking.setBackground(Color.WHITE);
        add(internetBanking);

        emailAlerts = new JCheckBox("EMAIL & SMS Alerts");
        emailAlerts.setFont(new Font("Osward", Font.BOLD, 18));
        emailAlerts.setBounds(200, 390, 300, 25);
        emailAlerts.setBackground(Color.WHITE);
        add(emailAlerts);

        eStatement = new JCheckBox("E-Statement");
        eStatement.setFont(new Font("Osward", Font.BOLD, 18));
        eStatement.setBounds(200, 410, 150, 25);
        eStatement.setBackground(Color.WHITE);
        add(eStatement);

        // Submit and Cancel Buttons
        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 500, 100, 30);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.white);
        submitButton.setFont(new Font("Railway", Font.BOLD, 14));
        submitButton.addActionListener(this);
        add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(250, 500, 100, 30);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.white);
        cancelButton.setFont(new Font("Railway", Font.BOLD, 14));
        cancelButton.addActionListener(this);
        add(cancelButton);

        // Set background and frame settings
        getContentPane().setBackground(Color.WHITE);
        setSize(650, 800);
        setLocation(350, 10);
        setUndecorated(true);
        setVisible(true);
    }

    // ActionListener for the Submit and Cancel Buttons
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submitButton) {
            // Retrieve data from form fields
            String accountType = "";
            if (savingAccount.isSelected()) accountType = "Saving Account";
            else if (currentAccount.isSelected()) accountType = "Current Account";
            else if (fixedDeposit.isSelected()) accountType = "Fixed Deposit Account";
            else if (recurringDeposit.isSelected()) accountType = "Recurring Deposit Account";

            Random random=new Random();
            String cardNumber = ""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);
            String pin =""+ Math.abs((random.nextLong()%9000L)+1000L);
            String facality="";
            if (atmCard.isSelected()){
                facality=facality +"ATM Card";
            }else if(mobileBanking.isSelected()){
                facality=facality+"Mobile Banking";
            }else if(chequeBook.isSelected()){
                facality=facality+"Cheque Book";
            }else if(internetBanking.isSelected()){
                facality=facality+"Internet Banking";
            }else if(emailAlerts.isSelected()){
                facality=facality+"Email Alerts";
            }else if(eStatement.isSelected()){
                facality=facality+"EStatement";
            }

            try {
                conn c = new conn();

                String query1 = "INSERT INTO signupthree VALUES ('"+formno+"','" + accountType + "', '" + cardNumber + "', '" + pin + "', '" + facality + "')";
                String query3 = "INSERT INTO login VALUES ('"+formno+"','" + cardNumber + "', '" + pin + "')";
           
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "Form Submitted Successfully!"+" Card Number: "+ cardNumber+ " Pin Number: "+pin);
                setVisible(false);
                new deposit(pin).setVisible(true);
        
            } catch (Exception e) {
                System.out.println(e);
                }
            
        }else if(ae.getSource()==cancelButton){
            setVisible(false);
            new login().setVisible(true);
        }
}

    // Main method to run the form
    public static void main(String[] args) {
        new signupthree("");
    }
}
