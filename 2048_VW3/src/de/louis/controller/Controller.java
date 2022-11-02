package de.louis.controller;

import de.louis.module.Module;
import de.louis.view.IView;

public class Controller implements IController{

	private IView view;
	private Module module;
	
	public Controller(IView view) {
		this.view = view;
		module = new Module();
	}
	
	public void nextFrame() {
		view.show(getGrid());
	}
	
	public int getXSize() {
		return module.X_SIZE;
	}
	
	public int getYSize() {
		return module.Y_SIZE;
	}
	
	public void setup() {
		module.random_tile(Module.grid);
		module.random_tile(Module.grid);
	}
	
	public int[] getGrid() {
		return Module.grid;
	}
	
	public void caseLeft() {
		module.score += module.move(Module.grid);
	}
	
	public void caseRight() {
		module.rotate(Module.grid, 2);
		module.score += module.move(Module.grid);
		module.rotate(Module.grid, 2);
	}
	
	public void caseUp() {
		module.rotate(Module.grid);
		module.score += module.move(Module.grid);
		module.rotate(Module.grid, 3);
	}
	
	public void caseDown() {
		module.rotate(Module.grid, 3);
		module.score += module.move(Module.grid);
		module.rotate(Module.grid);
	}
	
	public void random_title() {
		module.random_tile(getGrid());
	}
	
	public boolean game() {	
		return module.game;
	}
	
	public int score() {
		return module.score;
	}
	
	public boolean is_game_over() {
		return module.is_game_over(getGrid());
	}
	
	public void setGame(boolean boo) {
		module.game = boo;
	}
	
	public int X_POS() {
		return module.X_POS;
	}
	
	public int Y_POS() {
		return module.Y_POS;
	}
	
	public int X_OFFSET() {
		return module.X_OFFSET;
	}
	
	public int Y_OFFSET() {
		return module.Y_OFFSET;
	}
	
	public int SIZE_TILE() {
		return module.SIZE_TILE;
	}
	
	public int SIZE_BORDER() {
		return module.SIZE_BORDER;
	}
	
}
