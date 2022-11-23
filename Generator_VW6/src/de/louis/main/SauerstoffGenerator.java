package de.louis.main;

import java.util.concurrent.Semaphore;

public class SauerstoffGenerator extends Thread{

	public String name;
	public int time;
	
	
	public SauerstoffGenerator(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Main.ocount++;
				Main.o.offer(new Semaphore(1));
				System.out.println("O erzeugt " + Main.ocount);
				Thread.sleep((int) (Math.random() * time));
			}catch(InterruptedException ex) {
				throw new RuntimeException(ex);
			}
		}
		
	}
	
}
