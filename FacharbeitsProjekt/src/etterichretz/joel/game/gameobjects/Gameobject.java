package etterichretz.joel.game.gameobjects;

import java.awt.Graphics;

public interface Gameobject {
	
	public void update(float delta);
	public void draw(Graphics g,double camx,double camy);

}
