package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class Game {
	int empty = 0;
	int black = 1;
	int white = 2;
	static int [][] board = new int [8][8];
	public static void setBoardValues(){ //THIS IS CALLED TO INITUALIZE THE BOARD. HAS TO BE CALLED WHEN GAME LAUNCHED
		board[3][3] = 1;
		board[3][4] = 2;
		board[4][3] = 2;
		board[4][4] = 1;
	}
	
	
	
	public static void keepScore(){		//Used to update the game score.
		int blackPieces = 0;
		int whitePieces = 0;
		for (int i = 0; i<board.length; i++){
		     for (int j = 0; j<board[i].length; j++){
		    	 if (board[i][j] == 1){
		    	   blackPieces += 1;
		    	 }
		    	 else if (board[i][j] == 2){
		    		 whitePieces += 1;
		    	 }
		     } 
		}
		GameUI.scorePass(blackPieces, whitePieces);
	}
	
	
	
	public static void setPieceFlip(int row, int column, int passColor){
		board[row][column] = passColor;
		for (int[] arr : board) {
        System.out.println(Arrays.toString(arr)); //PRINTS OUR ARRAY. USED FOR DEBUGGING.
		}
	}
	//Method used to set pieces
	public static int setPiece(Color col, int i, int j){
		int returnval = 0;
		Color storeCol = col;
		if (storeCol == Color.BLACK){
			
			if (board[i][j] == 1){		//checks if there is already a piece in the spot. Ain't that fancy.
				returnval = 0;
			}
			else if (board[i][j] == 2){
				returnval = 0;
			}
			else{
				if(GameRules.canMove(board, i, j, storeCol) ==  3){// GAMERULE METHOD TO CHECK IF PLACE IS POSSIBLE
					board[i][j] = 1;
					returnval = 1;
				}
			}
		}
		else if (storeCol == Color.WHITE){
			
			if (board[i][j] == 1){
				returnval = 0;
			}
			else if (board[i][j] == 2){
				returnval = 0;
			}
			else{
				if(GameRules.canMove(board, i, j, storeCol) == 3){// GAMERULE METHOD TO CHECK IF PLACE IS POSSIBLE
					board[i][j] = 2;
					returnval = 1;
				}
			}
		}
		Game.keepScore();
		return returnval;
	}
	//Color color1 = Color.BLACK;
	//Color color2 = Color.WHITE;
}
