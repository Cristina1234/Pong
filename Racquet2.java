package pingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
//same to do with the Racquet class, naa lng modifications sa position as asiya iplaced, ang color sa racket
//PLAYER 2
public class Racquet2 {
	private static final int Y_Up = 0;
	private static final int WIDTH = 60;
	private static final int HEIGHT = 10;
	int x = 0;
	int xa = 0;
	private Game game;


public Racquet2(Game game) {
	this.game = game;
}

public void move() {
	if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
		x = x + xa;
}

public void paint(Graphics2D g) {
	g.setColor(Color.RED);
	g.fillRect(x, Y_Up, WIDTH, HEIGHT);
}

public void keyReleased(KeyEvent e) {
	xa = 0;
}

public void keyPressed(KeyEvent e) {

	if (e.getKeyCode() == KeyEvent.VK_1)
		xa = -game.speed2;
	if (e.getKeyCode() == KeyEvent.VK_2)
		xa = game.speed2;
}
public Rectangle getBounds1() {
	return new Rectangle(x, Y_Up, WIDTH, HEIGHT);
}

public int getTopY1() {
	return Y_Up - HEIGHT;
}
}