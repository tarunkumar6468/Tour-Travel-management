import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

public class Loading  extends JFrame implements Runnable{
    Thread t;
    JProgressBar bar;
    String username;
    public void run(){
        try{
            for(int i  = 1; i<=101;i++){
                int max = bar.getMaximum(); //100
                int value = bar.getValue();

                if(value <max){
                    bar.setValue(bar.getValue()+ 1);
                }
                else {
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(50);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        this.username = username;

        t = new Thread(this);
        setBounds(500,200,650,400);
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Travel Application");
        text.setBounds(200,20,600,40);
        text.setForeground(Color.DARK_GRAY);
        text.setFont(new Font("Raleway",Font.BOLD,35));
        add(text);

         bar = new JProgressBar(); // iska use persentage ko bdane ke liye use kiya gya h
        bar.setBounds(200,100,300,35);
        bar.setStringPainted(true);
        add(bar);

        JLabel loading = new JLabel("Loading Please wait..");
        loading.setBounds(250,135,200,30);
        loading.setForeground(Color.red);
        loading.setFont(new Font("Raleway",Font.BOLD,16));
        add(loading);

        JLabel lblusername = new JLabel("Welcome "+username);
        lblusername.setBounds(20,310,400,40);
        lblusername.setForeground(Color.red);
        lblusername.setFont(new Font("Raleway",Font.BOLD,16));
        add(lblusername);

        t.start();
        setVisible(true);
    }

    public static void main(String[] args){
        new Loading(" ");
    }
}
