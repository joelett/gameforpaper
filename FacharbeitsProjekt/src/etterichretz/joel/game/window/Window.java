package etterichretz.joel.game.window;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;

import etterichretz.joel.game.Keyboard;
import etterichretz.joel.game.gameobjects.Gameobject;
import etterichretz.joel.game.gameobjects.Player;

public class Window extends JFrame{
	
	private List<Gameobject> objects=new ArrayList<>();// Siehe Kommentar von Window()
	private Screen screen;// Screen zeichnet die Objekte.
	
	private Player player;
	/**
	 * @param gobj - Ein Array von Gameobjects, die die Fenster-Klasse benötigt um diese zu zeichnen.
	 */
	public Window(Gameobject... gobj) {
		for(int i=0;i<gobj.length;i++) {
			objects.add(gobj[i]);// Der Liste "objects" die Werte zuweisen.
			if(gobj[i] instanceof Player) {
				player=(Player) gobj[i];
			}
		}		
		
		screen = new Screen();
		add(screen);// füge den Screen zum Fenster hinzu.
		
		addKeyListener(new Keyboard());
		
		//Das Fenster einstellen
		setSize(800, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void repaintScreen() {
		screen.repaint();
	}
	
	private class Screen extends JLabel{
		
		/**
		 * Methode zum Zeichnen
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, 800, 600);
			for(Gameobject object : objects) {
				object.draw(g, player.getCamX(), player.getCamY());
			}
		}
	}
}
