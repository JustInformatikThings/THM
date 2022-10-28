package de.louis.controller;

import de.louis.ball.Ball;
import de.louis.module.Model;
import de.louis.view.View;

public class Controller {

	private View view;
	
	private Model model;
	
	private GameState state;
	
	private Ball ball;
	
	public Controller(View view) {
		this.view = view;
		model = new Model();
		ball = model.ball;
		state = GameState.GAME_STOP;
	}
	
	
	public void nextFrame() {
		switch(state) {
			case GAME_RUNNING -> {
				view.drawGame(ball.x , ball.y, ball.size);
				model.ball.move();
			}
			case GAME_STOP -> {
				view.drawMenu();
			}
		}
	}
	
	public void mouseReleased() {
		switch(state) {
		case GAME_RUNNING -> {
			state = GameState.GAME_STOP;
		}
		case GAME_STOP -> {
			state = GameState.GAME_RUNNING;
		}
	}
	}
	
}
