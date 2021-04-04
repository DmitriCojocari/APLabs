package optional.lab6.figure;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class RectangleTemplate extends ShapeTemplate {

    public RectangleTemplate() {
        super(2);
    }

    public Shape makeShape(Point2D[] p) {
        Rectangle2D s = new Rectangle2D.Double();
        s.setFrameFromDiagonal(p[0], p[1]);
        return s;
    }

}