import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    CheckPackage(){
        setBounds(450,200,900,600);
        String [] package1 = {"GOLD PACKAGE","6 Days & 7 Nights","Airport Assistance","Half Day City Tour","Daily Buffet","Soft Drink Free","Full Day Island Cruise","English Speaking guide","BOOK PACKAGE","Summer Special","Rs 15000/-","package1.jpg"};
        String [] package2 = {"SILVER PACKAGE","6 Days & 7 Nights","Toll Free ","Entrance Free Tickets ","Meet and Greet at Airport","Welcome Drinks on Arrival","Night Safari","Cruise with Dinner","BOOK NOW","Winter Special","Rs 24000/-","package2.jpg"};
        String [] package3 = {"BRONZE PACKAGE","6 Days & 7 Nights","Return AirFare", "Free clubbing","Horse Riding & other Games","Hard Drinks Free","Daily Buffer","BBQ Dinner","BOOK NOW","Winter Special","Rs 32000/-","package3.jpg"};
        JTabbedPane tab = new JTabbedPane();
        JPanel pl = CreatePackages(package1);
        tab.addTab("Package 1",null,pl);
        JPanel pl2 = CreatePackages(package2);
        tab.addTab("Package 2",null,pl2);
        JPanel pl3 = CreatePackages(package3);
        tab.addTab("Package 3",null,pl3);

        add(tab);
        setVisible(true);
    }
    public JPanel CreatePackages(String[] pack){
        JPanel pl = new JPanel();
        pl.setLayout(null);
        pl.setBackground(Color.white);

        JLabel l1 = new JLabel(pack[0]);
        l1.setBounds(50,5,300,30);
        l1.setForeground(Color.DARK_GRAY);
        l1.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(l1);

        JLabel l2 = new JLabel(pack[1]);
        l2.setBounds(30,60,300,30);
        l2.setForeground(Color.RED);
        l2.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(l2);

        JLabel airAssistance = new JLabel(pack[2]);
        airAssistance.setBounds(30,110,300,30);
        airAssistance.setForeground(Color.BLUE);
        airAssistance.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(airAssistance);

        JLabel Tour = new JLabel(pack[3]);
        Tour.setBounds(30,160,300,30);
        Tour.setForeground(Color.GREEN);
        Tour.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(Tour);

        JLabel Daily = new JLabel(pack[4]);
        Daily.setBounds(30,210,300,30);
        Daily.setForeground(Color.RED);
        Daily.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(Daily);

        JLabel welcome = new JLabel(pack[5]);
        welcome.setBounds(30,260,350,30);
        welcome.setForeground(Color.BLUE);
        welcome.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(welcome);

        JLabel FullDay = new JLabel(pack[6]);
        FullDay.setBounds(30,310,350,30);
        FullDay.setForeground(Color.RED);
        FullDay.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(FullDay);

        JLabel Guide = new JLabel(pack[7]);
        Guide.setBounds(30,360,400,30);
        Guide.setForeground(Color.BLUE);
        Guide.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(Guide);

        JLabel book = new JLabel(pack[8]);
        book.setBounds(60,440,300,30);
        book.setForeground(Color.BLACK);
        book.setFont(new Font("Tahoma",Font.BOLD,25));
        pl.add(book);

        JLabel summer = new JLabel(pack[9]);
        summer.setBounds(80,480,300,30);
        summer.setForeground(Color.MAGENTA);
        summer.setFont(new Font("Tahoma",Font.BOLD,25));
        pl.add(summer);

        JLabel paisa = new JLabel(pack[10]);
        paisa.setBounds(500,480,300,30);
        paisa.setForeground(Color.darkGray);
        paisa.setFont(new Font("Tahoma",Font.BOLD,25));
        pl.add(paisa);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/"+pack[11]));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(350,20,500,300);
        pl.add(l12);
        return pl;
    }
    public static void main(String[] args){
        new CheckPackage();
    }
}
