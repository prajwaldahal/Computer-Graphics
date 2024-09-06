import java.awt.*;
import javax.swing.*;
public class DDA extends JFrame{
	public DDA()
	{
		JPanel p = new JPanel();
		getContentPane().add(p);
		setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint(Graphics g)
	{
		int x1=100, y1=100, x2=600, y2=600, steps=0;
		int dx=x2-x1;
		int dy = y2-y1;
		if(Math.abs(dx)>Math.abs(dy))
			steps = Math.abs(dx);
		else
			steps = Math.abs(dy);
		int xInc = (int)dx/steps;
		int yInc = (int)dy/steps;
		for(int i=0; i<steps; i++)
		{
			g.drawLine(x1, y1, x1, y1);
			x1= x1+ xInc;
			y1 = y1+yInc;
		}
	}
	
	public static void main(String[] args)
	{
		DDA d = new DDA();
		d.setVisible(true);
	}
}