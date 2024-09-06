import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CohenSutherlandLineClippingDemo extends JPanel {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final Color CLIPPING_WINDOW_COLOR = Color.RED;
    private static final Color LINE_COLOR = Color.BLUE;
    private static final int INSIDE = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int BOTTOM = 4;
    private static final int TOP = 8;

    private boolean isDrawingLine;
    private Point start;
    private Point end;
    private Rectangle clippingWindow;

    public CohenSutherlandLineClippingDemo() {
        JFrame frame = new JFrame("Cohen-Sutherland Line Clipping Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.add(this);
        frame.setVisible(true);

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (!isDrawingLine) {
                    start = e.getPoint();
                    isDrawingLine = true;
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (isDrawingLine) {
                    end = e.getPoint();
                    isDrawingLine = false;
                    repaint();
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (isDrawingLine) {
                    end = e.getPoint();
                    repaint();
                }
            }
        });

        // Set the default clipping window
        int windowSize = Math.min(WIDTH, HEIGHT) / 2;
        int windowX = (WIDTH - windowSize) / 2;
        int windowY = (HEIGHT - windowSize) / 2;
        clippingWindow = new Rectangle(windowX, windowY, windowSize, windowSize);
    }

    private void drawClippingWindow(Graphics g) {
        g.setColor(CLIPPING_WINDOW_COLOR);
        g.drawRect(clippingWindow.x, clippingWindow.y, clippingWindow.width, clippingWindow.height);
    }

    private void drawLine(Graphics g, Point p1, Point p2) {
        g.setColor(LINE_COLOR);
        g.drawLine(p1.x, p1.y, p2.x, p2.y);
    }

    private int computeOutCode(Point p) {
        int code = INSIDE;

        if (p.x < clippingWindow.x)
            code |= LEFT;
        else if (p.x > clippingWindow.x + clippingWindow.width)
            code |= RIGHT;

        if (p.y < clippingWindow.y)
            code |= TOP;
        else if (p.y > clippingWindow.y + clippingWindow.height)
            code |= BOTTOM;

        return code;
    }

    private Point computeIntersection(Point p1, Point p2, int code) {
        double slope = (double) (p2.y - p1.y) / (p2.x - p1.x);

        if ((code & TOP) != 0) {
            int x = p1.x + (int) ((clippingWindow.y - p1.y) / slope);
            return new Point(x, clippingWindow.y);
        } else if ((code & BOTTOM) != 0) {
            int x = p1.x + (int) ((clippingWindow.y + clippingWindow.height - p1.y) / slope);
            return new Point(x, clippingWindow.y + clippingWindow.height);
        } else if ((code & RIGHT) != 0) {
            int y = p1.y + (int) ((clippingWindow.x + clippingWindow.width - p1.x) * slope);
            return new Point(clippingWindow.x + clippingWindow.width, y);
        } else if ((code & LEFT) != 0) {
            int y = p1.y + (int) ((clippingWindow.x - p1.x) * slope);
            return new Point(clippingWindow.x, y);
        }

        return null;
    }

    private void cohenSutherlandLineClip() {
        int code1 = computeOutCode(start);
        int code2 = computeOutCode(end);
        boolean isLineInside = false;

        while (true) {
            if ((code1 | code2) == 0) {
                isLineInside = true;
                break;
            } else if ((code1 & code2) != 0) {
                break;
            } else {
                int code = (code1 != 0) ? code1 : code2;
                Point intersection = computeIntersection(start, end, code);

                if (code == code1) {
                    start = intersection;
                    code1 = computeOutCode(start);
                } else {
                    end = intersection;
                    code2 = computeOutCode(end);
                }
            }
        }

        if (isLineInside) {
            drawLine(getGraphics(), start, end);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawClippingWindow(g);

        if (isDrawingLine) {
            drawLine(g, start, end);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CohenSutherlandLineClippingDemo();
            }
        });
    }
}