package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class GameRules {
	
	
	
	
	//METHOD TO CHECK IF CAN PLACE PIECE
	//This checks adjacent values first, to see if you can place a piece of another color next to it, the searches deeper to see if there's a piece of the same color at the end. 
	//This method is reused by two main rules: possibleMoves and setPiece
	//Jean-Philippe Lebel
	public static boolean canMove(int[][] temparray, int i, int j, Color temp, boolean isActualPiece){
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
				//System.out.println("Returnval is " + returnval); //debugging
				return returnval;	//returns either true, or false, depending if any direction works
				
	}
	
	
	//Method to flip pieces, depending on what direction sent by canMove
	//Jean-Philippe Lebel
	public static void flipPiecesRight(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Right
				for(int column = j+1; column < 8; column++){			//scans in the direction called, until it hits a piece of the same color, breaking once it does.
					if (Game.board[i][column] == colorNum) break;		//this is the same for all 8 directional methods.
					else{
						GameUI.setColor(i, column, color);
						Game.setPieceFlip(i, column, colorNum);
					}
				}
	}
	public static void flipPiecesLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Left
			for(int column = j-1; column > -1; column--){
				if (Game.board[i][column] == colorNum) break;
				else{
					GameUI.setColor(i, column, color);
					Game.setPieceFlip(i, column, colorNum);
				}
			}
	}
	public static void flipPiecesUp(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Up
			for(int row = i-1; row >-1; row--){
				if (Game.board[row][j] == colorNum) break;
				else{
					GameUI.setColor(row, j, color);
					Game.setPieceFlip(row, j, colorNum);
				}
			}
		}
	public static void flipPiecesDown(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//Down
			for(int row = i+1; row < 8; row++){
				if (Game.board[row][j] == colorNum) break;
				else{
					GameUI.setColor(row, j, color);
					Game.setPieceFlip(row, j, colorNum);
				}
			}
		}
		//DIAGONALS
	public static void flipPiecesUpLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//up/left	
			for(int row = i, column = j; row > -1 && column > -1; row--, column--){		
					if (Game.board[row][column] == colorNum){
						break;
					}
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);
					}
			}	
		}
	public static void flipPiecesDownRight(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//down/right	
			for(int row = i, column = j; row < 8 && column < 8; row++, column++){		
					if (Game.board[row][column] == colorNum){ 
						break;
					}
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);
					}
			}	
		}
	public static void flipPiecesDownLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//down/left	
			for(int row = i, column = j; row < 8 && column > -1; row++, column--){		
					if (Game.board[row][column] == colorNum){
						break;
					}
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);	
					}
			}	
		}
		public static void flipPiecesUpRight(int i, int j, Color colorPass, int colorNum){
			Color color = colorPass; //up/right	
			for(int row = i, column = j; row > -1 && column < 8; row--, column++){		
					if (Game.board[row][column] == colorNum){
						break;
					}
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);	
					}
			}	
		}	
	
	
	
	
		
		
		
	//Possible moves updates
		public static void possibleShowRight(int i, int j, int colorNum){//Right
			
			for(int column = j+1; column < 8; column++){				
				if (Game.board[i][column] == colorNum){		
					break;
				}
				else if (Game.board[i][column] == 0){									//this scans until it hits an empty space, placing a grey marker there, and breaking.
					GameUI.setColor(i, column, Color.GRAY);
					break;
				}
			}
		}
		public static void possibleShowLeft(int i, int j, int colorNum){				//Left
			for(int column = j-1; column > -1; column--){
				if (Game.board[i][column] == colorNum){
					break;
				}
				else if (Game.board[i][column] == 0){
					GameUI.setColor(i, column, Color.GRAY);
					break;
				}
			}
		}
		public static void possibleShowUp(int i, int j, int colorNum){					//Up
			for(int row = i-1; row >-1; row--){
				if (Game.board[row][j] == colorNum){
					break;
				}
				else if (Game.board[row][j] == 0){
					GameUI.setColor(row, j, Color.GRAY);
					break;
				}
			}
		}
		public static void possibleShowDown(int i, int j, int colorNum){					//Down
			for(int row = i+1; row < 8; row++){
				if (Game.board[row][j] == colorNum){
					break;
				}
				else if (Game.board[row][j] == 0){
					GameUI.setColor(row, j, Color.GRAY);
					break;
				}
			}
		}
	//DIAGONALS
		public static void possibleShowUpLeft(int i, int j, int colorNum){			//up/left
			if(i-1 != -1 && j-1 != -1){
				for(int row = i-1, column = j-1; row > -1 && column > -1; row--, column--){
					if (Game.board[row][column] == colorNum){
						break;
					}
					else if (Game.board[row][column] == 0){
						GameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}
			}
		}
		public static void possibleShowDownRight(int i, int j, int colorNum){		//down/right	
			if(i+1 != 8 && j+1 != 8){
				for(int row = i+1, column = j+1; row < 8 && column < 8; row++, column++){
					if (Game.board[row][column] == colorNum){
						break;
					}
					else if (Game.board[row][column] == 0){
						GameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}
			}
		}
		public static void possibleShowDownLeft(int i, int j, int colorNum){		//down/left	
			if(i+1 != 8 && j-11 != -1){
				for(int row = i+1, column = j-1; row < 8 && column > -1; row++, column--){
					if (Game.board[row][column] == colorNum){
						break;
					}
					else if (Game.board[row][column] == 0){
						GameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}	
			}
		}
		public static void possibleShowUpRight(int i, int j, int colorNum){		//up/right
			if(i-1 != -1 && j+1 != 8){
				for(int row = i-1, column = j+1; row > -1 && column < 8; row--, column++){		
					if (Game.board[row][column] == colorNum){
						break;
					}
					else if (Game.board[row][column] == 0){
						GameUI.setColor(row, column, Color.GRAY);
						break;
					}
				}
			}
		}	
	
		//Jean-Philippe Lebel
		public static int isEnd(int[][] temparray, int i, int j, Color temp){ //this essentially does the same thing as canMove, except it looks to see if there's an available move, without calling anything
			boolean returnvalR = false;										  //it's also a little different in what it returns and works, validating its existence. I hope.
			boolean returnvalL = false;
			boolean returnvalU = false;
			boolean returnvalD = false;
			boolean returnvalRU = false;
			boolean returnvalRD = false;
			boolean returnvalLU = false;									//I'll explain how it works up here. It's simpler that way
			boolean returnvalLD = false;									//if any of the directions for a 0 value work on the board, it sets it's corresponding value to true	
																			//if any one value is true, it'll return true for the entire method, meaning that the game still has possible moves.
																			//else, if no direction works then it returns false
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
					for(int column = j; column < 8; column++){			
						if (temparray[row][column] == passingColorID){				
							returnvalR = true;				
						}	//Looks right	
					}		
				}															
				if(j-1 != -1 && temparray[i][j-1] == checkingColorID){			
					int row = i;
					for(int column = j; column > -1; column--){
						if (temparray[row][column] == passingColorID){
								returnvalL = true;
						}	//Looks left	
					}							
				}														
				if(i-1 != -1 && temparray[i-1][j] == checkingColorID){				
					int column = j;										
					for(int row = i; row >-1; row--){					
						if (temparray[row][column] == passingColorID){				
							returnvalU = true;
						}	//Looks up	
					}								
				}											
				if(i+1 != 8 && temparray[i+1][j] == checkingColorID){			
					int column = j;
					for(int row = i; row < 8; row++){
						if (temparray[row][column] == passingColorID){
							returnvalD = true;	
						}		//Looks down
					}
				}	
					//DIAGONALS														
					if(i-1 != -1 && j-1 != -1 && temparray[i-1][j-1] == checkingColorID){			
						for(int row = i, column = j; row > -1 && column > -1; row--, column--){				
								if (temparray[row][column] == passingColorID){
									returnvalLU = true;
								}		//Looks up/left
						}
					}
					if(i+1 != 8 && j+1 != 8 && temparray[i+1][j+1] == checkingColorID){
						for(int row = i, column = j; row < 8 && column < 8; row++, column++){
								if (temparray[row][column] == passingColorID){
									returnvalRD = true;
								}		//Looks down/right
						}
					}
					if(i+1 != 8 && j-1 != -1 && temparray[i+1][j-1] == checkingColorID){
						for(int row = i, column = j; row < 8 && column > -1; row++, column--){
								if (temparray[row][column] == passingColorID){
									returnvalLD = true;
							}		//Looks down/left
						}
					}
					if(i-1 != -1 && j+1 != 8 && temparray[i-1][j+1] == checkingColorID){
						for(int row = i, column = j; row > -1 && column < 8; row--, column++){
								if (temparray[row][column] == passingColorID){
									returnvalRU = true;
							}		//Looks up/right
						}
					}	
					if(returnvalR == true || returnvalL == true || returnvalU == true || returnvalD == true || returnvalLU == true ||returnvalRU == true || returnvalLD == true || returnvalRD){
						return 1;
					}
					else{
						return 0;
					}
			
						//returns either true, or false, depending if any direction works
					
		}
		
		
		
		
		
		
		
	public static void stopGame(){
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
