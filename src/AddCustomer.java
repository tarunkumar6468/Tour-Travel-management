import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {
    JLabel lableusername,lbladdress,lablgender,lblemail,lblphone,lblcountry,lablename,lblname,lblid,lblnumber,lblusername;
    JComboBox comboid;
    JTextField tfnumber,tfcountry,tfaddress,tfemail,tfphone;
    JRadioButton rmale ,rfemale;
    JButton add,back;

    AddCustomer(String u){
        setBounds(450,200,850,550);

        setLayout(null);
        getContentPane().setBackground(Color.white);

        lblusername = new JLabel("username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);

        lableusername = new JLabel();
        lableusername.setBounds(220,50,150,25);
        add(lableusername);

        lblid = new JLabel("ID");
        lblid.setBounds(30,90,150,25);
        add(lblid);


        comboid = new JComboBox(new String[]{"Passport", "Aadhar Card","Pan Card","Ration card"});
        comboid.setBounds(220,90,150,25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        lblnumber = new JLabel("Number");
        lblnumber.setBounds(30,130,150,25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,25);
        add(tfnumber);

        lblname = new JLabel("Name");
        lblname.setBounds(30,170,150,25);
        add(lblname);

        lablename = new JLabel();
        lablename.setBounds(220,170,150,25);
        add(lablename);

        lablgender = new JLabel("Gender");
        lablgender.setBounds(30,210,150,25);
        add(lablgender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220,210,70,25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300,210,70,25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup(); //isko use kiya h ak ko select krne ke liye lyuki agr ise use ni kroge to dono ko select tiic ayega
        bg.add(rmale);
        bg.add(rfemale);

        lblcountry = new JLabel("Country");
        lblcountry.setBounds(30,250,150,25);
        add(lblcountry);

        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,25);
        add(tfcountry);

        lbladdress = new JLabel("Address");
        lbladdress.setBounds(30,290,150,25);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,25);
        add(tfaddress);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(30,330,150,25);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);

        lblemail = new JLabel("Email");
        lblemail.setBounds(30,370,150,25);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(220,370,150,25);
        add(tfemail);

        add = new JButton("ADD");
        add.setBackground(Color.black);
        add.setForeground(Color.WHITE);
        add.setBounds(70,430,100,25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(220,430,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/newcustomer.jpg."));
        Image  i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40,450,420);
        add(image);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username ='Tarun11'");
            while(rs.next()){
                lableusername.setText(rs.getString("username")); // not change name or username
                lablename.setText(rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
        String username = lableusername.getText();
        String id =(String) comboid.getSelectedItem();
        String number = tfnumber.getText();
        String name = lablename.getText();
        String gender = null;
        if(rmale.isSelected()){
            gender = "Male";

        }else{
            gender = "Female";
        }
        String country = tfcountry.getText();
        String address = tfaddress.getText();
        String phone = tfphone.getText();
        String email = tfemail.getText();

        try{
            Conn c = new Conn();
            String query = "insert into customer values ('"+username+"','"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+address+"','"+phone+"','"+email+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Customer Details Added SuccessFully");
            setVisible(false);

        }catch(Exception e){
            e.printStackTrace();
        }

        }
        else{
            setVisible(false);
        }
    }
    public static void main(String[] args){

        new AddCustomer("");
    }
}
