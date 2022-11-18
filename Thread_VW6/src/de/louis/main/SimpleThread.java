package de.louis.main;

import processing.core.PApplet;

public class SimpleThread extends Thread{

	
	private PApplet applet;
	
	private int index;
	private String plink;
	
	public SimpleThread(PApplet applet, int index, String plink) {
		this.applet = applet;
		this.index = index;
		this.plink = plink;
	}
	
	@Override
	public void run() {
		Main.gen1[index] = applet.loadImage(plink);
		Main.count++;
		System.out.println("Loaded: " + index);
	}
	
}
