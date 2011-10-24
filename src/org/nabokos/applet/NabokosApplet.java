package org.nabokos.applet;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;

import org.nabokos.game.Game;

public class NabokosApplet extends Applet {
	private static final long serialVersionUID = -9167896770030912854L;
	private static final int MAX_WIDTH = 640;
	private static final int MAX_HEIGHT = 480;
	private static final int MIN_WIDTH = 320;
	private static final int MIN_HEIGHT = 240;
	
	private Dimension maximumSize = new Dimension(MAX_WIDTH,MAX_HEIGHT);
	private Dimension minimumSize = new Dimension(MIN_WIDTH,MIN_HEIGHT);
	private Game game;
	private Thread gameThread;
	
	@Override
	public void init() {
		game = new Game();
		setLayout(new BorderLayout());
		setMaximumSize(maximumSize);
		setMinimumSize(minimumSize);
		add(game);
		gameThread = new Thread(game);
	}

	@Override
	public void start() {
		gameThread.start();
	}

	@Override
	public void stop() {
		game.stop();
	}

	
}
