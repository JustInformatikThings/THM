package de.louis.main;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet {

	public static void main(String[] args) {
		PApplet.main(Main.class);
	}

	public static PImage[] gen1;
	private PImage ximg;
	int size = 100;
	
	int threadsize = 8;
	private SimpleThread[] threads = new SimpleThread[threadsize];

	@Override
	public void settings() {
		size(1500, 1100);
	}
	
	private long start;
	private long end;
	
	public static int count = 0;

	@Override
	public void setup() {
		gen1 = new PImage[151];
		ximg = loadImage("x.png");
		start = System.currentTimeMillis();
		
		for(int i = 0; i < gen1.length; i++) {
			String p = String.format("https://assets.pokemon.com/assets/cms2/img/pokedex/full/%03d.png", i+1);
			
			threads[i%threadsize] = new SimpleThread(this, i, p);
			threads[i%threadsize].start();
			
			System.out.println("Loaded: " + i);
		}
	}

	@Override
	public void draw() {
		background(255);
		for (int i = 0; i < gen1.length; i++) {
			int xPos = (int) (i % 15) * size;
			int yPos = (int) (i / 15) * size;
			if (gen1[i] != null) {
				image(gen1[i], xPos, yPos, size, size);
				
			} else {
				image(ximg, xPos, yPos, size, size);
			}
		}
		if(gen1.length == count) {
			end = System.currentTimeMillis();
			long diff = (end-start) / 1000;
			System.out.println("Done: " + diff + "s");
		}
	}

}
