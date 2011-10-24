package org.nabokos.game;

import java.awt.Component;

public class Game extends Component implements Runnable {
	private static final long serialVersionUID = 8593882110171080833L;
	private static final long THREAD_SLEEP = 50;
	private boolean running = false; 
	
	@Override
	public void run() {
		running = true;
		
		while (running) {
			try {
				Thread.sleep(THREAD_SLEEP);
			} catch (InterruptedException ie) {
				running = false;
			}
			
			tick();
		}
	}
	
	private void tick() {
		System.out.println("tick");
	}
	
	public void stop() {
		running = false;
	}
}
