package de.louis.view;

import de.louis.controller.Controller;
import processing.core.PApplet;

public class View extends PApplet implements IView{

	public static int X_SIZE = 400;
	public static int Y_SIZE = 400;
	
	private Controller controller;
	
	public static void main(String[] args) {
		PApplet.main("de.louis.view.View");
	}
	
	public void settings() {
		size(X_SIZE,Y_SIZE);
		controller = new Controller(this);
	}
	public void setup() {
		
	}
	
	public void draw() {
		controller.nextFrame();
	}
	
	public void mouseReleased() {
		controller.mouseReleased();
	}
	
	public void drawGame(float x, float y, int size) {
		background(0,255,0);
		circle(x, y, size);
	}


	public void drawMenu() {
		
		background(255,0,0);
	}

}
