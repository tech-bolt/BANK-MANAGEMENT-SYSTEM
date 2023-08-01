package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JLabel text;
    JButton deposit,withdrawl,fastcash,ministatement,pinchange,balance,exit;
    String pnumber;
    Transactions(String pnumber){
        this.pnumber=pnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text=new JLabel("Please select your Transaction");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        deposit=new JButton("Deposit");
        deposit.setBounds(170, 450,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(350, 450,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170, 490,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement=new JButton("Mini Ststement");
        ministatement.setBounds(350, 490,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange=new JButton("Pin Change");
        pinchange.setBounds(170, 530,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balance=new JButton("Balance Enquiry");
        balance.setBounds(350, 530,150,30);
        balance.addActionListener(this);
        image.add(balance);

        exit=new JButton("Exit");
        exit.setBounds(350, 570,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pnumber).setVisible(true);
        }
        else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pnumber).setVisible(true);
        }
        else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pnumber).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pnumber).setVisible(true);
        }
        else if(ae.getSource()==ministatement){
            new MiniStatement(pnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
