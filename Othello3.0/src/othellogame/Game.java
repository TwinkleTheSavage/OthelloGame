package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class Game {
	
	String name;
	int empty = 0;
	int black = 1;
	int white = 2;
	int [][] board = new int [8][8];
	
	GameUI gameUI;
	GameUI gameUI2;
	
	public Game(String name){
		name = this.name;
		this.setBoardValues();
	}
	
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
	
	
	public void showGameUICreator(){
		
		gameUI = new GameUI(this);
		gameUI.setVisible(true);
	}
	
	public void showGameUIJoiner(){
		
	}
	
	
	//Jean-Philippe Lebel
	public void keepScore(){		//Used to update the game score.
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
	public void updateColors(){					//method to update game board
		for (int i = 0; i<board.length; i++){
		     for (int j = 0; j<board.length; j++){
		    	 if (board[i][j] == 1){
		    		 gameUI.setColor(i, j, Color.BLACK);
		    	 }
		    	 else if(board[i][j] == 2){
		    		 gameUI.setColor(i, j, Color.WHITE);
		    	 }
		    	 else if (board[i][j] == 0){
		    		 gameUI.setColor(i, j, null);
		    	 }
		     }
		}
	}
	
	//Jean-Philippe Lebel
	public boolean possibleMoves(Color color){
		boolean notActualPiece = false;
		boolean continueGame = false;
		Color colPass = color;
		for(int row=0; row<board.length; row++){
		   for(int col=0; col<board.length; col++){
			   if(board[row][col] == 1 || board[row][col] == 2){
				   if (this.canMove(board, row, col, colPass, notActualPiece) == true){    
					   continueGame = true;
				   }
			   }
		   }
		}
		return continueGame;
	}
	
	
	
	
	//Jean-Philippe Lebel
	public void setPieceFlip(int row, int column, int passColor){
		board[row][column] = passColor;
		for (int[] arr : board) {
        System.out.println(Arrays.toString(arr)); //PRINTS OUR ARRAY. USED FOR DEBUGGING.
		}
		System.out.println("\n");
	}

	//Method used to set pieces
	//Jean-Philippe Lebel
	public boolean setPiece(Color col, int i, int j){
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
				if(this.canMove(board, i, j, storeCol, actualPiece) ==  true){// GAMERULE METHOD TO CHECK IF PLACE IS POSSIBLE
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
				if(this.canMove(board, i, j, storeCol, actualPiece) == true){// GAMERULE METHOD TO CHECK IF PLACE IS POSSIBLE
					board[i][j] = 2;
					returnval = true;
				}
			}
		}
		this.keepScore();
		return returnval;
	}
	
	
	
	
	//Jean-Philippe Lebel
	static boolean player1Turn = false; //Default values
	static boolean player2Turn = false; 
	public boolean isColorTurn(Color color){		//used to switch turns between players
		boolean isTurn = false;
		//if(this.possibleMoves(Color.BLACK) == true || this.possibleMoves(Color.WHITE) == true){				//still working on win condition.
			if(color == Color.BLACK && player1Turn == true){
				isTurn = true;
					player1Turn = false;
					player2Turn = true;
					this.updateColors(); //clears the board of previous possible moves
					this.possibleMoves(Color.WHITE); //shows possible moves for current player color
				}
				else if (color == Color.WHITE&& player2Turn == true){
				isTurn = true;
				player1Turn = true;
				player2Turn = false;
				this.updateColors();
				this.possibleMoves(Color.BLACK);
			}
		//}
		else{
			this.stopGame();
		}
			
			
		return isTurn;
		
	}
	
	//Jean-Philippe Lebel
	public void switchCol(Color col){		//actually switches colors, and sets game label to have a * next to current player
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

	public void player1Turn(boolean bool) {
		player1Turn = true;
	}
	
	//METHOD TO CHECK IF CAN PLACE PIECE
	//This checks adjacent values first, to see if you can place a piece of another color next to it, the searches deeper to see if there's a piece of the same color at the end. 
	//This method is reused by three main rules: possibleMoves, isEndGame and setPiece
	//Jean-Philippe Lebel
	
	public boolean canMove(int[][] temparray, int i, int j, Color temp, boolean isActualPiece){
		boolean actualPiece = isActualPiece;
		boolean returnval = false;
		int passingColorID = 0;
		int checkingColorID = 0;
		if(temp == Color.BLACK){
			passingColorID = 1;
			checkingColorID = 2;
		}
		else if (temp == Color.WHITE){
			passingColorID = 2;
			checkingColorID = 1;
		}
		
				if(j+1 != 8 && temparray[i][j+1] == checkingColorID){					 					 
					int row = i;				
					for(int column = j; column < 8; column++){			//scans through direction to see if there is a piece of the same color in the direction, starting from the piece clicked, moving in the direction described
						if (temparray[row][column] == passingColorID){				//if there is, then the piece can be placed there
							returnval = true;				
							if(actualPiece == true)						//if a piece is actually being placed, calls method to flip the pieces in between the two
								flipPiecesRight(i, j, temp, passingColorID);
							else if (actualPiece == false)				//if a piece is not being placed, but displayed to see if it can be placed there
								possibleShowRight(i, j, passingColorID);
						}	//Looks right	
					}		
				}															
				if(j-1 != -1 && temparray[i][j-1] == checkingColorID){			
					int row = i;
					for(int column = j; column > -1; column--){
						if (temparray[row][column] == passingColorID){
							returnval = true;
							if(actualPiece == true)
								flipPiecesLeft(i, j, temp, passingColorID);
							else if (actualPiece == false)
								possibleShowLeft(i, j, passingColorID);
							
						}	//Looks left	
					}							
				}														
				if(i-1 != -1 && temparray[i-1][j] == checkingColorID){				
					int column = j;										
					for(int row = i; row >-1; row--){					
						if (temparray[row][column] == passingColorID){				
							returnval = true;
							if(actualPiece == true)
								flipPiecesUp(i, j, temp, passingColorID);
							else if (actualPiece == false)
								possibleShowUp(i, j, passingColorID);
							
						}	//Looks up	
					}								
				}											
				if(i+1 != 8 && temparray[i+1][j] == checkingColorID){			
					int column = j;
					for(int row = i; row < 8; row++){
						if (temparray[row][column] == passingColorID){
							returnval = true;
							if(actualPiece == true)
								flipPiecesDown(i, j, temp, passingColorID);
							else if (actualPiece == false)
								possibleShowDown(i, j, passingColorID);
							
						}	//Looks down
					}
				}	
				//DIAGONALS														
				if(i-1 != -1 && j-1 != -1 && temparray[i-1][j-1] == checkingColorID){			
					for(int row = i, column = j; row > -1 && column > -1; row--, column--){				
							if (temparray[row][column] == passingColorID){
								returnval = true;
								if(actualPiece == true)
									flipPiecesUpLeft(i, j, temp, passingColorID);
								else if (actualPiece == false)
									possibleShowUpLeft(i, j, passingColorID);
							}		//Looks up/left
					}
				}
				if(i+1 != 8 && j+1 != 8 && temparray[i+1][j+1] == checkingColorID){
					for(int row = i, column = j; row < 8 && column < 8; row++, column++){
							if (temparray[row][column] == passingColorID){
								returnval = true;
								if(actualPiece == true)
									flipPiecesDownRight(i, j, temp, passingColorID);
								else if (actualPiece == false)
									possibleShowDownRight(i, j, passingColorID);
							}		//Looks down/right
					}
				}
				if(i+1 != 8 && j-1 != -1 && temparray[i+1][j-1] == checkingColorID){
					for(int row = i, column = j; row < 8 && column > -1; row++, column--){
							if (temparray[row][column] == passingColorID){
								returnval = true;
								if(actualPiece == true)
									flipPiecesDownLeft(i, j, temp, passingColorID);
								else if (actualPiece == false)
									possibleShowDownLeft(i, j, passingColorID);
						}		//Looks down/left
					}
				}
				if(i-1 != -1 && j+1 != 8 && temparray[i-1][j+1] == checkingColorID){
					for(int row = i, column = j; row > -1 && column < 8; row--, column++){
							if (temparray[row][column] == passingColorID){
								returnval = true;
								if(actualPiece == true)
									flipPiecesUpRight(i, j, temp, passingColorID);
								else if (actualPiece == false)
									possibleShowUpRight(i, j, passingColorID);
						}		//Looks up/right
					}
				}		
	return returnval;	//returns either true, or false, depending if any direction works
	}
	
	
	//Method to flip pieces, depending on what direction sent by canMove
	//Jean-Philippe Lebel
	public void flipPiecesRight(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Right
				for(int column = j+1; column < 8; column++){			//scans in the direction called, until it hits a piece of the same color, breaking once it does.
					if (this.board[i][column] == colorNum) break;		//this is the same for all 8 directional methods.
					else{
						gameUI.setColor(i, column, color);
						this.setPieceFlip(i, column, colorNum);
					}
				}
	}
	public void flipPiecesLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Left
			for(int column = j-1; column > -1; column--){
				if (this.board[i][column] == colorNum) break;
				else{
					gameUI.setColor(i, column, color);
					this.setPieceFlip(i, column, colorNum);
				}
			}
	}
	public void flipPiecesUp(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Up
			for(int row = i-1; row >-1; row--){
				if (this.board[row][j] == colorNum) break;
				else{
					gameUI.setColor(row, j, color);
					this.setPieceFlip(row, j, colorNum);
				}
			}
		}
	public void flipPiecesDown(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Down
			for(int row = i+1; row < 8; row++){
				if (this.board[row][j] == colorNum) break;
				else{
					gameUI.setColor(row, j, color);
					this.setPieceFlip(row, j, colorNum);
					System.out.println(row + " " + j);
				}
			}
		}
		//DIAGONALS
	public void flipPiecesUpLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//up/left	
			for(int row = i, column = j; row > -1 && column > -1; row--, column--){		
					if (this.board[row][column] == colorNum){
						break;
					}
					else{
						gameUI.setColor(row, column, color);
						this.setPieceFlip(row, column, colorNum);
						System.out.println(row + " " + j);
					}
			}	
		}
	public void flipPiecesDownRight(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//down/right	
			for(int row = i, column = j; row < 8 && column < 8; row++, column++){		
					if (this.board[row][column] == colorNum){ 
						break;
					}
					else{
						gameUI.setColor(row, column, color);
						this.setPieceFlip(row, column, colorNum);

					}
			}	
		}
	public void flipPiecesDownLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//down/left	
			for(int row = i, column = j; row < 8 && column > -1; row++, column--){		
					if (this.board[row][column] == colorNum){
						break;
					}
					else{
						gameUI.setColor(row, column, color);
						this.setPieceFlip(row, column, colorNum);	
					}
			}	
		}
		public void flipPiecesUpRight(int i, int j, Color colorPass, int colorNum){
			Color color = colorPass; //up/right	
			for(int row = i, column = j; row > -1 && column < 8; row--, column++){		
					if (this.board[row][column] == colorNum){
						break;
					}
					else{
						gameUI.setColor(row, column, color);
						this.setPieceFlip(row, column, colorNum);	
					}
			}	
		}	
	
	
	
	
		
		
		
	//Possible moves updates
		public void possibleShowRight(int i, int j, int colorNum){//Right
			
			for(int column = j+1; column < 8; column++){				
				if (this.board[i][column] == colorNum){		
					break;
				}
				else if (this.board[i][column] == 0){									//this scans until it hits an empty space, placing a grey marker there, and breaking.
					gameUI.setColor(i, column, Color.GRAY);
					break;
				}
			}
		}
		public void possibleShowLeft(int i, int j, int colorNum){				//Left
			for(int column = j-1; column > -1; column--){
				if (this.board[i][column] == colorNum){
					break;
				}
				else if (this.board[i][column] == 0){
					gameUI.setColor(i, column, Color.GRAY);
					break;
				}
			}
		}
		public void possibleShowUp(int i, int j, int colorNum){					//Up
			for(int row = i-1; row >-1; row--){
				if (this.board[row][j] == colorNum){
					break;
				}
				else if (this.board[row][j] == 0){
					gameUI.setColor(row, j, Color.GRAY);
					break;
				}
			}
		}
		public void possibleShowDown(int i, int j, int colorNum){					//Down
			for(int row = i+1; row < 8; row++){
				if (this.board[row][j] == colorNum){
					break;
				}
				else if (this.board[row][j] == 0){
					gameUI.setColor(row, j, Color.GRAY);
					break;
				}
			}
		}
	//DIAGONALS
		public void possibleShowUpLeft(int i, int j, int colorNum){			//up/left
			if(i-1 != -1 && j-1 != -1){
				for(int row = i-1, column = j-1; row > -1 && column > -1; row--, column--){
					if (this.board[row][column] == colorNum){
						break;
					}
					else if (this.board[row][column] == 0){
						gameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}
			}
		}
		public void possibleShowDownRight(int i, int j, int colorNum){		//down/right	
			if(i+1 != 8 && j+1 != 8){
				for(int row = i+1, column = j+1; row < 8 && column < 8; row++, column++){
					if (this.board[row][column] == colorNum){
						break;
					}
					else if (this.board[row][column] == 0){
						gameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}
			}
		}
		public void possibleShowDownLeft(int i, int j, int colorNum){		//down/left	
			if(i+1 != 8 && j-11 != -1){
				for(int row = i+1, column = j-1; row < 8 && column > -1; row++, column--){
					if (this.board[row][column] == colorNum){
						break;
					}
					else if (this.board[row][column] == 0){
						gameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}	
			}
		}
		public void possibleShowUpRight(int i, int j, int colorNum){		//up/right
			if(i-1 != -1 && j+1 != 8){
				for(int row = i-1, column = j+1; row > -1 && column < 8; row--, column++){		
					if (this.board[row][column] == colorNum){
						break;
					}
					else if (this.board[row][column] == 0){
						gameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}
			}
		}	
		
		/*
	
		public void main(String[] args){
			newGameUI();
		}
		*/
	
	public void stopGame(){
		System.out.println("Black's score is: ");
		System.out.println(GameUI.getBlackScore());
		System.out.println("White's score is: ");
		System.out.println(GameUI.getWhiteScore());
		int bScore = Integer.parseInt(GameUI.getBlackScore());
		int wScore = Integer.parseInt(GameUI.getWhiteScore());
		System.out.println("");
		if (bScore == wScore){
			System.out.println("The game is a tie!");
		}
		else if (bScore > wScore){
			System.out.println("The Black player won");
		}
		else{
			System.out.println("The White player won");
		}
		System.out.println("");
		System.out.println("You may now quit and play another game. Or get some snacks.");
	}
	
}
	

