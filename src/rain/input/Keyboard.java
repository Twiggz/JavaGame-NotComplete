package rain.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[120]; //stops all the keys on the keyboard
	public boolean up, down, left, right;	   //key track of up/down etc etc
	
	public void update(){
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		
		
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;		//get the ID of the pressed key and set true
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;		//get the ID of the released key and set false
	}

	public void keyTyped(KeyEvent e) {
		
	}


}
