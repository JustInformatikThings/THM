package de.louis.main;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	private PImage himg;
	private PImage oimg;
	private PImage h2oimg;
	private PImage ozonimg;

	private int size = 50;

	public static int ozoncount = 0;
	public static int wassercount = 0;

	public static int hcount = 0;
	public static int ocount = 0;
	
	public static Queue<Semaphore> h = new ConcurrentLinkedQueue<>();
	public static Queue<Semaphore> o = new ConcurrentLinkedQueue<>();

	public static void main(String[] args) {

		PApplet.main(Main.class);
		
		WasserstoffGenerator wg = new WasserstoffGenerator("WasserstoffGenerator", 2000);
		SauerstoffGenerator sg = new SauerstoffGenerator("SauerstoffGenerator", 4000);

		wg.start();
		sg.start();

		WasserGenerator h2o = new WasserGenerator("WasserGenerator", 2000);
		h2o.start();

		OzonGenerator ozon = new OzonGenerator("OzonGenerator", 3000);
		ozon.start();
		
	}

	public void settings() {
		size(1500, 200);
	}

	public void setup() {
		himg = loadImage("h.png");
		oimg = loadImage("o.png");
		h2oimg = loadImage("h2o.png");
		ozonimg = loadImage("ozon.png");
	}

	public void draw() {
		background(200);
		for (int i = 0; i < ozoncount; i++) {
			int xPos = (int) (i % 15) * size;
			image(ozonimg, xPos,0, size, size);
		}
		for (int i = 0; i < wassercount; i++) {
			int xPos = (int) (i % 15) * size;
			image(h2oimg, xPos, 50, size, size);
		}
		for (int i = 0; i < h.size(); i++) {
			int xPos = (int) (i % 15) * size;
			image(himg, xPos, 100, size, size);
		}
		for (int i = 0; i < o.size(); i++) {
			int xPos = (int) (i % 30) * size;
			image(oimg, xPos, 150, size, size);
		}
	}

}
