package othellogame;

import java.awt.Color;

public class Player {
	
	static String PName;
	static Color Pcolor;
	
	
	
	
	public static String getPName(){
		return PName;
	}
	public static Color getPcolor(){
		return Pcolor;
	}
			
	public Player(String name, Color color) {
		Player.PName = name;
		Player.Pcolor = color;
	}
	
	public void startTurn(boolean turn, Color color) {	//sets the first player to be able to set a piece to BLACK. 
		if(turn = true){
			Game.player1Turn(true);
		}	
	}

}
