package pingpong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private Game game;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		
		//moves the ball in directions along its speed
		//boolean changeDirection = true;
		if (x + xa < 0)
			xa = game.speed;
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -game.speed;
		if (y + ya < 0)
			ya = game.speed;
		
		
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		
		//increases the score if the player 1 hits the ball
		if (collisionDown()){
			ya = -game.speed;
			y = game.racquet.getTopY() - DIAMETER;
			game.speed++;
		} 
		
		//increases the score if the player 2 hits the ball
		if (collisionUp()){
			ya = -game.speed2;
			y = game.racquet2.getTopY1() - DIAMETER;
			game.speed2++;
		} 
//		else
//			changeDirection = false;
//		
//		if(changeDirection)
//			Sound.BALL.play();
		x = x + xa;
		y = y + ya;
	}
	
	//returns true if the ball was able to collide with the racquet in the bottom part
	private boolean collisionDown() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	//returns true if the ball was able to collide with the racquet in the top part
	private boolean collisionUp() {
		return game.racquet2.getBounds1().intersects(getBounds());
	}
	
	//draws the ball in ovel shaper and setting its color to yellow
	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
