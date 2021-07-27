package etterichretz.joel.game.gameobjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import etterichretz.joel.game.Keyboard;

public class Player implements Gameobject{
	
	private double x,y; //Koordinaten
	private double vx,vy; //Velocity Koordinaten
	private double camx,camy;//Kamera Koordinaten
	
	public Player(Map map) {
		x=map.getEX(9);
		y=map.getEY(9);
		System.out.println(x+" "+y);
		vx=0;
		vy=0;
		camx=0;
		camy=0;
	}
	
	public void setX(double x) {
		this.x=x;
	}
	public void setY(double y) {
		this.y=y;
	}
	
	
	public double getCamX() {
		return camx;
	}
	public double getCamY() {
		return camy;
	}
	
	final double FRICTION = 200;
	
	@Override
	public void update(float delta) {
		//Movement
		x-=vx*delta;
		y-=vy*delta;
		
		///////////
		//Friction
		vx-=((vx==0)?0:1)*((vx>0)?FRICTION:-FRICTION)*delta;
		vy-=((vy==0)?0:1)*((vy>0)?FRICTION:-FRICTION)*delta;
		
		vx=(vx<0.01f||vx>-0.01f)?0:vx;
		vy=(vy<0.01f||vy>-0.01f)?0:vy;
		////////////
		
		if(Keyboard.isKeyDown(KeyEvent.VK_W)) {
			vy=-100;
		}
		if(Keyboard.isKeyDown(KeyEvent.VK_S)) {
			vy=100;
		}
		if(Keyboard.isKeyDown(KeyEvent.VK_A)) {
			vx=-100;
		}
		if(Keyboard.isKeyDown(KeyEvent.VK_D)) {
			vx=100;
		}
		//////////
		//Camera Following Player
		camx=x-800/2+4*5;
		camy=y-600/2+4*5;
		
		
	}
	
	
	@Override
	public void draw(Graphics g, double camx,double camy) {
		g.setColor(Color.BLUE);
		g.fillRect((int) (x-camx), (int) (y-camy), 8*5, 8*5);
	}
	
}
