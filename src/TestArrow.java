import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class TestArrow extends AbstractShape{
	private Point p0;
	private Point p1;
//	private EffectRelation.Effect effect;
	public TestArrow(Point p0,Point p1){
		this.p0=p0;
		this.p1=p1;
//		this.effect = effect;
	}
	
	private GeneralPath shape;
	protected Shape getMyShape() {
		if(shape==null){
			shape= new GeneralPath();
			
			ArrowPointCalcUtil util= new ArrowPointCalcUtil(this.p0,this.p1);
			
			Point2D p2=util.getPoint2();
			Point2D p3=util.getPoint3();
			
			Line2D line0= new Line2D.Float(this.p0,this.p1);
			Line2D line1= new Line2D.Float(this.p1,p2);
			Line2D line2= new Line2D.Float(this.p1,p3);
			
			shape.append(line0, false);
			shape.append(line1, false);
			shape.append(line2, false);
			
		}
		return shape;
	}

}
