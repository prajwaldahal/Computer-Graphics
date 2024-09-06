import javax.swing.*;

import java.awt.*;
public class Reflection extends JFrame {

    private int[][]s={{0,1,0},{1,0,0},{0,0,1}}; //reflection matrix
    private int[][]v={{100,30,300},{65,10,60},{1,1,1}}; //vertex

    public Reflection()
    {
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTriangle(g);
        drawScaling(g);
    }

    private void drawScaling(Graphics g) {
        int[][]l= new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    l[i][j]+=s[i][k]*v[k][j];
                }
                System.out.println(l[i][j]);
            }
        }
        g.drawLine(l[0][0]+200,l[1][0]+100,l[0][1]+200,l[1][1]+100); //drawing AB
        g.drawLine(l[0][2]+200,l[1][2]+100,l[0][0]+200,l[1][0]+100); // drawing CA
        g.drawLine(l[0][1]+200,l[1][1]+100,l[0][2]+200,l[1][2]+100); //drawing BC
    }

    void drawTriangle(Graphics g){
        g.drawLine(v[0][0]+300, v[1][0]+100, v[0][1]+300, v[1][1]+100); //drawing AB
        g.drawLine(v[0][2]+300, v[1][2]+100, v[0][0]+300, v[1][0]+100); // drawing CA
        g.drawLine(v[0][1]+300, v[1][1]+100, v[0][2]+300, v[1][2]+100); // drawing BC
    }

    public static void main(String[] args) {
        new Reflection();
    }
}
