
import java.awt.geom.Point2D;
import java.util.Random;

public class Snake 
{
	private int columns;
	private int rows; 
	private int xPos;
	private int yPos; 
	private final int size = Panel.ics;
	public static int snakeLenght=0; 
	private int xFood;
	private int yFood; 
	private int xPoison;
	private int yPoison; 
	private boolean showPoison=false; 
	public Point2D.Double[] body=new Point2D.Double[(500)];
	boolean dead=false; 
	
	Random rand= new Random(); 
	public static int xDirection=0;
	public static int yDirection =0;
	
	public Snake(int columns, int rows)
	{
		this.xPos=(int)(columns/2)-1;
		this.yPos=(int)(rows/2)-1;
		this.columns=columns;
		this.rows=rows; 
		this.snakeLenght=0; 
		this.body[snakeLenght]=new Point2D.Double(this.xPos, this.yPos); 
		xFood= rand.nextInt(columns-1);
		yFood= rand.nextInt(rows-1);

	}


	public int getxPos() {
		return xPos;
	}


	public int getyPos() {
		return yPos;
	}


	public int getSize() {
		return size;
	}


	public void setxDirection(int x) {
		
		body[0].setLocation(body[0].getX()+x,body[0].getY());
		if (this.body[0].getX()>this.columns-2 )
		{
			body[0].setLocation(0,body[0].getY());
		}
		else if(this.body[0].getX()<0)
		{
			body[0].setLocation(columns-2,body[0].getY());
		}
		this.xPos=(int) this.body[0].getX();
		this.yPos=(int) this.body[0].getY();
		
	}
	public void setyDirection(int y) {
		body[0].setLocation(body[0].getX(),body[0].getY()+y);
		if (this.body[0].getY()>this.rows-2 )
		{
			body[0].setLocation(body[0].getX(),0);
		}
		else if(this.body[0].getY()<0)
		{
			body[0].setLocation(body[0].getX(),rows-2);
		}
		this.xPos=(int) this.body[0].getX();
		this.yPos=(int) this.body[0].getY();
		
		
		
		//Here we give the body array its positions; 
	}
	public void fillBody()
	{
		for (int i=snakeLenght;i>0;i--)
		{
			body[(i)].setLocation(body[i-1].getX(),body[i-1].getY());
		}		
	}
	
	public int getLenght()
	{
		return this.snakeLenght; 
	}
	
	//Here we create the food object. The code checks that the food is not created inside the snake. 
	public void food()
	{
		boolean check=false; 
		if (body[0].getX()==xFood && body[0].getY()==yFood)
		{
		this.snakeLenght+=1; 
		this.body[snakeLenght]=new Point2D.Double();
		this.fillBody(); 
		while(!check)
		{
			check=true; 
			xFood= rand.nextInt(columns-1);
			yFood= rand.nextInt(rows-1);
			for (int i=0;i<snakeLenght;i++)
			{
				if (xFood==body[i].getX()&& yFood==body[i].getY())
				{
					check=false; 
				}
			}

			}		
		}

	}
	
	// this method will randomly create a poison. The chance of poison is originally 0 and grows as the snake gets longer. 
	public void poison()
	{
		if (this.body[0].getX()==xPoison && this.body[0].getY()==yPoison && this.showPoison)
		{
			this.dead=true; 
		}
		boolean check=false; 
		if (body[0].getX()==xFood && body[0].getY()==yFood)
		{
			if (rand.nextInt(100)<snakeLenght)
			{
				this.showPoison=true;
			}
			else
			{
				this.showPoison=false; 
			}

		while(!check)
		{
			check=true; 
			this.xPoison= rand.nextInt(columns-1);
			this.yPoison= rand.nextInt(rows-1);
			for (int i=0;i<snakeLenght;i++)
			{
				if (xPoison==body[i].getX()&& yPoison==body[i].getY())
				{
					check=false; 
				}
			}

		}		
		
		}
	}
	
	
	public int getxFood() {
		return xFood;
	}


	public int getyFood() {
		return yFood;
	}
	public int getxPoison() {
		return xPoison;
	}


	public int getyPoison() {
		return yPoison;
	}
	public boolean getShowPoison()
	{
		return this.showPoison; 
	}
	//This is the death method. It checks that the snake has not eaten itself. It it has, the game ends
	public void death()
	{
		for (int i=1;i<=snakeLenght;i++)
		{
			if (this.body[0].getX()==this.body[i].getX() && this.body[0].getY()==this.body[i].getY() )
			{
				this.dead=true; 
			}
		}
		
	}
	public void reset()
	{
		this.xPos=(int)(columns/2)-1;
		this.yPos=(int)(rows/2)-1;
		this.columns=columns;
		this.rows=rows; 
		this.snakeLenght=0; 
		this.body[snakeLenght]=new Point2D.Double(this.xPos, this.yPos); 
		xFood= rand.nextInt(columns-1);
		yFood= rand.nextInt(rows-1);
		this.dead=false;
	}
	
	public void key()
	{
		if (SnakeMain.keyStroke.isDownPressed()&& (this.yDirection==0||this.snakeLenght==0))
		{
		this.xDirection=0;
		this.yDirection=1;
		}
	else if (SnakeMain.keyStroke.isUpPressed() && (this.yDirection==0||this.snakeLenght==0))
	{
		this.xDirection=0;
		this.yDirection=-1;
	}
	else if (SnakeMain.keyStroke.isLeftPressed() && (this.xDirection==0||this.snakeLenght==0))
	{
		this.xDirection=-1;
		this.yDirection=0;
	}
	else if (SnakeMain.keyStroke.isRightPressed()&& (this.xDirection==0||this.snakeLenght==0))
	{
		this.xDirection=1;
		this.yDirection=0;
	}
		this.setxDirection(this.xDirection);
		this.setyDirection(this.yDirection);
	}
}