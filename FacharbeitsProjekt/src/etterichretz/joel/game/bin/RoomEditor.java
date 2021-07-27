package etterichretz.joel.game.bin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomEditor {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Editor");		
		
		System.out.println("Tiles:");
		System.out.println("Wall=0 Floor=1 Holebegin=2 Hole=3 Holeend=4 Door=5 Spawn(Under is a floor)=6type ");
		List<String> map = new ArrayList<>();
		while(map.size()<0xFF) {
			map.add(scan.nextLine());
			if(map.get(map.size()-1).isEmpty()) {
				map.remove(map.size()-1);
				break;
			}
		}
		try {
		System.out.println("Save room? >");
		if(scan.next().equals("y")) {
			File file = new File("src\\etterichretz\\joel\\game\\gameobjects\\rooms\\");
			BufferedWriter write = new BufferedWriter(new FileWriter(new File(file.getPath()+"\\"+file.listFiles().length+".rf"),Charset.forName("ASCII")));
			char width = 0;
			char height = 0;
			//Annoying Code:
			for(String s:map) {height++;char w = 0;for(int i=0;i<s.length();i++) {if(s.charAt(i)=='6') {i++;}w++;}if(width<w) {width=w;}}
			write.write(width);
			write.write(height);
			for(String s:map) {
				String line="";
				int w=0;
				for(int i=0;i<s.length();i++) {
					line+=(char)(s.charAt(i)-(char)48);
					if(s.charAt(i)=='6') {
						i++;
						line+=(char)(s.charAt(i)-(char)48);
					}
					w++;
				}
				for(int i=0;i<width-w;i++) {
					line+=(char)0;
				}
				System.out.println(line);
				write.write(line);
			}
			write.flush();
		}
		}catch(Exception e) {e.printStackTrace();}
	}
	
}
