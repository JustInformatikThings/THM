package de.louis.view;

import java.util.Arrays;

import de.louis.controller.Controller;
import processing.core.PApplet;

public class View extends PApplet {

	public Controller controller;


	public static void main(String[] args) {
		PApplet.main("de.louis.view.View");
	}
	
	public void settings() {
		controller = new Controller(this);
		size(controller.getXSize(), controller.getYSize());
	}

	public void setup() {
		textAlign(CENTER, CENTER);
		textSize(27);
		noStroke();
		background(color(179, 189, 214));
		colorMode(HSB, 360, 100, 100);

		controller.setup();
		show(controller.getGrid());
		println(controller.getGrid());
	}

	public void keyPressed() {
		int[] temp_grid = controller.getGrid().clone();

		if (key == CODED && controller.game()) {
			switch (keyCode) {
			case LEFT:
				controller.caseLeft();
				break;
			case RIGHT:
				controller.caseRight();
				break;
			case UP:
				controller.caseUp();
				break;
			case DOWN:
				controller.caseDown();
				break;
			}
		}
		if (!Arrays.equals(controller.getGrid(), temp_grid)) {
			controller.random_title();
			show(controller.getGrid());
			println("SCORE =", controller.score());
		}
		if (controller.is_game_over() == true) {
			controller.setGame(false);
			println("GAME OVER. YOUR SCORE =", controller.score());
		}
	}

	public void draw() {
		controller.nextFrame();
	}

	public void show(int[] grid) {
		int edge_length = (int) (Math.sqrt(grid.length));
		int i = 0;
		int X, Y;
		for (int y = 0; y < edge_length; y++) {
			Y = controller.Y_POS() + controller.Y_OFFSET() + controller.SIZE_BORDER() + y * (controller.SIZE_TILE() + controller.SIZE_BORDER());
			for (int x = 0; x < edge_length; x++) {
				X = controller.X_POS() + controller.X_OFFSET() + controller.SIZE_BORDER() + x * (controller.SIZE_TILE() + controller.SIZE_BORDER());
				// fill(color(179, 189, 214));
				fill(color(30 + log(grid[i] + 1) / log(2) * 10, 100, 100));
				rect(X, Y, controller.SIZE_TILE(), controller.SIZE_TILE(), 15);
				if (grid[i] != 0) {
					fill(color(271, 0, 1));
					text(grid[i], X + controller.SIZE_TILE() / 2 + 1, Y + controller.SIZE_TILE() / 2 + 1);
				}
				i++;
			}
		}
	}

}
