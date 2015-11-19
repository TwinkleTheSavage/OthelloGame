package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class GameRules {
	
	
	
	
	//METHOD TO CHECK IF CAN PLACE PIECE
	//This checks adjacent values first, to see if you can place a piece of another color next to it, the searches deeper to see if there's a piece of the same color at the end. 
	//Jean-Philippe Lebel
	public static boolean canMove(int[][] temparray, int i, int j, Color temp, boolean isActualPiece){
		boolean actualPiece = isActualPiece;
		boolean returnval = false;
		if(temp == Color.BLACK){																										
				if(j+1 != 8 && temparray[i][j+1] == 2){					 //This version checks for adjacent WHITE squares, hence == 2					 
					int row = i;				
					for(int column = j; column < 8; column++){			//scans through direction to see if there is a piece of the same color in the direction, starting from the piece clicked, moving in the direction described
						if (temparray[row][column] == 1){				//if there is, then the piece can be placed there
							returnval = true;				
							if(actualPiece == true)						//if a piece is actually being placed, calls method to flip the pieces in between the two
								flipPiecesRight(i, j, temp, 1);
							else if (actualPiece == false)				//if a piece is not being placed, but displayed to see if it can be placed there
								possibleShowRight(i, j, temp);
						}	//Looks right	
					}		
				}															
				if(j-1 != -1 && temparray[i][j-1] == 2){			
					int row = i;
					for(int column = j; column > -1; column--){
						if (temparray[row][column] == 1){
							returnval = true;
							if(actualPiece == true)
								flipPiecesLeft(i, j, temp, 1);
							else if (actualPiece == false)
								possibleShowLeft(i, j, temp);
							
						}	//Looks left	
					}							
				}														
				if(i-1 != -1 && temparray[i-1][j] == 2){				
					int column = j;										
					for(int row = i; row >-1; row--){					
						if (temparray[row][column] == 1){				
							returnval = true;
							if(actualPiece == true)
								flipPiecesUp(i, j, temp, 1);
							else if (actualPiece == false)
								possibleShowUp(i, j, temp);
							
						}	//Looks up	
					}								
				}											
				if(i+1 != 8 && temparray[i+1][j] == 2){			
					int column = j;
					for(int row = i; row < 8; row++){
						if (temparray[row][column] == 1){
							returnval = true;
							if(actualPiece == true)
								flipPiecesDown(i, j, temp, 1);
							else if (actualPiece == false)
								possibleShowDown(i, j, temp);
							
						}	//Looks down
					}
				}	
				//DIAGONALS														
				if(i-1 != -1 && j-1 != -1 && temparray[i-1][j-1] == 2){			
					for(int row = i, column = j; row > -1 && column > -1; row--, column--){				
							if (temparray[row][column] == 1){
								returnval = true;
								if(actualPiece == true)
									flipPiecesUpLeft(i, j, temp, 1);
								else if (actualPiece == false)
									possibleShowUpLeft(i, j, temp);
								
								
							}		//Looks up/left
						
					}
				}
				if(i+1 != 8 && j+1 != 8 && temparray[i+1][j+1] == 2){
					for(int row = i, column = j; row < 8 && column < 8; row++, column++){
							if (temparray[row][column] == 1){
								returnval = true;
								if(actualPiece == true)
									flipPiecesDownRight(i, j, temp, 1);
								else if (actualPiece == false)
									possibleShowDownRight(i, j, temp);
								
								
							}		//Looks down/right
					}
				}
				if(i+1 != 8 && j-1 != -1 && temparray[i+1][j-1] == 2){
					for(int row = i, column = j; row < 8 && column > -1; row++, column--){
							if (temparray[row][column] == 1){
								returnval = true;
								if(actualPiece == true)
									flipPiecesDownLeft(i, j, temp, 1);
								else if (actualPiece == false)
									possibleShowDownLeft(i, j, temp);
						}		//Looks down/left
					}
				}
				if(i-1 != -1 && j+1 != 8 && temparray[i-1][j+1] == 2){
					for(int row = i, column = j; row > -1 && column < 8; row--, column++){
							if (temparray[row][column] == 1){
								returnval = true;
								if(actualPiece == true)
									flipPiecesUpRight(i, j, temp, 1);
								else if (actualPiece == false)
									possibleShowUpRight(i, j, temp);
						}		//Looks up/right
					}
				}	
		}	
		else if (temp == Color.WHITE){											// the && are to make sure search doesn't go out of bound
			if(j+1 != 8 && temparray[i][j+1] == 1){					 			//This version checks for adjacent BLACK squares, hence == 1					 
				int row = i;													//Methodlogy is the same than for black pieces
				for(int column = j; column < 8; column++){
					if (temparray[row][column] == 2){
						returnval = true;
						if(actualPiece == true)
							flipPiecesRight(i, j, temp, 2);
						else if (actualPiece == false)
							possibleShowRight(i, j, temp);
				
					}	//Looks right	
				}		
			}
				
				if(j-1 != -1 && temparray[i][j-1] == 1){
					int row = i;
					for(int column = j; column > -1; column--){
						if (temparray[row][column] == 2){
							returnval = true;
							if(actualPiece == true)
								flipPiecesLeft(i, j, temp, 2);
							else if (actualPiece == false)
								possibleShowLeft(i, j, temp);
							
						}	//Looks left	
					}	
				}
				
				if(i-1 != -1 && temparray[i-1][j] == 1){
					int column = j;							
					for(int row = i; row >-1; row--){		
						if (temparray[row][column] == 2){
							returnval = true;
							if(actualPiece == true)
								flipPiecesUp(i, j, temp, 2);
							else if (actualPiece == false)
								possibleShowUp(i, j, temp);
							
						}	//Looks up
					}	
				}
				if(i+1 != 8 && temparray[i+1][j] == 1){
					int column = j;
					for(int row = i; row < 8; row++){
						if (temparray[row][column] == 2){
							returnval = true;
							if(actualPiece == true)
								flipPiecesDown(i, j, temp, 2);
							else if (actualPiece == false)
								possibleShowDown(i, j, temp);
						}	//Looks down
					}
				}
				if(i-1 != -1 && j-1 != -1 && temparray[i-1][j-1] == 1){
					for(int row = i, column = j; row > -1 && column > -1; row--, column--){
							if (temparray[row][column] == 2){
								returnval = true;
								if(actualPiece == true)
									flipPiecesUpLeft(i, j, temp, 2);
								else if (actualPiece == false)
									possibleShowUpLeft(i, j, temp);
								
						}		//Looks up/left
					}
				}
				if(i+1 != 8 && j+1 != 8 && temparray[i+1][j+1] == 1){
					for(int row = i, column = j; row < 8 && column < 8; row++, column++){
							if (temparray[row][column] == 2){
								returnval = true;
								if(actualPiece == true)
									flipPiecesDownRight(i, j, temp, 2);
								else if (actualPiece == false)
									possibleShowDownRight(i, j, temp);
								
						}		//Looks down/right
					}
				}
				if(i+1 != 8 && j-1 != -1 && temparray[i+1][j-1] == 1){
					for(int row = i, column = j; row < 8 && column > -1; row++, column--){
							if (temparray[row][column] == 2){
								returnval = true;
								if(actualPiece == true)
									flipPiecesDownLeft(i, j, temp, 2);
								else if (actualPiece == false)
									possibleShowDownLeft(i, j, temp);
								
						}		//Looks down/left
					}
				}
				if(i-1 != -1 && j+1 != 8 && temparray[i-1][j+1] == 1){
					for(int row = i, column = j; row > -1 && column < 8; row--, column++){
							if (temparray[row][column] == 2){
								returnval = true;
								if(actualPiece == true)
									flipPiecesUpRight(i, j, temp, 2);
								else if (actualPiece == false)
									possibleShowUpRight(i, j, temp);
								
						}		//Looks up/right
					}
				}
				
				
		}
	return returnval;	//returns either true, or false, depending if a direction works
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
					System.out.println(row + " " + j);
				}
			}
		}
		//DIAGONALS
	public static void flipPiecesUpLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//up/left	
			for(int row = i, column = j; row > -1 && column > -1; row--, column--){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);
						System.out.println(row + " " + j);
					}
			}	
		}
	public static void flipPiecesDownRight(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//down/right	
			for(int row = i, column = j; row < 8 && column < 8; row++, column++){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);

					}
			}	
		}
	public static void flipPiecesDownLeft(int i, int j, Color colorPass, int colorNum){
		Color color = colorPass;//down/left	
			for(int row = i, column = j; row < 8 && column > -1; row++, column--){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);	
					}
			}	
		}
	
		public static void flipPiecesUpRight(int i, int j, Color colorPass, int colorNum){
			Color color = colorPass; //up/right	
			for(int row = i, column = j; row > -1 && column < 8; row--, column++){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);	
					}
			}	
		}	
	
	
	
	
		
		
		
	//Possible moves updates
		public static void possibleShowRight(int i, int j, Color color){//Right
			int capPiece = 0;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int column = j+1; column < 8; column++){				
				if (Game.board[i][column] == capPiece){		//if it hits either a black (1) or white (2) piece, the it breaks. Prevents false moves that scan through existing pieces until it hits an empty space.
					break;
				}
				else if (Game.board[i][column] == 0){									//this scans until it hits an empty space, placing a grey marker there, and breaking.
					GameUI.setColor(i, column, Color.GRAY);
					break;
				}
			}
		}
		public static void possibleShowLeft(int i, int j, Color color){				//Left
			int capPiece = 0;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int column = j-1; column > -1; column--){
				if (Game.board[i][column] == capPiece){
					break;
				}
				else if (Game.board[i][column] == 0){
					GameUI.setColor(i, column, Color.GRAY);
					break;
				}
			}
		}
		public static void possibleShowUp(int i, int j, Color color){					//Up
			int capPiece = 0;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int row = i-1; row >-1; row--){
				if (Game.board[row][j] == capPiece){
					break;
				}
				else if (Game.board[row][j] == 0){
					GameUI.setColor(row, j, Color.GRAY);
					break;
				}
			}
		}
		public static void possibleShowDown(int i, int j, Color color){					//Down
			int capPiece = 0;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int row = i+1; row < 8; row++){
				if (Game.board[row][j] == capPiece){
					break;
				}
				else if (Game.board[row][j] == 0){
					GameUI.setColor(row, j, Color.GRAY);
					break;
				}
			}
		}
	//DIAGONALS
		public static void possibleShowUpLeft(int i, int j, Color color){			//up/left	
			int capPiece = 3;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			
			for(int row = i, column = j; row > -1 && column > -1; row--, column--){		
				if (Game.board[row-1][column-1] == capPiece){
					break;
				}
				else if (Game.board[row][column] == 0){
					GameUI.setColor(row, column, Color.GRAY);
					break;
				}
			}	
		}
		public static void possibleShowDownRight(int i, int j, Color color){		//down/right	
			int capPiece = 3;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int row = i, column = j; row < 8 && column < 8; row++, column++){	
				if (Game.board[row+1][column+1] == capPiece){
					break;
				}
				else if (Game.board[row][column] == 0){
					GameUI.setColor(row, column, Color.GRAY);
					break;
				}
			}	
		}
		public static void possibleShowDownLeft(int i, int j, Color color){		//down/left	
			int capPiece = 3;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int row = i, column = j; row < 8 && column > -1; row++, column--){
				if (Game.board[row+1][column-1] == capPiece){
					break;
				}
				else if (Game.board[row][column] == 0){
					GameUI.setColor(row, column, Color.GRAY);
					break;
				}
			}	
		}
		public static void possibleShowUpRight(int i, int j, Color color){		//up/right
			int capPiece = 3;
			if(color == Color.BLACK){
				capPiece = 1;
			}
			else
				capPiece = 2;
			for(int row = i, column = j; row > -1 && column < 8; row--, column++){		
				if (Game.board[row- 1][column+1] == capPiece){
					break;
				}
				else if (Game.board[row][column] == 0){
						GameUI.setColor(row, column, Color.GRAY);
						break;
				}
			}	
		}	
	
	
	
	
	public static boolean isEndGame(int[][] board){
		boolean isEnd = false;
		
		
		return isEnd;
		
	}
	
}
