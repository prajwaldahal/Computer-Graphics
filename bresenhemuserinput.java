import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class bresenhemuserinput extends JFrame {
        private Graphics g1;
        private JTextField PointX1,PointX2,PointY1,PointY2;
        private JButton Show;
        private JLabel label1,label2;
        int x1, y1, x2, y2;
        public bresenhemuserinput(){
            PointX1=new JTextField(30);
            PointX2=new JTextField(30);
            PointY1=new JTextField(30);
            PointY2=new JTextField(30);
            label1= new JLabel("enter x1 and y1: ");
            label2=new JLabel("enter x2 and y2: ");
            Show=new JButton("Draw");
//            label1.setBounds(10,40,100,80);
//            PointX1.setBounds(10,91,50,50);
//            PointY1.setBounds(80,91,50,50);
//            label2.setBounds(10,120,100,80);
//            PointX2.setBounds(10,171,50,50);
//            PointY2.setBounds(80,171,50,50);
//            PointY2.setBounds(80,171,50,50);
//            Show.setSize(100,100);
            add(label1);
            add(PointX1);
            add(PointY1);
            add(label2);
            add(PointX2);
            add(PointY2);
            add(Show);
            Show.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    getContentPane().removeAll();
                    x2= Integer.parseInt(PointX2.getText());
                    y2= Integer.parseInt(PointY2.getText());
                    x1= Integer.parseInt(PointX1.getText());
                    y1= Integer.parseInt(PointY1.getText());
                    int dx=x2-x1;
                    int dy=y2-y1;
                    float m = (float)dy/dx;
                    float mabs=Math.abs(m);
                    System.out.println("hello");
                    dx=Math.abs(dx);
                    dy=Math.abs(dy);
                    if(mabs < 1 && m > 0)
                        slopePositiveLess(dx,dy,g1);
                    else if(mabs < 1 && m < 0)
                        slopeNegetiveLess(dx,dy,g1);
                    else if(mabs > 1 && m>0)
                        slopePositiveGreat(dx,dy,g1);
                    else
                        slopeNegetiveGreat(dx,dy,g1);
                }
            });
            setLayout(new FlowLayout());
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        public void slopePositiveLess(int dx,int dy,Graphics g){
            System.out.println("a");
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
                System.out.println("(x,y)= "+x1+" "+y1);
            }
        }
        public void slopePositiveGreat(int dx,int dy,Graphics g){
            System.out.println("b");
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
                System.out.println("(x,y)= "+x1+" "+y1);
            }
        }
        public void slopeNegetiveLess(int dx,int dy,Graphics g){
            System.out.println("c");
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
                System.out.println("(x,y)= "+x1+" "+y1);
            }
        }
        public void slopeNegetiveGreat(int dx,int dy,Graphics g){
            System.out.println("d");
            System.out.println("(x,y)= "+x1+" "+y1);
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
                System.out.println("(x,y)= "+x1+" "+y1);
            }
        }
        public void paint(Graphics g){
            super.paint(g);
            g1=g;
        }
        public static void main(String []args){
            new bresenhemuserinput();
        }
    }
