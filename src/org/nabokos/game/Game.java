package org.nabokos.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 8593882110171080833L;
	private static final long THREAD_SLEEP = 50;
	private static final int NUM_BUFFER = 2;
	private static final Color BACK_GROUND_COLOR = new Color(128, 128, 128);
	private boolean running = false; 
	private InputController keyboard = new InputController();
	
	public Game(Dimension dim) {
		addKeyListener(keyboard);
		setSize(dim);
		setBackground(BACK_GROUND_COLOR);
	}
	
	@Override
	public void run() {
		running = true;
		
		while (running) {
			try {
				Thread.sleep(THREAD_SLEEP);
			} catch (InterruptedException ie) {
				running = false;
				return;
			}
			
			tick();
		}
	}
	
	private void tick() {
		PressedKeys keys = keyboard.consumeKeys();
		render();
	}
	
	private void render() {
		Graphics graph = getBufferedGraphics();
		
		graph.dispose();
		
		showBufferedGraphics();
	}
	
	private Graphics getBufferedGraphics() {
		BufferStrategy bufferStrat = getBufferStrategy();
		if (bufferStrat == null) {
			createBufferStrategy(NUM_BUFFER);
			bufferStrat = getBufferStrategy();
		}
		return bufferStrat.getDrawGraphics();
	}
	
	private void showBufferedGraphics() {
		BufferStrategy bufferStrat = getBufferStrategy();
		bufferStrat.show();
	}

	public void stop() {
		running = false;
	}
}
