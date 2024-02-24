import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Signup extends JFrame implements ActionListener {
    JButton create,back;
    JTextField tfname,tfusername,tfpassword,tfanswer;
    Choice security;
    Signup(){
        setBounds(350,200,900,360);
        getContentPane().setBackground(Color.white);
        setLayout(null);


        JPanel pl = new JPanel();
        pl.setBackground(new Color(133,193,233));
        pl.setBounds(0,0,500,400);
        pl.setLayout(null);
        add(pl);

        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.BOLD,14));
        lblusername.setBounds(50,20,125,25);
        pl.add(lblusername);

         tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusername);


        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
        lblname.setBounds(50,60,125,25);
        pl.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);


        JLabel lblpassword = new JLabel("Password");
        lblpassword.setFont(new Font("Tahoma",Font.BOLD,14));
        lblpassword.setBounds(50,100,125,25);
        pl.add(lblpassword);

         tfpassword = new JTextField();
        tfpassword.setBounds(190,100,180,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpassword);


        JLabel lblsecurity = new JLabel("Security");
        lblsecurity.setFont(new Font("Tahoma",Font.BOLD,14));
        lblsecurity.setBounds(50,140,125,25);
        pl.add(lblsecurity);

        security = new Choice();
        security.add("select");
        security.add("your first school ");
        security.add("your first phone name");
        security.add("your dog name");
        security.add("your super hero");
        security.setBounds(190,140,180,25);
        pl.add(security);


        JLabel lblanswer = new JLabel("Answer");
        lblanswer.setFont(new Font("Tahoma",Font.BOLD,14));
        lblanswer.setBounds(50,180,125,25);
        pl.add(lblanswer);

         tfanswer = new JTextField();
        tfanswer.setBounds(190,180,180,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfanswer);

        create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(new Color(133,193,233));
        create.setBounds(80,250,100,30);
        create.setFont(new Font("Tahoma",Font.BOLD,14));
        create.addActionListener(this);
        pl.add(create);

         back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(new Color(133,193,233));
        back.setBounds(250,250,100,30);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.addActionListener(this);
        pl.add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/signup1.png"));
        Image i2 = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,50,250,250);
        add(image);



        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
            String answer = tfanswer.getText();

            String quary = "insert into account values('"+username+"','"+name+"','"+password+"', '"+question+"','"+answer+"' )";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(quary);

                JOptionPane.showMessageDialog(null,"Account create successfully");
                setVisible(false);
                new Login();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args){
        new Signup();
    }
}
