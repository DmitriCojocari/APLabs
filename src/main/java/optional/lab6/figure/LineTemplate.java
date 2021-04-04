package optional.lab6.figure;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class LineTemplate extends ShapeTemplate {

    public LineTemplate() {
        super(2);
    }

    public Shape makeShape(Point2D[] p) {
        return new Line2D.Double(p[0], p[1]);
    }

}