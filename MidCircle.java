import java.awt.*;
import javax.swing.*;
class MidCircle extends JFrame{
	int x=200,y=300,r=100;
	public MidCircle(){
		setVisible(true);
		setSize(600,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void drawPoints(Graphics g,int x1,int y1){
		g.drawLine(x+x1,y+y1,x+x1,y+y1);
		g.drawLine(x+x1,y-y1,x+x1,y-y1);
		g.drawLine(x-x1,y+y1,x-x1,y+y1);
		g.drawLine(x-x1,y-y1,x-x1,y-y1);
		g.drawLine(x+y1,y+x1,x+y1,y+x1);
		g.drawLine(x-y1,y+x1,x-y1,y+x1);
		g.drawLine(x+y1,y-x1,x+y1,y-x1);
		g.drawLine(x-y1,y-x1,x-y1,y-x1);
	}
	public void drawCircle(Graphics g){
		int x1=0,y1=r;

		drawPoints(g,x1,y1);
		int p0=1-r;
		while(true){
			
			if(p0<0){
				x1++;
				drawPoints(g,x1,y1);
				p0=p0+2*x1+1;
			}
			else{
				x1++;
				y1--;
				drawPoints(g,x1,y1);
				p0=p0+2*x1+1-2*y1;
			}
			if(x1>=y1){
				break;
			}
		}
	}
	public void paint(Graphics g){
		super.paint(g);
		drawCircle(g);
	}
	public static void main(String []args){
		MidCircle mc = new MidCircle();
	}
}
