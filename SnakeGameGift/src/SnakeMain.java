import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnakeMain {
	public static int frameWidth;
	public static int frameHeight; 

	static Input keyStroke = new Input(); 
		public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("SnakeGame");
		frame.setSize(500,850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);
		frameWidth= frame.getWidth(); 
		frameHeight= frame.getHeight(); 
		Panel component = new Panel(); 
		 JOptionPane pane = new JOptionPane();
		frame.addKeyListener(keyStroke);
		frame.add(component); 
		frame.setVisible(true); 
		int tryAgain=2;
		while (tryAgain!=1)
		{	
			
			frame.repaint(); 
			frameWidth= frame.getWidth(); 
			frameHeight= frame.getHeight(); 
			if (component.snake.snakeLenght <70)
				{
				Thread.sleep(150-1*component.snake.snakeLenght);
				}
			else {
					Thread.sleep(80);
				}
			if (component.snake.dead) {
				Thread.sleep(500);
				tryAgain = JOptionPane.showConfirmDialog(null, "Would you like to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
				component.snake.reset();
			}
			
			component.snake.key(); 
			component.snake.death(); 
		}
			System.exit(0);
		
	}

}