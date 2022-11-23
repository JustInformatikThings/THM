package de.louis.main;

public class OzonGenerator extends Thread{

	public String name;
	public int time;
	
	
	
	public OzonGenerator(String name, int time) {
		this.name = name;
		this.time = time;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				if (Main.h.isEmpty()) {
					Thread.sleep(time);
				}
				Main.h.poll().acquire();
				Main.hcount--;
				
				Thread.sleep(time);
				if (Main.h.isEmpty()) {
					Thread.sleep(time);
				}
				Main.h.poll().acquire();
				Main.hcount--;

				if (Main.h.isEmpty()) {
					Thread.sleep(time);
				}
				Thread.sleep(time);
				Main.h.poll().acquire();
				Main.hcount--;

				System.out.println("Ein neues Ozonelement");
				Main.ozoncount++;
				Thread.sleep(time);
			}catch(InterruptedException ex) {
				throw new RuntimeException(ex);
			}
		}
		
	}
	
}
