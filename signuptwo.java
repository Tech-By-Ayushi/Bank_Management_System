import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class signuptwo extends JFrame implements ActionListener{
    JTextField  panTextField, adharTextField, existTextField;
    JRadioButton syes,sno,eyes,eno;
    JButton next;
    JComboBox<String> educationComboBox, occupationComboBox, religionComboBox, categoryComboBox,incomeComboBox;
    String formno;
    
    signuptwo(String formno) {
        this.formno= formno;
        setTitle("SIGN UP");
        setLayout(null);

        // ADDITIONAL DETAILS
        JLabel additionaldetails = new JLabel("PAGE 2: ADDITIONAL DETAILS");
        additionaldetails.setFont(new Font("Osward", Font.BOLD, 20));
        additionaldetails.setBounds(200, 50, 600, 40);
        add(additionaldetails);

        // Religion
        JLabel religion = new JLabel("RELIGION:");
        religion.setFont(new Font("Osward", Font.BOLD, 20));
        religion.setBounds(100, 140, 150, 30);
        add(religion);

        String[] rel={"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionComboBox=new JComboBox<>(rel);
        religionComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        religionComboBox.setBounds(300, 140, 300, 30);
        add(religionComboBox);

        // Category
        JLabel category = new JLabel("CATEGORY:");
        category.setFont(new Font("Osward", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String[] cat={"General","SC","ST","OBC","EWS","PD"};
        categoryComboBox = new JComboBox<>(cat);
        categoryComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        categoryComboBox.setBounds(300, 190, 300, 30);
        add(categoryComboBox);

        // INCOME
        JLabel income = new JLabel("INCOME:");
        income.setFont(new Font("Osward", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String [] inc={"NULL","< 1,50,000","< 2,50,000","< 5,00,000", "Upto 10,00,000"};
        incomeComboBox = new JComboBox<>(inc);
        incomeComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        incomeComboBox.setBounds(300, 240, 300, 30);
        add(incomeComboBox);

        // EDUCATIONAL
        JLabel education = new JLabel("EDUCATIONAL");
        education.setFont(new Font("Osward", Font.BOLD, 20));
        education.setBounds(100, 290, 200, 30);
        add(education);

        JLabel qualification = new JLabel("QUALIFICATION:");
        qualification.setFont(new Font("Osward", Font.BOLD, 20));
        qualification.setBounds(100, 310, 200, 30);
        add(qualification);

        String[] educationOptions = {"Non Graduate", "Graduated", "Post Graduated","Doctrate","OTHERS"};
        educationComboBox = new JComboBox<>(educationOptions);
        educationComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        educationComboBox.setBounds(300, 300, 300, 30);
        add(educationComboBox);

        // OCCUPATION
        JLabel occupation = new JLabel("OCCUPATION:");
        occupation.setFont(new Font("Osward", Font.BOLD, 20));
        occupation.setBounds(100, 350, 200, 30);
        add(occupation);

        String[] occupationOptions = {"Salried", "Self Employed", "Bussiness", "Student","Retired","Others"};
        occupationComboBox = new JComboBox<>(occupationOptions);
        occupationComboBox.setFont(new Font("Rainway", Font.BOLD, 20));
        occupationComboBox.setBounds(300, 350, 300, 30);
        add(occupationComboBox);

        // Pan Number
        JLabel pan = new JLabel("PAN NUMBER:");
        pan.setFont(new Font("Osward", Font.BOLD, 20));
        pan.setBounds(100, 400, 200, 30);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        panTextField.setBounds(300, 400, 300, 30);
        add(panTextField);

        // ADHAR NUMBER
        JLabel adhar = new JLabel("ADHAR NUMBER:");
        adhar.setFont(new Font("Osward", Font.BOLD, 20));
        adhar.setBounds(100, 450, 200, 30);
        add(adhar);

        adharTextField = new JTextField();
        adharTextField.setFont(new Font("Rainway", Font.BOLD, 20));
        adharTextField.setBounds(300, 450, 300, 30);
        add(adharTextField);

        // SENIOR CITIZEN
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Osward", Font.BOLD, 20));
        senior.setBounds(100, 500, 200, 30);
        add(senior);

        syes = new JRadioButton("YES");
        syes.setBackground(Color.WHITE);
        syes.setBounds(300, 500, 100, 30);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBackground(Color.WHITE);
        sno.setBounds(450, 500, 100, 30);
        add(sno);

        ButtonGroup seniorgroup =new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);


        // EXISTING ACCOUNT
        JLabel exist = new JLabel("Existing Account:");
        exist.setFont(new Font("Osward", Font.BOLD, 20));
        exist.setBounds(100, 550, 200, 30);
        add(exist);

        eyes = new JRadioButton("YES");
        eyes.setBackground(Color.WHITE);
        eyes.setBounds(300, 550, 100, 30);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBackground(Color.WHITE);
        eno.setBounds(450, 550, 100, 30);
        add(eno);

        ButtonGroup existgroup =new ButtonGroup();
        existgroup.add(eyes);
        existgroup.add(eno);

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
        String religion= (String) religionComboBox.getSelectedItem();
        String category= (String) categoryComboBox.getSelectedItem(); 
        String income= (String) incomeComboBox.getSelectedItem();
        String education = (String) educationComboBox.getSelectedItem();
        String occupationStatus = (String) occupationComboBox.getSelectedItem();
        String pan= panTextField.getText();
        String adhar= adharTextField.getText();
        String senior= null;
        if (syes.isSelected()){
            senior="Yes";
        }else if (sno.isSelected()){
            senior="No";
        }
        String exist= null;
        if (eyes.isSelected()){
            senior="Yes";
        }else if (eno.isSelected()){
            senior="No";
        }

        try {
            if (religion.equals("")){
                JOptionPane.showMessageDialog(null, "NAME IS NULL");
            }else{
                conn c= new conn();
                String query2= "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"', '"+education+"','"+occupationStatus+"','"+pan+"','"+adhar+"','"+senior+"','"+exist+"')";
                c.s.executeUpdate(query2);
                setVisible(false);
                new signupthree(formno).setVisible(true);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        new signuptwo("");
    }
}
