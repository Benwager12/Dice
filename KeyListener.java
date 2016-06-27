package com.benwager12.dice;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {
	
	Window window;
	
	public KeyListener(Window w) {
		this.window = w;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE)
			window.rollDice();
	}
}
