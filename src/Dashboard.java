import jdk.jfr.Experimental;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard  extends JFrame implements ActionListener {
    String username;
    JButton addpersonDetails,about,notepad,calculator,payments,destinations,bookhotels,viewbookhotels,updatepersonDetails,viewhotels,viewpackages ,viewpersonDetails,deletepersonDetails,checkpackages,bookpackages;
    Dashboard (String username){
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH); // full screen pe panal khone ke liye
        setLayout(null);


        JPanel pl = new JPanel();
        pl.setLayout(null);
        pl.setBackground(new Color(0,0,118));
        pl.setBounds(0,0,1600,65);
        add(pl);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        pl.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahona",Font.BOLD,30));

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,104));
        p2.setBounds(0,65,250,900);
        add(p2);

        addpersonDetails = new JButton("Add Personal Details");
        addpersonDetails.setBounds(0,0,300,50);
        addpersonDetails.setBackground(new Color(0,0,102));
        addpersonDetails.setForeground(Color.white);
        addpersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addpersonDetails.setMargin(new Insets(0,0,0,60));
        addpersonDetails.addActionListener(this);
        p2.add(addpersonDetails);

        updatepersonDetails = new JButton("Update Personal Details");
        updatepersonDetails.setBounds(0,50,300,50);
        updatepersonDetails.setBackground(new Color(0,0,102));
        updatepersonDetails.setForeground(Color.white);
        updatepersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatepersonDetails.setMargin(new Insets(0,0,0,30));
        updatepersonDetails.addActionListener(this);
        p2.add(updatepersonDetails);

        viewpersonDetails = new JButton("View Details");
        viewpersonDetails.setBounds(0,100,300,50);
        viewpersonDetails.setBackground(new Color(0,0,102));
        viewpersonDetails.setForeground(Color.white);
        viewpersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpersonDetails.setMargin(new Insets(0,0,0,130));
        viewpersonDetails.addActionListener(this);
        p2.add(viewpersonDetails);


        deletepersonDetails = new JButton("Delete personal Details");
        deletepersonDetails.setBounds(0,150,300,50);
        deletepersonDetails.setBackground(new Color(0,0,102));
        deletepersonDetails.setForeground(Color.white);
        deletepersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletepersonDetails.setMargin(new Insets(0,0,0,40));
        deletepersonDetails.addActionListener(this);
        p2.add(deletepersonDetails);

        checkpackages = new JButton("Check Package");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(new Color(0,0,102));
        checkpackages.setForeground(Color.white);
        checkpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackages = new JButton("Book Package");
        bookpackages.setBounds(0,250,300,50);
        bookpackages.setBackground(new Color(0,0,102));
        bookpackages.setForeground(Color.white);
        bookpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackages.setMargin(new Insets(0,0,0,120));
        bookpackages.addActionListener(this);
        p2.add(bookpackages);

        viewpackages = new JButton("View Package");
        viewpackages.setBounds(0,300,300,50);
        viewpackages.setBackground(new Color(0,0,102));
        viewpackages.setForeground(Color.white);
        viewpackages.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackages.setMargin(new Insets(0,0,0,120));
        viewpackages.addActionListener(this);
        p2.add(viewpackages);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(new Color(0,0,102));
        viewhotels.setForeground(Color.white);
        viewhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotels.setMargin(new Insets(0,0,0,130));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

        bookhotels = new JButton("Book Hotel");
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setBackground(new Color(0,0,102));
        bookhotels.setForeground(Color.white);
        bookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotels.setMargin(new Insets(0,0,0,135));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);

        viewbookhotels = new JButton( "View Book Hotel");
        viewbookhotels.setBounds(0,450,300,50);
        viewbookhotels.setBackground(new Color(0,0,102));
        viewbookhotels.setForeground(Color.white);
        viewbookhotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewbookhotels.setMargin(new Insets(0,0,0,90));
        viewbookhotels.addActionListener(this);
        p2.add(viewbookhotels);

        destinations = new JButton( "Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(new Color(0,0,102));
        destinations.setForeground(Color.white);
        destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
        destinations.setMargin(new Insets(0,0,0,140));
        destinations.addActionListener(this);
        p2.add(destinations);

        payments = new JButton( "Payment");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.white);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));
        payments.addActionListener(this);
        p2.add(payments);

        calculator = new JButton( "Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.white);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,160));
        calculator.addActionListener(this);
        p2.add(calculator);


        notepad = new JButton( "NotePade");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(new Color(0,0,102));
        notepad.setForeground(Color.white);
        notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
        notepad.setMargin(new Insets(0,0,0,160));
        notepad.addActionListener(this);
        p2.add(notepad);


        about = new JButton( "About");
        about.setBounds(0,700,300,50);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.red);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,180));
        about.addActionListener(this);
        p2.add(about);


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons1/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel txt = new JLabel("Tourism Management System");
        txt.setBounds(450,70,1000,70);
        txt.setForeground(Color.darkGray);
        txt.setFont(new Font("Raleway",Font.PLAIN,55));
        image.add(txt);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addpersonDetails){
            new AddCustomer("");
        }

        else if(ae.getSource()==viewpersonDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource()==updatepersonDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkpackages){
            new CheckPackage();
        }else if(ae.getSource()==bookpackages){
            new BookPackage(username);
        }
        else if(ae.getSource()==viewpackages){
            new ViewPackage(username);
        }
        else if(ae.getSource()==viewhotels){
            new ChechHotels();
        }
        else if(ae.getSource()==destinations){
            new Destinations();
        }
        else if(ae.getSource() == bookhotels){
            new BookHotel(username);
        }else if(ae.getSource()==viewbookhotels){
            new viewBookedHotel(username);
        }
        else if(ae.getSource()==payments){
            new payment();
        }else if(ae.getSource()==calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()==about){
            new About();
        }
        else if(ae.getSource()==deletepersonDetails){
            new DeleteDetails(username);
        }

    }
    public static void main(String [] args){
        new Dashboard("");
    }
}
