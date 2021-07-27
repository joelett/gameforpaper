package etterichretz.joel.game;

import etterichretz.joel.game.gameobjects.Map;
import etterichretz.joel.game.gameobjects.Player;
import etterichretz.joel.game.window.Window;

public class Game {
	
	public static void main(String[] args) {
		//Initialization of Gameobjects
		Map map = new Map();
		Player player = new Player(map);
		
		//Initialization of Windowobject
		Window window = new Window(map,player);//Das Window objekt
		
		//Starttime
		long lastTime = System.currentTimeMillis(); //This variable is important for the calculation of delta, a variable that is needed, so nothing moves faster because of different FPS.
		
		//Main Loop
		while(true) {
			//Calculation of Delta
			long currentTime = System.currentTimeMillis();//Current time. (Last time will be subtracted off of this).
			float delta = (currentTime-lastTime)/1000f+0.0000001f;
			lastTime=currentTime; // Zurücksetzen von "lastTime"
			
			//Updating Gameobjects
			map.update(delta);
			player.update(delta);
			
			//Updating Screen
			window.repaintScreen();
			
		}
	}

}
