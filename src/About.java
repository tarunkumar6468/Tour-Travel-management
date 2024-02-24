import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements  ActionListener{
    About(){
        setBounds(600,200,500,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1 = new JLabel("About");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);

        String s = "Hello I am Tarun kumar\n & abhi ke liye itna hi thankYou:";


        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);

        JButton back = new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Dashboard(" ");
    }
    public static void main(String[] args){
        new About();
    }
}
