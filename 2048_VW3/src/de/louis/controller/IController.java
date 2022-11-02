package de.louis.controller;

public interface IController {

	void nextFrame();
	int getXSize();
	int getYSize();
	void setup();
	int[] getGrid();
	void caseLeft();
	void caseRight();
	void caseUp();
	void caseDown();
	
}
