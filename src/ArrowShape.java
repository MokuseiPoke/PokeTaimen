import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;

import javax.swing.JPanel;

public class ArrowShape extends JPanel{
		
		public void paintComponent(Graphics g){
			super.paintComponents(g);
			Dimension wh = this.getSize();
			g.drawLine(0, 0, wh.width, wh.height);
			
			
		}
	}