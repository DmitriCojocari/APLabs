package optional.lab6.canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DrawingCanvas extends Canvas implements MouseListener, MouseMotionListener {

    final int DIAMETER = 20;
    private Point lineBegin = new Point(0, 0);

    public DrawingCanvas() {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        if (e.isMetaDown()) {
            setForeground(getBackground());
        } else {
            setForeground(Color.black);
        }
        lineBegin.move(e.getX(), e.getY());
    }

    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        if (e.isMetaDown()) {
            g.fillOval(e.getX() - (DIAMETER / 2), e.getY() - (DIAMETER / 2), DIAMETER, DIAMETER);
        } else {
            g.drawLine(lineBegin.x, lineBegin.y, e.getX(), e.getY());
        }
        lineBegin.move(e.getX(), e.getY());
    }

    public void mouseMoved(MouseEvent e) {
    }

}