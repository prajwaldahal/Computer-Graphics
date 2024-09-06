import javax.swing.*;
import java.awt.*;

public class MidpointEllipseDemo extends JPanel {

    private int centerX, centerY, radiusX, radiusY;

    public MidpointEllipseDemo() {
        // Set the size of the panel
        setPreferredSize(new Dimension(400, 400));

        // Set the center coordinates and radii of the ellipse
        centerX = 200;
        centerY = 200;
        radiusX = 400;
        radiusY = 600;
    }

    private void drawPoint(Graphics g, int x, int y) {
        g.drawLine(x, y, x, y);
    }

    private void drawEllipse(Graphics g, int x, int y) {
        g.drawLine(centerX + x, centerY + y, centerX + x, centerY + y);
        g.drawLine(centerX - x, centerY + y, centerX - x, centerY + y);
        g.drawLine(centerX + x, centerY - y, centerX + x, centerY - y);
        g.drawLine(centerX - x, centerY - y, centerX - x, centerY - y);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        int x = 0;
        int y = radiusY;
        int radiusXSquared = radiusX * radiusX;
        int radiusYSquared = radiusY * radiusY;
        int twoASquared = 2 * radiusXSquared;
        int twoBSquared = 2 * radiusYSquared;
        int xEnd = (int) (radiusYSquared / Math.sqrt(radiusXSquared + radiusYSquared));
        int p = (int) (radiusYSquared - (radiusXSquared * radiusY) + (0.25 * radiusXSquared));

        // Draw the first half of the ellipse
        while (x <= xEnd) {
            drawEllipse(g, x, y);
            x++;

            if (p < 0) {
                p += twoBSquared * x + radiusYSquared;
            } else {
                y--;
                p += twoBSquared * x - twoASquared * y + radiusYSquared;
            }
        }

        // Draw the second half of the ellipse
        p = (int) (radiusYSquared * (x + 0.5) * (x + 0.5) + radiusXSquared * (y - 1) * (y - 1) - radiusXSquared * radiusYSquared);

        while (y >= 0) {
            drawEllipse(g, x, y);
            y--;

            if (p > 0) {
                p += -twoASquared * y + radiusXSquared;
            } else {
                x++;
                p += twoBSquared * x - twoASquared * y + radiusXSquared;
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Midpoint Ellipse Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new MidpointEllipseDemo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
