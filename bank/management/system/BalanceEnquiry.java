package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    JLabel text;
    JButton back;
    String pnumber;
    BalanceEnquiry(String pnumber){
        this.pnumber=pnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back=new JButton("Back");
        back.setBounds(350, 565,150,30);
        back.addActionListener(this);
        image.add(back);

        int balance=0;
        try{
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from bank where pin_number='"+pnumber+"'");
                
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
            }catch(Exception e){
                System.out.println(e);
            }
            text=new JLabel("Available Balance is Rs "+balance);
            text.setBounds(225, 300, 700, 35);
            text.setForeground(Color.WHITE);
            text.setFont(new Font("System", Font.BOLD,16));
            image.add(text);

        setSize(900, 900);
        setLocation(300, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new BalanceEnquiry("");
    }
}
