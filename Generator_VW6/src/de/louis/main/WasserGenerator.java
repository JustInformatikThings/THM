package de.louis.main;

public class WasserGenerator extends Thread {

	public String name;
	public int time;

	public WasserGenerator(String name, int time) {
		this.name = name;
		this.time = time;
	}

	@Override
	public void run() {
		while (true) {
			try {

				if (Main.o.isEmpty()) {
					Thread.sleep(time);
				}
				Main.o.poll().acquire();
				Main.ocount--;

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

				System.out.println("Ein neues Wasserelement");
				Main.wassercount++;
				Thread.sleep(time);
			} catch (InterruptedException ex) {
				throw new RuntimeException(ex);
			}
		}

	}

}
