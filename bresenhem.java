import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
class bresenhem extends JFrame{
	private int x1, y1, x2, y2;
	public bresenhem(){
		Scanner sc = new Scanner(System.in);
		System.out.print("enter x1 and y1: ");
		x1=sc.nextInt();
		y1=sc.nextInt();
		System.out.print("enter x2 and y2: ");
		x2=sc.nextInt();
		y2=sc.nextInt();
		setVisible(true);
		setBounds(200,100,400,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void slopePositiveLess(int dx,int dy,Graphics g){
		g.drawLine(x1,y1,x1,y1);
		int p0=2*dy-dx;
		for(int i=0;i<dx;i++)
		{
			if(p0<0){
				x1++;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dy;
			}
			else{
				x1++;
				y1++;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dy-2*dx;
			}
		}
	}
	public void slopePositiveGreat(int dx,int dy,Graphics g){
		g.drawLine(x1,y1,x1,y1);
		int p0=2*dx-dy;
		for(int i=0;i<dy;i++){
			if(p0<0){
				y1++;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dx;
			}
			else{
				x1++;
				y1++;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dx-2*dy;
			}
		}
	}
	public void slopeNegetiveLess(int dx,int dy,Graphics g){
		g.drawLine(x1,y1,x1,y1);
		int p0=2*dy-dx;
		for(int i=0;i<dx;i++){
			if(p0<0){
				x1++;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dy;
			}
			else{
				x1++;
				y1--;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dy-2*dx;
			}
		}
	}
	public void slopeNegetiveGreat(int dx,int dy,Graphics g){
		g.drawLine(x1,y1,x1,y1);
		int p0=2*dx-dy;
		for(int i=0;i<dy;i++){
			if(p0<0){
				y1--;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dx;
			}
			else{
				x1++;
				y1--;
				g.drawLine(x1,y1,x1,y1);
				p0=p0+2*dx-2*dy;
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		int dx=x2-x1;
		int dy=y2-y1;
		float m = (float)dy/dx;
		float mabs=Math.abs(m);
		dx=Math.abs(dx);
		dy=Math.abs(dy);
		if(mabs < 1 && m > 0)
			slopePositiveLess(dx,dy,g);
		else if(mabs < 1 && m < 0)
			slopeNegetiveLess(dx,dy,g);
		else if(mabs > 1 && m>0)
			slopePositiveGreat(dx,dy,g);
		else
			slopeNegetiveGreat(dx,dy,g);

	}
	public static void main(String []args){
		new bresenhem();
	}
}
