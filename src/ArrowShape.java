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
	Point[] point = new Point[12];
	public ArrowShape(){
		super();
		{
			//各ポケモンの座標を生成
			for(int i=0;i<12;i++){
				if(i<6){
					point[i] = new Point(10,30+i*50);
				}else{
					point[i] = new Point(270,30+(i-6)*50);
				}
			}
			
			as0= new TestArrow(point[0], point[6]);
			
		}
		
	}
	
	protected void paintComponent(Graphics g){
		Graphics2D g2= (Graphics2D)g;
		g2.setColor(Color.BLUE);
		g2.draw(as0);
	}
}