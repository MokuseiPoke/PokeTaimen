import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.geom.GeneralPath;
import java.awt.Point;
import javax.swing.JComponent;
import javax.swing.JPanel;


public class ArrowShape extends JComponent{
	private TestArrow as0;
	Point[] point1 = new Point[12];
	Point[] point2 = new Point[12];
	Color color = Color.BLUE;
	public ArrowShape(){
		super();
		{
			//各ポケモンの座標を生成
			for(int i=0;i<12;i++){
				if(i<6){
					point1[i] = new Point(10,25+i*47);
					point2[i] = new Point(10,40+i*47);
				}else{
					point1[i] = new Point(270,25+(i-6)*47);
					point2[i] = new Point(270,40+(i-6)*47);
				}
			}
			
		}
		
	}
	public ArrowShape(int bottomId,int headId,Color color){
		this();
		this.color=color;
		if(bottomId<headId){	//矢印の向きを確認
			as0 = new TestArrow(point1[bottomId],point1[headId]);
			//ystem.out.println("左から右");
		}else{
			as0 = new TestArrow(point2[bottomId],point2[headId]);
			//System.out.println("右から左");
		}
	}
	
	protected void paintComponent(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(color);
		g2.draw(as0);
	}
}