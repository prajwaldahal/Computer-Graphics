import javax.swing.*;
import java.awt.*;
public class Scaling  extends JFrame {

    private int[][]s={{2,0,0},{0,3,0},{0,0,1}}; //scaling matrix
    private int[][]v={{100,150,200},{100,200,150},{1,1,1}}; //vertex

    public Scaling()
    {
        setBounds(200,10,600,600);
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
        g.drawLine(l[0][0],l[1][0],l[0][1],l[1][1]); //drawing AB
        g.drawLine(l[0][2],l[1][2],l[0][0],l[1][0]); // drawing CA
        g.drawLine(l[0][1],l[1][1],l[0][2],l[1][2]); //drawing BC
    }
	
	void drawTriangle(Graphics g){
        g.drawLine(v[0][0],v[1][0],v[0][1],v[1][1]); //drawing AB
        g.drawLine(v[0][2],v[1][2],v[0][0],v[1][0]); // drawing CA
        g.drawLine(v[0][1],v[1][1],v[0][2],v[1][2]); // drawing BC
    }

    public static void main(String[] args) {
        new ShearingX();
    }
}
