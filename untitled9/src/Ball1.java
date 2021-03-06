import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball1 extends Thread{
    private ImageIcon iconball = new ImageIcon("球.png");
    private ImageIcon bombbs = new ImageIcon("22.png");
    private JLabel jlb;
    private Timer t1, t2;
    private int x1, y1;
    public Ball1(JLabel jlb1, Game game, int ballX, int ballY){
        x1 = ballX;
        y1 = ballY;
        jlb = jlb1;
        t1 = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb.setIcon(bombbs);
                game.check(x1, y1);
                t2.start();
                System.out.println("t2 start");
            }
        });
        t2 = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jlb.setIcon(null);
                System.out.println("t2 finished");

                t1.stop();
                t2.stop();
            }
        });

    }
    public void run() {
        t1.start();
        System.out.println("ball t1 start");
    }

}