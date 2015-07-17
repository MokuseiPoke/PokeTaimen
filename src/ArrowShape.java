import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

import javax.swing.JPanel;

import com.sun.javafx.scene.paint.GradientUtils.Point;

public class ArrowShape extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			Dimension wh = this.getSize();
			//g.drawLine(0, 0, wh.width, wh.height);
			for(int i=0;i<6;i++){
				g.drawLine(5,34+47*i,5,34+47*i);
			}
			
		}
	}