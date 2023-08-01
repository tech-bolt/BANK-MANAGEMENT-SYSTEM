package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener{
    JLabel text;
    JTextField amount;
    JButton withdraw,back;
    String pnumber;

    Withdrawl(String pnumber){
        this.pnumber=pnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text=new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(180, 300, 400, 30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD, 22));
        amount.setBounds(180, 350, 310, 30);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(350, 525,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(350, 565,150,30);
        back.addActionListener(this);
        image.add(back);

        getContentPane().setBackground(Color.WHITE);

        setSize(900, 900);
        setLocation(300, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String money=amount.getText();
            Date date=new Date();
            if(money.equals("")){
                JOptionPane.showMessageDialog(null,"Please the the amount you want to withdraw");
            }
            else{
                try{
                    Conn c=new Conn();
                    String query="insert into bank values('"+pnumber+"','"+date+"','Withdrawl','"+money+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+money+" withdraw successfully");
                    setVisible(false);
                    new Transactions(pnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Withdrawl("");
    }
}
