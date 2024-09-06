import java.awt.*;
import javax.swing.*;

public class CubeTranslationDemo extends JFrame {
    private Canvas canvas;

    private CubeTranslationDemo() {
        setTitle("Cube Translation Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(400, 400));

        add(canvas);
        pack();
        setLocationRelativeTo(null);
    }

    private void start() {
        setVisible(true);
    }

    private class Canvas extends JPanel {
        private Point3D[] vertices = {
                new Point3D(-50, -50, -50),
                new Point3D(-50, -50, 50),
                new Point3D(-50, 50, -50),
                new Point3D(-50, 50, 50),
                new Point3D(50, -50, -50),
                new Point3D(50, -50, 50),
                new Point3D(50, 50, -50),
                new Point3D(50, 50, 50)
        };

        private int[][] edges = {
                { 0, 1 }, { 0, 2 }, { 0, 4 },
                { 1, 3 }, { 1, 5 }, { 2, 3 },
                { 2, 6 }, { 3, 7 }, { 4, 5 },
                { 4, 6 }, { 5, 7 }, { 6, 7 }
        };

        private Canvas() {
            setPreferredSize(new Dimension(400, 400));
            setBackground(Color.WHITE);

            performTranslation(100, 100, 100);

            repaint();
        }

        private void performTranslation(int dx, int dy, int dz) {
            for (int i = 0; i < vertices.length; i++) {
                vertices[i] = vertices[i].add(dx, dy, dz);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);

            // Draw cube edges
            for (int[] edge : edges) {
                Point3D p1 = vertices[edge[0]];
                Point3D p2 = vertices[edge[1]];
                g2d.drawLine((int) p1.x + 200, (int) p1.y + 200, (int) p2.x + 200, (int) p2.y + 200);
            }

            // Draw cube vertices
            for (Point3D vertex : vertices) {
                g2d.fillOval((int) vertex.x + 198, (int) vertex.y + 198, 5, 5);
            }
        }
    }

    public static void main(String[] args) {
        CubeTranslationDemo demo = new CubeTranslationDemo();
        demo.start();
    }
}

class Point3D {
    public double x;
    public double y;
    public double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3D add(double dx, double dy, double dz) {
        return new Point3D(x + dx, y + dy, z + dz);
    }
}
