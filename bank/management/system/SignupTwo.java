package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener{

    JLabel additionalDetails,religion,category,income,educational,qualification,occupation,pan,adhar,senior,existing;
    JTextField panTextField,adharTextField;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    String formno;

    SignupTwo(String formno){
        this.formno=formno;

        setTitle("NEW ACCOUNT APPLICATION FORM: PAGE 2");

        setLayout(null);

        additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);

        String valReligion[]={"Hindu", "Muslim", "Sikh","Christian"};
        religionBox=new JComboBox(valReligion);
        religionBox.setBounds(300, 140, 400, 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);

        category=new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100, 190, 200, 30);
        add(category);

        String valCategory[]={"General", "OBC", "SC","ST"};
        categoryBox=new JComboBox(valCategory);
        categoryBox.setBounds(300, 190, 400, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);

        income=new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100, 240, 200, 30);
        add(income);

        String valIncome[]={"Null", "< 1,50,000", "< 2,50,000","< 5,00,000", "Upto 10,00,000"};
        incomeBox=new JComboBox(valIncome);
        incomeBox.setBounds(300, 240, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);

        
        educational=new JLabel("Educational:");
        educational.setFont(new Font("Raleway", Font.BOLD, 20));
        educational.setBounds(100, 290, 200, 30);
        add(educational);

        qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100, 315, 200, 30);
        add(qualification);

        String valEducation[]={"Non-Graduate", "Graduate", "Post Graduate","Doctrate"};
        educationBox=new JComboBox(valEducation);
        educationBox.setBounds(300, 315, 400, 30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        
        occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);

        String valOccupation[]={"Salaried", "Self-Employed", "Bussiness","Student","Retired"};
        occupationBox=new JComboBox(valOccupation);
        occupationBox.setBounds(300, 390, 400, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);

        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);

        adhar=new JLabel("Adhar Number:");
        adhar.setFont(new Font("Raleway", Font.BOLD, 20));
        adhar.setBounds(100, 490, 200, 30);
        add(adhar);

        adharTextField=new JTextField();
        adharTextField.setFont(new Font("Raleway",Font.BOLD, 14));
        adharTextField.setBounds(300, 490, 400, 30);
        add(adharTextField);

        senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup=new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

        existing=new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup=new ButtonGroup();
        existingGroup.add(syes);
        existingGroup.add(sno);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 800);
        setVisible(true);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent ae){
        
        String religion=(String)religionBox.getSelectedItem();
        String category=(String)categoryBox.getSelectedItem();
        String income=(String)incomeBox.getSelectedItem();
        String education=(String)educationBox.getSelectedItem();
        String occupation=(String)occupationBox.getSelectedItem();
        String senior=null;
        if(syes.isSelected()){
            senior="Yes";
        }
        else if(sno.isSelected()){
            senior="No";
        }
        String pan=panTextField.getText();
        String adhar=adharTextField.getText();
        String existing=null;
        if(eyes.isSelected()){
            existing="Yes";
        }
        else if(eno.isSelected()){
            existing="No";
        }
        try{
            if(religion.equals("")){
                JOptionPane.showMessageDialog(null, "Religion is Required");
            }
            else if(category.equals("")){
                JOptionPane.showMessageDialog(null, "Category is Required");
            }
            else if(income.equals("")){
                JOptionPane.showMessageDialog(null, "Income is Required");
            }
            else if(education.equals("")){
                JOptionPane.showMessageDialog(null, "Education is Required");
            }
            else if(occupation.equals("")){
                JOptionPane.showMessageDialog(null, "Occupation is Required");
            }
            else if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            }
            else if(adhar.equals("")){
                JOptionPane.showMessageDialog(null, "Adhar Number is Required");
            }
            else if(senior.equals("")){
                JOptionPane.showMessageDialog(null, "Senior Citizen is Required");
            }
            else if(existing.equals("")){
                JOptionPane.showMessageDialog(null, "Existing Account is Required");
            }
            else{
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+religion+"', '"+category+"', '"+income+"', '"+education+"', '"+occupation+"', '"+pan+"', '"+adhar+"', '"+senior+"', '"+existing+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        
    }
    public static void main(String args[]){
        new SignupTwo("");
    }
}

