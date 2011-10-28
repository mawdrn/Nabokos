package org.nabokos.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputController implements KeyListener {
	PressedKeysImp pk = new PressedKeysImp();
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isActionKey()) {
			System.out.println("key : " + e.getKeyCode());
			count(e);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void count(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				pk.up++;
				break;
			case KeyEvent.VK_DOWN:
				pk.down++;
				break;
			case KeyEvent.VK_LEFT:
				pk.left++;
				break;
			case KeyEvent.VK_RIGHT:
				pk.right++;
				break;
		}
	}
	
	public PressedKeys consumeKeys() {
		PressedKeysImp oldPressedKey = pk;
		pk = new PressedKeysImp();
		return oldPressedKey;
	}
	
	private class PressedKeysImp implements PressedKeys {
		private int up = 0;
		private int down = 0;
		private int left = 0;
		private int right = 0;
		
		@Override
		public int getUp() {
			return up;
		}
		@Override
		public int getDown() {
			return down;
		}
		@Override
		public int getLeft() {
			return left;
		}
		@Override
		public int getRight() {
			return right;
		}		
	}
}
