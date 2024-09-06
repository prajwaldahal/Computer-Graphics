import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Rotation extends JFrame {

    private double[][]r; //rotation matrix
    private int[][]v={{100,30,300},{80,10,60},{1,1,1}}; //vertex

    public Rotation()
    {
		Scanner sc = new Scanner(System.in);
		System.out.print("enter a rotation degree: ");
		Double x2=sc.nextDouble();
		r= new double[][]{{Math.cos(x2), -Math.sin(x2), 0} , {Math.sin(x2),Math.cos(x2) , 0}, {0, 0, 1}};
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
	
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawTriangle(g);
        drawRotation(g);
    }

    private void drawRotation(Graphics g) {
            int[][]l= new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    l[i][j]+=r[i][k]*v[k][j];
                }
                System.out.println(l[i][j]);
            }
        }
         g.drawLine(l[0][0]+300,l[1][0]+100,l[0][1]+300,l[1][1]+100); //drawing AB
         g.drawLine(l[0][2]+300,l[1][2]+100,l[0][0]+300,l[1][0]+100); // drawing CA
         g.drawLine(l[0][1]+300,l[1][1]+100,l[0][2]+300,l[1][2]+100); //drawing BC
    }
	
	void drawTriangle(Graphics g){
        g.drawLine(v[0][0]+300, v[1][0]+100, v[0][1]+300, v[1][1]+100); //drawing AB
        g.drawLine(v[0][2]+300, v[1][2]+100, v[0][0]+300, v[1][0]+100); // drawing CA
        g.drawLine(v[0][1]+300, v[1][1]+100, v[0][2]+300, v[1][2]+100); // drawing BC
    }

    public static void main(String[] args) {
        new Rotation();
    }
}
