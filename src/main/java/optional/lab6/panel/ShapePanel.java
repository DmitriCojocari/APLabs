package optional.lab6.panel;

import optional.lab6.figure.ShapeTemplate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShapePanel extends JPanel {

    private static final int WD = 600;
    private static final int HT = WD;
    private static final Color SHAPES_COLOR = Color.RED;
    private static final Color SHAPE_COLOR = Color.BLACK;
    private List<Shape> shapes = new ArrayList<>();
    private Point2D[] points;
    private static Random generator = new Random();
    private static int SIZE = 10;
    private int current;
    private ShapeTemplate shapeTemplate;
    private Shape shape;

    public ShapePanel() {

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                Point p = event.getPoint();
                for (int i = 0; i < points.length; i++) {
                    // System.out.println("points = "+points);
                    double x = points[i].getX() - SIZE / 2;
                    double y = points[i].getY() - SIZE / 2;
                    Rectangle2D r = new Rectangle2D.Double(x, y, SIZE, SIZE);
                    if (r.contains(p)) {
                        current = i;
                        return;
                    }
                }
            }

            public void mouseReleased(MouseEvent event) {
                current = -1;
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent event) {
                if (current == -1)
                    return;
                points[current] = event.getPoint();
                shape = shapeTemplate.makeShape(points);
                repaint();
            }
        });
        current = -1;

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JButton(new SaveShapeAction("Save Shape")));
        setLayout(new BorderLayout());
        add(bottomPanel, BorderLayout.PAGE_END);
    }

    public void setShapeMaker(ShapeTemplate aShapeTemplate) {
        shapeTemplate = aShapeTemplate;
        int n = shapeTemplate.getPointCount();
        points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            double x = generator.nextDouble() * getWidth();
            double y = generator.nextDouble() * getHeight();
            points[i] = new Point2D.Double(x, y);
        }
        shape = shapeTemplate.makeShape(points);
        repaint();
    }

    public Dimension getPreferredSize() {
        return new Dimension(WD, HT);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (points == null)
            return;
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(SHAPES_COLOR);
        for (Shape shape : shapes) {
            g2.draw(shape);
        }
        g2.setColor(SHAPE_COLOR);
        for (int i = 0; i < points.length; i++) {
            double x = points[i].getX() - SIZE / 2;
            double y = points[i].getY() - SIZE / 2;
            g2.fill(new Rectangle2D.Double(x, y, SIZE, SIZE));
        }

        if (shape != null) {
            g2.draw(shape);
        }
    }

    private class SaveShapeAction extends AbstractAction {
        public SaveShapeAction(String name) {
            super(name);
            int mnemonic = (int) name.charAt(0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            shapes.add(shape);
            repaint();
        }
    }

}
