import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;

abstract class AbstractShape implements Shape {

	abstract protected Shape getMyShape();

	public boolean contains(double x, double y) {
		return getMyShape().contains(x,y);
	}

	public boolean contains(double x, double y, double w, double h) {
		return getMyShape().contains(x,y,w,h);
	}

	public boolean intersects(double x, double y, double w, double h) {
		return getMyShape().intersects(x,y,w,h);
	}

	public Rectangle getBounds() {
		return getMyShape().getBounds();
	}

	public boolean contains(Point2D p) {
		return getMyShape().contains(p);
	}

	public Rectangle2D getBounds2D() {
		return getMyShape().getBounds2D();
	}

	public boolean contains(Rectangle2D r) {
		return getMyShape().contains(r);
	}

	public boolean intersects(Rectangle2D r) {
		return intersects(r);
	}

	public PathIterator getPathIterator(AffineTransform at) {
		return getMyShape().getPathIterator(at); 
	}

	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		return getMyShape().getPathIterator(at,flatness);
	}

}