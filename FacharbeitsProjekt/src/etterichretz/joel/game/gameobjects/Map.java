package etterichretz.joel.game.gameobjects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Map implements Gameobject{
	
	private static final int tilesize = 8;
	private static BufferedImage tiles[];
	
	static {
		try {
			BufferedImage tileset = ImageIO.read(new File("src\\etterichretz\\joel\\game\\gameobjects\\gfx\\tileset.png"));
			tiles = new BufferedImage[(tileset.getWidth()/tilesize)*(tileset.getHeight()/tilesize)];
			for(int x=0;x<tileset.getWidth()/tilesize;x++) {
				for(int y=0;y<tileset.getHeight()/tilesize;y++) {
					tiles[x+y*(tileset.getWidth()/tilesize)] = tileset.getSubimage(tilesize*x, tilesize*y, tilesize, tilesize);
				}
			}
		} catch (IOException e) {e.printStackTrace();}
	}
	
	
	char[][][] room;
	char[][][] event;
	
	public Map() {
		try {
		File rooms[] = new File("src\\etterichretz\\joel\\game\\gameobjects\\rooms\\").listFiles();
		room = new char[rooms.length][][];
		event = new char[rooms.length][][];
		for(int i=0;i<rooms.length;i++) {
			Scanner scan = new Scanner(rooms[i]);
			String line = scan.nextLine();
			int width=(int)line.charAt(0);
			int height=(int)line.charAt(1);
			int index=2;
			
			room[i] = new char[width][height];
			for(int y=0;y<height;y++) {
				for(int x=0;x<width;x++) {
					room[i][x][y]=line.charAt(x+y*width+index);
					if(room[i][x][y]==6) {
						index++;
					}
					//event[i][x][y]=0;
					if(room[i][x][y]==6) {
						//event[i][x][y]=(char)(line.charAt(x+y*width*index)+1);
					}else if(room[i][x][y]==5) {
						//event[i][x][y]=(char)(10);//10=door
					}
				}
			}
			event[i] = new char[width][height];
			
		}
		}catch(Exception e) {}
	}
	
	@Override
	public void update(float delta) {
		
	}
	
	int curroom = 0;
	
	@Override
	public void draw(Graphics g,double camx,double camy) {
		for(int x=0;x<room[curroom].length;x++) {
			for(int y=0;y<room[curroom][x].length;y++) {
				int tile = (int)room[curroom][x][y];
				if(tile==5||tile==6) {
					tile=1;
				}
				g.drawImage(tiles[tile],(int)(((tilesize*5)*x+camx)+(800-8*5)),(int)(((tilesize*5)*y+camy)+(600-8*5)),tilesize*5,tilesize*5,null);
			}
		}
		
		
		//g.drawImage(tiles[0], (int)(camx+(800/2+4*5)), (int)(camy+(600/2+4*5)), (tilesize*5),(tilesize*5), null);
	}

	public double getEX(int type) {
		// TODO Auto-generated method stub
		return 0;
	}
	public double getEY(int type) {
		// TODO Auto-generated method stub
		return 0;
	}
}
