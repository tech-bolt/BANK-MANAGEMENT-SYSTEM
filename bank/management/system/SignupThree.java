package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JLabel accountDetails,type,card,cdetail,cnumber,pin,pdetail,pnumber,services;
    JRadioButton saving,fd,current,recurring;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;

    SignupThree(String formno){
        this.formno=formno;

        setTitle("NEW ACCOUNT APPLICATION DETAILS: PAGE 3");

        setLayout(null);

        accountDetails=new JLabel("Page 3: Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(280, 40, 400, 40);
        add(accountDetails);

        type=new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        saving=new JRadioButton("Saving Account");
        saving.setBounds(100,180,250,20);
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBackground(Color.WHITE);
        add(saving);

        fd=new JRadioButton("Fixed Deposit Account");
        fd.setBounds(350,180,250,20);
        fd.setFont(new Font("Raleway",Font.BOLD,16));
        fd.setBackground(Color.WHITE);
        add(fd);

        current=new JRadioButton("Current Account");
        current.setBounds(100,220,250,20);
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBackground(Color.WHITE);
        add(current);

        recurring=new JRadioButton("Recurring Deposit Account");
        recurring.setBounds(350,220,250,20);
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBackground(Color.WHITE);
        add(recurring);

        ButtonGroup account=new ButtonGroup();
        account.add(saving);
        account.add(fd);
        account.add(current);
        account.add(recurring);

        card=new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        cnumber=new JLabel("XXXX-XXXX-XXXX-XXXX");
        cnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        cnumber.setBounds(330, 300, 300, 30);
        add(cnumber);

        cdetail=new JLabel("Your 16 Digit Card Number");
        cdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        cdetail.setBounds(100, 330, 300, 20);
        add(cdetail);

        pin=new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 300, 30);
        add(pin);

        pdetail=new JLabel("Your 4 Digit PIN Number");
        pdetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pdetail.setBounds(100, 400, 300, 20);
        add(pdetail);

        pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        services=new JLabel("Services Required");
        services.setFont(new Font("Raleway", Font.BOLD, 22));
        services.setBounds(100, 450, 300, 30);
        add(services);

        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2=new JCheckBox("INTERNET BANKING");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3=new JCheckBox("MOBILE BANKING");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4=new JCheckBox("EMAIL & SMS ALERTS");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5=new JCheckBox("CHECK BOOK");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6=new JCheckBox("E-STATEMENT");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7=new JCheckBox("I hereby declare that above entered details are correct to the best of my knowledge.");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 680, 600, 30);
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(220, 720, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420, 720, 100, 30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(750, 820);
        setVisible(true);
        setLocation(350, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType="";
            if(saving.isSelected()){
                accountType="Saving Account";
            }
            else if(fd.isSelected()){
                accountType="Fixed Deposit Account";
            }
            else if(current.isSelected()){
                accountType="Current Account";
            }
            else if(recurring.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random random=new Random();
            String cnumber= ""+Math.abs((random.nextLong() % 90000000L) +5040936000000000L);
            String cnum=cnumber.substring(0, 4)+" "+cnumber.substring(4, 8)+" "+cnumber.substring(8, 12)+" "+cnumber.substring(12, 16);

            String pnumber=""+Math.abs((random.nextLong() % 9000L) +1000L);

            String facility="";
            if(c1.isSelected()){
                facility=facility+" ATM CARD";
            }
            else if(c2.isSelected()){
                facility=facility+" INTERNET BANKING";
            }
            else if(c3.isSelected()){
                facility=facility+" MOBILE BANKING";
            }
            else if(c4.isSelected()){
                facility=facility+" EMAIL & SMS ALERTS";
            }
            else if(c5.isSelected()){
                facility=facility+" CHECK BOOK";
            }
            else if(c6.isSelected()){
                facility=facility+" E-STATEMENT";
            }
            String declaration="";
            if(c7.isSelected()){
                declaration="yes";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                else if(services.equals("")){
                    JOptionPane.showMessageDialog(null, " Select at least one Service");
                }
                else if(declaration.equals("")){
                    JOptionPane.showMessageDialog(null, " Declaration is Required");
                }
                else{
                    Conn c=new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"', '"+cnumber+"', '"+pnumber+"', '"+facility+"')";
                    String query2="insert into login values('"+formno+"','"+cnumber+"', '"+pnumber+"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number: "+cnum+"\nPin Number: "+pnumber);
                    setVisible(false);
                    new Deposit(pnumber).setVisible(false);
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]){
        new SignupThree("");
    }
}
