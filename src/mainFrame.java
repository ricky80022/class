import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainFrame extends JFrame{
    private int dirFlag = 1,objX = 50, objY = 50, objW = 50, objH = 50;
    private JPanel jbc = new JPanel();
    private JPanel jbs = new JPanel(new GridLayout(1,6,3,3));
    private Container cp;
    private JLabel jlb = new JLabel();
    private ImageIcon icon = new ImageIcon("boat.png");
    private Timer t1;
    private JButton jbtnRun = new JButton("Run");
    private JButton jbt0 = new JButton(" ↑");
    private JButton jbt1 = new JButton(" ↓");
    private JButton jbt2 = new JButton("←");
    private JButton jbt3 = new JButton(" →");
    private JButton jbt4 = new JButton("Exit");

    public mainFrame(){
        init();
    }

    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(500,250,600,600);
        this.setResizable(false);


        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jbc,BorderLayout.CENTER);
        cp.add(jbs,BorderLayout.SOUTH);
        jbs.add(jbtnRun);
        jbs.add(jbt0);
        jbs.add(jbt1);
        jbs.add(jbt2);
        jbs.add(jbt3);
        jbs.add(jbt4);

        jbc.add(jlb);
        jlb.setBounds(objX,objY,50,50);
        jlb.setIcon(icon);

        jbt0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=1;
            }
        });
        jbt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=2;
            }
        });
        jbt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=3;
            }
        });
        jbt3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dirFlag=4;
            }
        });


        jbtnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t1.start();
            }
        });

        t1=new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (dirFlag){
                    case 1 :
                        if(objY-2>0){
                            objY-=2;
                        }break;
                    case 2 :
                        if(objY+2<600){
                            objY+=2;
                        }break;
                    case 3 :
                        if(objX-2>0){
                            objX-=2;
                        }break;
                    case 4 :
                        if(objX+2<600){
                            objX+=2;
                        }break;
                }
                jlb.setLocation(objX,objY);
            }
        });
        jbt4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });




    }
}

