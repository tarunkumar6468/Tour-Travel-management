import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;


public class BookPackage extends JFrame implements ActionListener {
    Choice cpackage;
    TextField tfperson;
    String username;
    JLabel lblusername,labelprice,lbltotal,labelphone,lblphone,labelnumber,lblnumber,labelid,labelusername,lblid,lblpackage,lblpersons;
    JButton CheckPrice,book,back;
    BookPackage(String username){
        this.username=username;

        setBounds(350,200,1100,500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);
         lblusername = new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        lblusername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblusername);

         labelusername = new JLabel();
        labelusername.setBounds(250,70,200,20);
        labelusername.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labelusername);

         lblpackage = new JLabel("Select Package");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpackage);

        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(250,110,200,20);
        add(cpackage);


         lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpersons);

        tfperson  = new TextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);


         lblid = new JLabel("ID");
        lblid.setBounds(40,190,150,20);
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblid);

         labelid = new JLabel();
        labelid.setBounds(250,190,200,25);
        add(labelid);

         lblnumber= new JLabel("Number");
        lblnumber.setBounds(40,230,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblnumber);

         labelnumber = new JLabel();
        labelnumber.setBounds(250,230,150,25);
        add(labelnumber);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(40,270,150,20);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblphone);

         labelphone = new JLabel();
        labelphone.setBounds(250,270,200,25);
        add(labelphone);

         lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,310,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

         labelprice = new JLabel();
        labelprice.setBounds(250,310,150,25);
        add(labelprice);

        CheckPrice = new JButton("Check Price");
        CheckPrice.setBackground(Color.black);
        CheckPrice.setForeground(Color.WHITE);
        CheckPrice.setBounds(60,380,120,25);
        CheckPrice.addActionListener(this);
        add(CheckPrice);

        book = new JButton("Book Package");
        book.setBackground(Color.black);
        book.setForeground(Color.WHITE);
        book.setBounds(200,380,120,25);
        book.addActionListener(this);
        add(book);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(340,380,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550,50,500,300);
        add(l12);



        try{
            Conn c = new Conn();
            String query = "Select * from customer where username  = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==CheckPrice){
            String pack = cpackage.getSelectedItem();
            int cost  = 0;
            if(pack.equals("Gold Package")){
              cost+=15000;
            }
            else if(pack.equals("Silver Package")){
                cost+=24000;
            }
            else{
                cost+=32000;
            }

            int persons = Integer.parseInt(tfperson.getText());
            cost*=persons;
            labelprice.setText("Rs"+cost);
        }
        else if(ae.getSource()==book){
            try{
                Conn c = new Conn();
                 c.s.executeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfperson.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked Successfully");

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookPackage("Tarun11");
    }
}
