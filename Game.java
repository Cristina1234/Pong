package pingpong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//-------------MODIFICATION COMMENTS--------------------------------------------------------------------------------------------------------------------------
//2 player-pong game, with points indicator for each player. The game will be a race to get the first 3 points. (was able to do the indicator but wan't able to make a condition if win na ba)
//Change the colors of the sprites. (check)
//Create an option to restart a new game after the game ends. (was able to create an option pane pero i dunno hoew to restart it. maka exit siya if dili na i continue)
//Bonus: Add some power-ups per player such that the ball when the user plays the power-up, the ball will move faster towards the opponent. (unchecked)
//---------------------------------------------------------------------------------------------------------------------------------------
@SuppressWarnings("serial")
public class Game extends JPanel {

	Ball ball = new Ball(this);
	Racquet racquet = new Racquet(this);
	Racquet2 racquet2 = new Racquet2(this);
	int speed = 1;
	int speed2 = 1;
	static int restart;
	
	private int getScore() {
		return speed - 1;
	}
	
	private int getScore2() {
		return speed2 -1;
	}
	
	public Game() {
		
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
				racquet2.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
				racquet2.keyPressed(e);
			}
			
		});
		setFocusable(true);
		//Sound.BACK.loop();
	}
	
	private void move() {
		ball.move();
		racquet.move();
		racquet2.move();
	}

	@Override
	//do the painting and sharpening of the sprites
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
		racquet.paint(g2d);
		racquet2.paint(g2d);
		
		//painting the score indicator sa top right pane
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 300);
		
		//painting the score indicator sa bottom left pane
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore2()), 250, 30);
	}
	//ma call ni ang game over if dili masalo sa player ang racquet
	public void gameOver() {
		//Sound.BACK.stop();
		//Sound.GAMEOVER.play();
	
		JOptionPane.showMessageDialog(this, "Player 1 score is: " + getScore() + " \n Player 2 score is: " + getScore2(), "Game Over", JOptionPane.YES_NO_OPTION);
		
		int n = JOptionPane.showConfirmDialog(this, "Do you want to restart?", "Restart Game?",JOptionPane.YES_NO_OPTION);

		    if(n == JOptionPane.YES_OPTION){
		        JOptionPane.showMessageDialog(null, "Alright, here we go again");
		       // main.Main.main(null);
		    }
		    else {
		        JOptionPane.showMessageDialog(null, "Thanks for playing the game");
		        System.exit(0);
		    }
	
	}
	

	public static void main(String[] args) throws InterruptedException {
		//creates a window titled "Mini Tennis" of 300 by 400 pixels
			JFrame frame = new JFrame("Mini Tennis");
			Game game = new Game();
			frame.add(game); //add the object game to the frame container
			frame.setSize(300, 400);
			frame.setVisible(true); //make the window visible
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exits the window 
		//continues to run till ma game over na
			while (true) {
				game.move();
				game.repaint();
				Thread.sleep(10);
			}
	}
}