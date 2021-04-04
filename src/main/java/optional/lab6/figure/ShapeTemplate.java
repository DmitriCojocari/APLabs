package optional.lab6.figure;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class ShapeTemplate {

    private int pointCount;

    public ShapeTemplate(int aPointCount) {
        pointCount = aPointCount;
    }

    public int getPointCount() {
        return pointCount;
    }

    public abstract Shape makeShape(Point2D[] p);

    public String toString() {
        return getClass().getName();
    }

}