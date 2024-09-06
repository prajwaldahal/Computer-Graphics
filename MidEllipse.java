import javax.swing.*;
import java.awt.*;

public class MidEllipse extends JFrame {
    int x=300,y=400,rx=50,ry=80,twory,tworx;
    public MidEllipse(){
        tworx=2*rx*rx;
        twory=2*ry*ry;
        setVisible(true);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void drawPoint(Graphics g,int x1,int y1){
        g.drawLine(x+x1,y+y1,x+x1,y+y1);
        g.drawLine(x+x1,y-y1,x+x1,y-y1);
        g.drawLine(x-x1,y+y1,x-x1,y+y1);
        g.drawLine(x-x1,y-y1,x-x1,y-y1);
    }

    public void drawRadiusX(Graphics g){
        int x1=0,y1=ry;
        int ryd=twory*x1;
        int rxd=tworx*y1;
        drawPoint(g,x1,y1);
        double p0=ry*twory-rx*rx*ry+(1/4*rx*rx);
        System.out.println(p0+ " first");
        while(ryd<rxd){

            if(p0<0){
                x1++;
                drawPoint(g,x1,y1);
                p0=p0+ryd+ry*ry;
                System.out.println(p0+","+x1+","+y1);
            }
            else{
                x1++;
                y1--;
                drawPoint(g,x1,y1);
                p0=p0+ryd+ry*ry-rxd;
                System.out.println(p0+","+x1+","+y1);
            }
            ryd=2*ry*ry*x1;
            rxd=2*rx*rx*y1;

        }
        drawRadiusY(g,x1,y1);
    }

    private void drawRadiusY(Graphics g, int x1, int y1) {
        int ryd=twory*x1;
        int rxd=twory*y1;
        int p0= ry*ry*(x1+1/2)*(x1+1/2)+rx*rx*(y1-1)*(y1-1)-rx*rx*ry*ry;
        drawPoint(g,x1,y1);
        System.out.println("r2"+p0);
        while(y1>0){

            if(p0>0){
                y1--;
                drawPoint(g,x1,y1);
                p0=p0-rxd+rx*rx;
                System.out.println(p0+","+x1+","+y1);
            }
            else{
                x1++;
                y1--;
                drawPoint(g,x1,y1);
                p0=p0+ryd+rx*rx-rxd;
                System.out.println(p0+","+x1+","+y1);
            }
            ryd=2*ry*ry*x1;
            rxd=2*rx*rx*y1;
        }
    }

    public void paint(Graphics g){
        super.paint(g);
        drawRadiusX(g);
    }
    public static void main(String []args){
        new MidEllipse();
    }
}
