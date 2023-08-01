package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    JLabel text,pin,repin;
    JPasswordField pintext,repintext;
    JButton change,back;
    String pnumber;

    PinChange(String pnumber){
        this.pnumber=pnumber;

        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        text=new JLabel("Change your PIN");
        text.setBounds(275, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD,16));
        image.add(text);

        pin=new JLabel("New PIN");
        pin.setBounds(170, 350, 150, 30);
        pin.setForeground(Color.WHITE);
        pin.setFont(new Font("System", Font.BOLD,16));
        image.add(pin);

        pintext=new JPasswordField();
        pintext.setBounds(350, 350, 150, 30);
        pintext.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(pintext);

        repin=new JLabel("Re-Enter PIN");
        repin.setBounds(170, 390, 150, 30);
        repin.setForeground(Color.WHITE);
        repin.setFont(new Font("System", Font.BOLD,16));
        image.add(repin);

        repintext=new JPasswordField();
        repintext.setBounds(350, 390, 150, 30);
        repintext.setFont(new Font("Raleway", Font.BOLD, 14));
        image.add(repintext);

        change=new JButton("Change");
        change.setBounds(350, 520,150,30);
        change.addActionListener(this);
        image.add(change);

        back=new JButton("Back");
        back.setBounds(350, 565,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin=pintext.getText();
                String rpin=repintext.getText();
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter new PIN");
                    return;
                }
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                    return;
                }
                if(npin.length()>4){
                    JOptionPane.showMessageDialog(null,"Enter four digit PIN");
                    return;
                }
                if(rpin.length()>4){
                    JOptionPane.showMessageDialog(null,"Enter four digit PIN");
                    return;
                }
                Conn c=new Conn();
                String querry1="update bank set pin_number='"+rpin+"' where pin_number='"+pnumber+"'";
                String querry2="update signupthree set pin_number='"+rpin+"' where pin_number='"+pnumber+"'";
                String querry3="update login set pin_number='"+rpin+"' where pin_number='"+pnumber+"'";
                c.s.executeUpdate(querry1);
                c.s.executeUpdate(querry2);
                c.s.executeUpdate(querry3);
                JOptionPane.showMessageDialog(null,"PIN change successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transactions(pnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("");
    }
}
