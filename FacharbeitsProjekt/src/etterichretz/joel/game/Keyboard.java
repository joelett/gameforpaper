package etterichretz.joel.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
	
	public static boolean isKeyDown(int keycode) {
		return keystate[keycode];
	}
	
	private static boolean keystate[] = new boolean[1024];
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		keystate[e.getKeyCode()]=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keystate[e.getKeyCode()]=false;
	}

}
