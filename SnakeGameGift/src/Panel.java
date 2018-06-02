
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class Panel extends JComponent
{
	
	public static final int margins=25; 
	public static final int ics=25; //Internal Cell Size
	public  int columns=((500-2*margins)/(ics)); 
	public int rows=((800-2*margins)/(ics)); 
	Snake snake = new Snake(columns,rows); 
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g; 
		
		snake.poison(); 
		snake.food(); 

		
		//Here we draw the background
		g2.setColor(Color.DARK_GRAY);
		g2.fillRect(0, 0, SnakeMain.frameWidth,SnakeMain.frameHeight);
		
		
		//Here we draw the body of the snake
		g2.setColor(Color.getHSBColor((float)354, (float)0.8010, (float)0.90889));

		for (int i=snake.snakeLenght;i>=0;i--)
		{
		g2.fillRect((int) (margins+(snake.body[i].getX())*ics+1), (int) (margins+(snake.body[i].getY())*ics+1), ics, ics);
		}
		
		//Here we draw the food 

		g2.setColor(Color.GREEN);
		g2.fillRect(margins+ics*snake.getxFood()+1, margins+ics*snake.getyFood()+1, ics-1, ics-1);
		
		//Here we draw the Poison
		if (snake.getShowPoison())
		{
		g2.setColor(Color.MAGENTA);
		g2.fillRect(margins+ics*snake.getxPoison()+1, margins+ics*snake.getyPoison()+1, ics-1, ics-1);
		}

		snake.fillBody(); 
		
	}
}