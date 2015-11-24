package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class Game {
	int empty = 0;
	int black = 1;
	int white = 2;
	static int [][] board = new int [8][8];
	
	
	//Jean-Philippe Lebel
	public void setBoardValues(){ //THIS IS CALLED TO INITUALIZE THE BOARD. HAS TO BE CALLED WHEN GAME LAUNCHED
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
	public static void possibleMoves(Color color){			//this method scans through the board, sending to canMove with not actual piece so that canMove goes to possibleMoveDirections*
		boolean notActualPiece = false;											//it only sends colored pieces and not blank spaces, of course.
		Color colPass = color;
		boolean hasAMove = false;
		for(int row=0; row<board.length; row++){
			for(int col=0; col<board.length; col++){
				if(board[row][col] == 1 || board[row][col] == 2){
					GameRules.canMove(board, row, col, colPass, notActualPiece);
				}
				else if(board[row][col] == 0){
					if(GameRules.isEnd(board, row, col, colPass) == 1){					
						hasAMove = true;								//if isEnd returns true, then the game continues
					}
				}
		   }
		}
		if (hasAMove == false){											//else, hasAMove stays false, triggering stopGame.
			GameRules.stopGame();
		}
		
	}
	
	
	
	
	//Jean-Philippe Lebel
	public static void setPieceFlip(int row, int column, int passColor){
		board[row][column] = passColor;
		
		for (int[] arr : board) {
        System.out.println(Arrays.toString(arr)); //PRINTS OUR ARRAY. USED FOR DEBUGGING. Also looks nice in console.
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
			if(color == Color.BLACK && player1Turn == true){
				isTurn = true;
					player1Turn = false;
					player2Turn = true;
					Game.updateColors();							//clears the board of previous possible moves
			}
			else if (color == Color.WHITE && player2Turn == true){
				isTurn = true;
					player1Turn = true;
					player2Turn = false;
					Game.updateColors();
				
			}
			return isTurn;
		
	}
	
	//Jean-Philippe Lebel
	public static void switchCol(Color col){		//actually switches colors, and sets game label to have a * next to current player
			if(col == Color.BLACK){
				GameUI.colorPass(Color.WHITE);
				GameUI.turnLablePass(Color.WHITE);
				System.out.println("It is now White's turn");
				Game.possibleMoves(Color.WHITE); //displays possible moves for player.
			}
			else if(col == Color.WHITE){
				GameUI.colorPass(Color.BLACK);
				GameUI.turnLablePass(Color.BLACK);
				System.out.println("It is now Black's turn");
				Game.possibleMoves(Color.BLACK);
			}
	}

	public static void player1Turn(boolean bool) {
		player1Turn = true;
	}
}
