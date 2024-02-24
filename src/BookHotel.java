import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;
import java.sql.SQLException;


public class BookHotel extends JFrame implements ActionListener {
    Choice chotel,cac,cfood;
    TextField tfperson,tfdays;
     String username;
    JLabel lblusername,lblac,lblfood,lbldays,labelprice,lbltotal,labelphone,lblphone,labelnumber,lblnumber,labelid,labelusername,lblid,lblpackage,lblpersons;
    JButton CheckPrice,book,back;

    BookHotel(String username){
        this.username=username;

        setBounds(350,200,1100,600 );
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("BooK Hotel");
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

        lblpackage = new JLabel("Select Hotel");
        lblpackage.setBounds(40,110,150,20);
        lblpackage.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpackage);

        chotel = new Choice();
        chotel.setBounds(250,110,200,20);
        add(chotel);
         try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from hotel");
             while(rs.next()){
                 chotel.add(rs.getString("name"));
             }
         }catch(Exception e){
             e.printStackTrace();
         }


        lblpersons = new JLabel("Total Persons");
        lblpersons.setBounds(40,150,150,25);
        lblpersons.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblpersons);

        tfperson  = new TextField("1");
        tfperson.setBounds(250,150,200,25);
        add(tfperson);


        lbldays = new JLabel("No. of Days");
        lbldays.setBounds(40,190,150,25);
        lbldays.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbldays);

        tfdays  = new TextField("1");
        tfdays.setBounds(250,190,200,25);
        add(tfdays);


        lblac= new JLabel("AC/ Non-AC");
        lblac.setBounds(40,230,150,25);
        lblac.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblac);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-Ac");
        cac.setBounds(250,240,200,20);
        add(cac);


        lblfood= new JLabel("Food Included");
        lblfood.setBounds(40,270,150,25);
        lblfood.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250,270,200,20);
        add(cfood);

        lblid = new JLabel("ID");
        lblid.setBounds(40,310,150,20);
        lblid.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250,310,200,25);
        add(labelid);

        lblnumber= new JLabel("Number");
        lblnumber.setBounds(40,350,150,25);
        lblnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250,350,150,25);
        add(labelnumber);

        lblphone = new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        lblphone.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250,390,200,25);
        add(labelphone);

        lbltotal = new JLabel("Total Price");
        lbltotal.setBounds(40,430,150,25);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lbltotal);

        labelprice = new JLabel();
        labelprice.setBounds(250,430,150,25);
        add(labelprice);

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


        CheckPrice = new JButton("Check Price");
        CheckPrice.setBackground(Color.black);
        CheckPrice.setForeground(Color.WHITE);
        CheckPrice.setBounds(60,490,120,25);
        CheckPrice.addActionListener(this);
        add(CheckPrice);

        book = new JButton("Book Hotel");
        book.setBackground(Color.black);
        book.setForeground(Color.WHITE);
        book.setBounds(200,490,120,25);
        book.addActionListener(this);
        add(book);

        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.setBounds(340,490,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500,50,600,300);
        add(l12);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){

            if (ae.getSource() == CheckPrice) {
                try {
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("select * from hotel where name ='" + chotel.getSelectedItem() + "'");
                    while (rs.next()) {
                        int cost = Integer.parseInt(rs.getString("costperperson"));
                        int food = Integer.parseInt(rs.getString("foodincluded"));
                        int ac = Integer.parseInt(rs.getString("acroom"));

                        int persons = Integer.parseInt(tfperson.getText());
                        int days = Integer.parseInt(tfdays.getText());
                        String acprince = cac.getSelectedItem();
                        String foodselected = cfood.getSelectedItem();
                        if (persons * days > 0) {
                            int total = 0;
                            total += acprince.equals("AC") ? ac : 0;
                            total += foodselected.equals("Yes") ? food : 0;
                            total += cost;
                            total = total * persons * days;
                            labelprice.setText("Rs " + total);
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter valid number");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
         else if(ae.getSource()==book){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("insert into hotelbook values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfperson.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new BookHotel("tarun11 ");
    }
}
