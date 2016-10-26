package pingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

//PLAYER 1
public class Racquet {
	private static final int Y_Down = 330;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;

	public Racquet(Game game) {
		this.game = game;
	}
	//allows to move the racket left and right
	public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
			x = x + xa;
	}
	//pains a racquet to be used by player 1 and sets the color of the racquet to blue.
	public void paint(Graphics2D g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, Y_Down, WIDTH, HEIGHT);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}
	//arrow keys left and right are used here to manipulate the movement of the racquet
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -game.speed;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = game.speed;
	}
	//gets the bouns of the racquet
	public Rectangle getBounds() {
		return new Rectangle(x, Y_Down, WIDTH, HEIGHT);
	}
	
	public int getTopY() {
		return Y_Down - HEIGHT;
	}
	
}
