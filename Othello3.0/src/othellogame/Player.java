package othellogame;

import java.awt.Color;

public class Player {
	
	String PName = "";
	
	static boolean player1Turn = false; //Default values
	static boolean player2Turn = false; 
			
	public Player(String name) {
		PName = name;
	}
	
	
	public static boolean isColorTurn(Color color){
		boolean isTurn = false;
		if(color == Color.BLACK && player1Turn == true){
			isTurn = true;
			player1Turn = false;
			player2Turn = true;
			//GameRules.possibleMoves(color);
		}
		else if (color == Color.WHITE&& player2Turn == true){
			isTurn = true;
			player1Turn = true;
			player2Turn = false;
			//GameRules.possibleMoves(color);
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


	public void startTurn(boolean turn, Color color) {	//sets the first player to be able to set a piece to BLACK. 
		if(turn = true){
			player1Turn = true;
		}
		
		
	}

}
