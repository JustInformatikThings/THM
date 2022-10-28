package de.louis.ball;

import de.louis.view.View;

public class Ball {

	public float x, y;
	
	
	private float vx = 10;
	
	public int size;
	
	public Ball(float x, float y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
	
	public void move() {
		x += vx;
		
		if(x > View.X_SIZE-size || x < size) {
			vx *= -1;
		}
	}
	
}
