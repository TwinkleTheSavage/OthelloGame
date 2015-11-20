package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class Game {
	int empty = 0;
	int black = 1;
	int white = 2;
	static int [][] board = new int [8][8];
	//Jean-Philippe Lebel
	public static void setBoardValues(){ //THIS IS CALLED TO INITUALIZE THE BOARD. HAS TO BE CALLED WHEN GAME LAUNCHED
		for (int i = 0; i<board.length; i++){
		     for (int j = 0; j<board[i].length; j++){
		    	  board[i][j] = 0;
		     }
		}
		board[3][3] = 1;
		board[3][4] = 2;
		board[4][3] = 2;
		board[4][4] = 1;
	}
	
	//Jean-Philippe Lebel
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
	//Jean-Philippe Lebel
	public static void updateColors(){					//method to update game board
		for (int i = 0; i<board.length; i++){
		     for (int j = 0; j<board.length; j++){
		    	 if (board[i][j] == 1){
		    		 GameUI.setColor(i, j, Color.BLACK);
		    	 }
		    	 else if(board[i][j] == 2){
		    		 GameUI.setColor(i, j, Color.WHITE);
		    	 }
		    	 else if (board[i][j] == 0){
		    		 GameUI.setColor(i, j, null);
		    	 }
		     }
		}
	}
	
	//Jean-Philippe Lebel
	public static boolean possibleMoves(Color color){
		boolean notActualPiece = false;
		boolean continueGame = false;
		Color colPass = color;
		for(int row=0; row<board.length; row++){
		   for(int col=0; col<board.length; col++){
			   if(board[row][col] == 1 || board[row][col] == 2){
				   if (GameRules.canMove(board, row, col, colPass, notActualPiece) == true){    
					   continueGame = true;
				   }
			   }
		   }
		}
		return continueGame;
	}
	
	
	
	
	//Jean-Philippe Lebel
	public static void setPieceFlip(int row, int column, int passColor){
		board[row][column] = passColor;
		for (int[] arr : board) {
        System.out.println(Arrays.toString(arr)); //PRINTS OUR ARRAY. USED FOR DEBUGGING.
		}
		System.out.println("\n");
	}

	//Method used to set pieces
	//Jean-Philippe Lebel
	public static boolean setPiece(Color col, int i, int j){
		boolean actualPiece = true;
		boolean returnval = false;
		Color storeCol = col;
		if (storeCol == Color.BLACK){
			
			if (board[i][j] == 1){		//checks if there is already a piece in the spot. 1 being the value used for black in the array, and 2 the value for white
				returnval = false;
			}
			else if (board[i][j] == 2){
				returnval = false;
			}
			else{
				if(GameRules.canMove(board, i, j, storeCol, actualPiece) ==  true){// GAMERULE METHOD TO CHECK IF PLACE IS POSSIBLE
					board[i][j] = 1;
					returnval = true;
				}
			}
		}
		else if (storeCol == Color.WHITE){
			
			if (board[i][j] == 1){
				returnval = false;
			}
			else if (board[i][j] == 2){
				returnval = false;
			}
			else{
				if(GameRules.canMove(board, i, j, storeCol, actualPiece) == true){// GAMERULE METHOD TO CHECK IF PLACE IS POSSIBLE
					board[i][j] = 2;
					returnval = true;
				}
			}
		}
		Game.keepScore();
		return returnval;
	}
	
	
	
	
	//Jean-Philippe Lebel
	static boolean player1Turn = false; //Default values
	static boolean player2Turn = false; 
	public static boolean isColorTurn(Color color){		//used to switch turns between players
		boolean isTurn = false;
		//if(Game.possibleMoves(Color.BLACK) == true || Game.possibleMoves(Color.WHITE) == true){				//still working on win condition.
			if(color == Color.BLACK && player1Turn == true){
				isTurn = true;
					player1Turn = false;
					player2Turn = true;
					Game.updateColors(); //clears the board of previous possible moves
					Game.possibleMoves(Color.WHITE); //shows possible moves for current player color
				}
				else if (color == Color.WHITE&& player2Turn == true){
				isTurn = true;
				player1Turn = true;
				player2Turn = false;
				Game.updateColors();
				Game.possibleMoves(Color.BLACK);
			}
		//}
		else{
			GameRules.stopGame();
		}
			
			
		return isTurn;
		
	}
	
	//Jean-Philippe Lebel
	public static void switchCol(Color col){		//actually switches colors, and sets game label to have a * next to current player
			if(col == Color.BLACK){
				GameUI.colorPass(Color.WHITE);
				GameUI.turnLablePass(Color.WHITE);
				System.out.println("It is now White's turn");
			}
			else if(col == Color.WHITE){
				GameUI.colorPass(Color.BLACK);
				GameUI.turnLablePass(Color.BLACK);
				System.out.println("It is now Black's turn");
			}
	}

	public static void player1Turn(boolean bool) {
		player1Turn = true;
	}
	
	
}
