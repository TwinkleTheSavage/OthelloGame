package othellogame;

import java.awt.Color;

public class Player {
	
	String PName = "";
	
	static boolean player1Turn = true; //Default values
	static boolean player2Turn = false;
	static Color pColor = Color.BLACK; 
			
	public Player(String name) {
		PName = name;
	}
	
	
	public static boolean isColorTurn(Color color){
		boolean isTurn = false;
		if(color == Color.BLACK && player1Turn == true){
			isTurn = true;
			player1Turn = false;
			player2Turn = true;
		}
		else if (color == Color.WHITE&& player2Turn == true){
			isTurn = true;
			player1Turn = true;
			player2Turn = false;
		}
		return isTurn;
	}
	
	public static void switchCol(Color col){
		if(col == Color.BLACK){
			GameUI.colorPass(Color.WHITE);
			System.out.println("It is now White's turn");
		}
		else if(col == Color.WHITE){
			GameUI.colorPass(Color.BLACK);
			System.out.println("It is now Black's turn");
		}
	}
	
	public static void main(String[] args) {	
	}
}
