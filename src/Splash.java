import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable { // is class ko abstract kiya gya hh jise error na aye or iska hm object ni bna skte isi liye me isko override krunga
    Thread thread;
    Splash(){
//        setSize(1200,600); // create a frame
//        setLocation(200,100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons1/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT); // yha se puri ki gai h image
        ImageIcon i3 = new ImageIcon(i2); // image puri krne ke liye use ki kyuki phale chota aa rha  tha
        JLabel image = new JLabel(i3); // and now aab puri ayegi
        add(image);
        setVisible(true); // visible krne ke liye use hua h
        thread = new Thread(this);
        thread.start();
        //run();  agr isko aise call kiya to multithrade jese kam ni krega
    }
    public void run(){ // isko create krne ke bad runnable ka error chla gya
    try{
        Thread.sleep(7000);
        new Login();
        setVisible(false); // agr isko yha likhte h to apne ap bnd ho jayega 7 sec bad
    }catch (Exception e){

    }
    }
    public static void main(String[] args){
        Splash frame = new Splash();
        int x = 1;
        for(int i = 1; i<500; x+=7, i+=6) {
            frame.setLocation(750-(x + i)/2,400-(i/2)); // isko center me rkhen ke kiye kiya gya h
            frame.setSize(x + i, i);// iske size ko rokne ke liye us ekiya gya h
            try {
                Thread.sleep(50);// slowly expand ho rha h panal
            } catch (Exception e){}
        }
    }
}
