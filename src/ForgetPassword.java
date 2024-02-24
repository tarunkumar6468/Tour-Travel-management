import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ForgetPassword extends JFrame implements ActionListener {

    JTextField tfusename,tfname,tfquestion,tfanswer,tfpassword;
    JLabel lblUsename,lblname ,lblquestion,lblanswer,lblpassword;
    JButton search,retrieve,back;
    ForgetPassword(){
        setBounds(350,200,850,380);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(580,70,200,200);
        add(image);

        JPanel pl = new JPanel(); // devide krne ke liye panal ko
        pl.setLayout(null);
        pl.setBounds(30,30,500,280);
        add(pl);


        JLabel lblusername = new JLabel("Username");
        lblusername. setBounds(40,20,100,25);
        lblusername.setFont(new Font("Tahoma", Font.BOLD,15));
        pl.add(lblusername);

        tfusename = new JTextField();
        tfusename.setBounds(220,20,150,25);
        tfusename.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusename);

        search = new JButton("Search");
        search.setBackground(Color.CYAN);
        search.setForeground(Color.black);
        search.setBounds(380,20,100,25);
        search.addActionListener(this);
        pl.add(search);

        JLabel lblname = new JLabel("Name");
        lblname. setBounds(40,60,150,25);
        lblname.setFont(new Font("Tahoma", Font.BOLD,15));
        pl.add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220,60,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);

         lblquestion = new JLabel("Your Security Que..");
        lblquestion. setBounds(40,100,150,25);
        lblquestion.setFont(new Font("Tahoma", Font.BOLD,15));
        pl.add(lblquestion);

        tfquestion = new JTextField();
        tfquestion.setBounds(220,100,150,25);
        tfquestion.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfquestion);

        lblanswer = new JLabel("Your Answer");
        lblanswer. setBounds(40,145,150,25);
        lblanswer.setFont(new Font("Tahoma", Font.BOLD,15));
        pl.add(lblanswer);

        tfanswer = new JTextField();
        tfanswer.setBounds(220,145,150,25);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfanswer);

        retrieve = new JButton("Retrieve");
        retrieve.setBackground(Color.CYAN);
        retrieve.setForeground(Color.black);
        retrieve.setBounds(380,145,100,25);
        retrieve.addActionListener(this);
        pl.add(retrieve);

        lblpassword = new JLabel("Password");
        lblpassword. setBounds(40,185,150,25);
        lblpassword.setFont(new Font("Tahoma", Font.BOLD,15));
        pl.add(lblpassword);

        tfpassword = new JTextField();
        tfpassword.setBounds(220,185,150,25);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpassword);

        back = new JButton("Back");
        back.setBackground(Color.CYAN);
        back.setForeground(Color.black);
        back.setBounds(245,230,100,25);
        back.addActionListener(this);
        pl.add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==search){
            try{
                String query = "select * from account where username = '"+tfusename.getText()+"'";
                Conn c = new Conn();
                ResultSet rs  = c.s.executeQuery(query);
                while(rs.next()){
                   tfname.setText( rs.getString("name"));
                    tfquestion.setText(rs.getString("security"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==retrieve){
            try{
                String query = "select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusename.getText()+"'";
                Conn c = new Conn();
                ResultSet rs  = c.s.executeQuery(query);
                while(rs.next()){
                    tfpassword.setText( rs.getString("password"));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }

    }
    public static void main(String[] args){
        new ForgetPassword();
    }
}
