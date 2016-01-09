/*
 * Author: Sophy Yang
 * Date: 2016-01-09
 */

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;


public class StatusBar extends JComponent{
	final int TOTAL_BAR_SIZE = 350;
	int x= 0;
	int y= 0;
	int x1 =TOTAL_BAR_SIZE;
	int y1 = 50;
	Color tempC = Color.green;
	
	public void paintComponent(Graphics g) {
		g.drawRect(0, 0, TOTAL_BAR_SIZE,  50);
		g.setColor(tempC);
		g.fillRect (x, y,  x1,  y1);
		 
	}
	
	public void setNewValues(int remainingTicket, int totalTicket, Color tempColor){
		x1 = ((TOTAL_BAR_SIZE * remainingTicket) /  totalTicket) ;
		tempC = tempColor;
		repaint();
	}
}
