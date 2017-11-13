import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame  extends Frame {
    private Button addbtn=new Button("add");
    private Button subbtn=new Button("sub");
    private Button exitbtn=new Button("exit");
    private Label lab=new Label("10,150");
    private int labX=10,labY=150;
    private int count=0;
    private Timer t1;
    private boolean boo=true;
    private int b=0;
    public MainFrame(){
        init();
    }
    private void init(){
        this.setBounds(10,10,400,500);
        int a=this.getWidth();
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addbtn.setBounds(50,300,80,30);
        this.add(addbtn);
        exitbtn.setBounds(150,300,80,30);
        this.add(exitbtn);
        subbtn.setBounds(250,300,80,30);
        this.add(subbtn);
        lab.setBounds(10,labY,50,30);
        lab.setBackground(new Color(255, 0,0));
        this.add(lab);

        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                MainFrame.this.setTitle(Integer.toString(++count));
//                lab.setText(Integer.toString(count));
                t1.start();

            }
        });

        exitbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


//        subbtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                lab.setText(Integer.toString(--count));
//            }
//        });


        t1=new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(boo==false){
                    labX-=10;
                    lab.setLocation(labX,labY);
                    lab.setText(Integer.toString(lab.getX())+","+Integer.toString(lab.getY()));
                    lab.setBackground((new Color(255,b,b)));
                    b-=5;
//                    System.out.println(b);
                    if(labX<=10){
                        boo=true;
                    }
                }else if(boo==true){
                    labX+=10;
                    lab.setLocation(labX,labY);
                    lab.setBackground((new Color(255,b,b)));
                    b+=5;
//                    System.out.println(b);
                    lab.setText(Integer.toString(lab.getX())+","+Integer.toString(lab.getY()));
                    if(labX>=a-60){
                        boo=false;
                    }
                }
            }
        });
    }
}