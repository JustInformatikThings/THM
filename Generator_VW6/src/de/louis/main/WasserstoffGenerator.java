package de.louis.main;

import java.util.concurrent.Semaphore;

public class WasserstoffGenerator extends Thread{

	public String name;
	public int time;
	
	
	public WasserstoffGenerator(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Main.hcount++;
				
				Main.h.offer(new Semaphore(1));
				System.out.println("H erzeugt " + Main.hcount);
				Thread.sleep((int) (Math.random() * time));
			}catch(InterruptedException ex) {
				throw new RuntimeException(ex);
			}
		}
		
	}
	
}
