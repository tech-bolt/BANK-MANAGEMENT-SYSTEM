package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame{
    JLabel text,bank,mini,card,balance;
    String pnumber;
    MiniStatement(String pnumber){
        this.pnumber=pnumber;

        setTitle("MINI STATEMENT");

        setLayout(null);

        text=new JLabel();
        add(text);

        bank=new JLabel("INDIAN BANK");
        bank.setBounds(150,20,100,20);
        add(bank);

        card=new JLabel();
        card.setBounds(20, 80,300,20);
        add(card);

        mini=new JLabel();
        mini.setBounds(20, 140,400,200);
        add(mini);

        int bal=0;

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from login where pin_number='"+pnumber+"'");
            while(rs.next()){
                card.setText("Card Number: "+rs.getString("card_number").substring(0,4)+" XXXX XXXX "+rs.getString("card_number").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where pin_number='"+pnumber+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal-=Integer.parseInt(rs.getString("amount"));
                }
                mini.setText(mini.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br>"+"<html>");
            }
        }catch(Exception e){
            System.out.println(e);
        }

        balance=new JLabel("Your current account balance is: Rs "+bal);
        balance.setBounds(20,400,300,20);
        add(balance);

        getContentPane().setBackground(Color.WHITE);

        setSize(400, 600);
        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public static void main(String args[]){
        new MiniStatement("");
    }
}
