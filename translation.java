import javax.swing.*;
import java.awt.*;
public class translation extends JFrame {

    private int[][]t={{1,0,600},{0,1,100},{0,0,1}}; //translation matrix
    private int[][]v={{100,500,300},{300,400,500},{1,1,1}}; //vertex

    public translation()
    {
        setBounds(200,10,600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    void drawTriangle(Graphics g){
        g.drawLine(v[0][0],v[1][0],v[0][1],v[1][1]); //drawing AB
        g.drawLine(v[0][2],v[1][2],v[0][0],v[1][0]); // drawing CA
        g.drawLine(v[0][1],v[1][1],v[0][2],v[1][2]); // drawing BC
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTriangle(g);
        drawTranslation(g);
    }

    private void drawTranslation(Graphics g) {
            int[][]l= new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    l[i][j]+=t[i][k]*v[k][j];
                }
            }
        }
        g.drawLine(l[0][0],l[1][0],l[0][1],l[1][1]); //drawing AB
        g.drawLine(l[0][2],l[1][2],l[0][0],l[1][0]); // drawing CA
        g.drawLine(l[0][1],l[1][1],l[0][2],l[1][2]); //drawing BC
    }

    public static void main(String[] args) {
        new translation();
    }
}
