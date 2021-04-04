package optional.lab6.figure;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class EllipseTemplate extends ShapeTemplate {

    public EllipseTemplate() {
        super(2);
    }

    public Shape makeShape(Point2D[] p) {
        Ellipse2D s = new Ellipse2D.Double();
        s.setFrameFromDiagonal(p[0], p[1]);
        return s;
    }

}