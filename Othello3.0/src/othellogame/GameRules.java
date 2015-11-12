package othellogame;

import java.awt.Color;
import java.util.Arrays;

public class GameRules {
	
	
	
	
	//METHOD TO CHECK IF CAN PLACE PIECE
	//This checks adjacent values first, to see if you can place a piece of another color next to it, the searches deeper to see if there's 
	//a piece of the same color at the end. 
	public static int canMove(int[][] temparray, int i, int j, Color temp){
		int returnval = 0;
		if(temp == Color.BLACK){																										
				if(j+1 != 8 && temparray[i][j+1] == 2){					 //This version checks for adjacent WHITE squares, hence == 2					 
					int row = i;				
					for(int column = j; column < 8; column++){
						if (temparray[row][column] == 1){
							returnval = 3;
							flipPieces(i, j, Color.BLACK, 1, 1);				
					
						}	//Looks right	
					}		
				}															
				if(j-1 != -1 && temparray[i][j-1] == 2){			
					int row = i;
					for(int column = j; column > -1; column--){
						if (temparray[row][column] == 1){
							returnval = 3;
							flipPieces(i, j, Color.BLACK, 2, 1);
							
						}	//Looks left	
					}							
				}														//Basically, how this works is it checks each +/- directions to see if there's a piece of another color there.
				if(i-1 != -1 && temparray[i-1][j] == 2){				//Each direction also checks if there's a piece of the same color afterwards.
					int column = j;										
					for(int row = i; row >-1; row--){					
						if (temparray[row][column] == 1){				
							returnval = 3;
							flipPieces(i, j, Color.BLACK, 3, 1);
							
						}	//Looks up	
					}								
				}											
				if(i+1 != 8 && temparray[i+1][j] == 2){			
					int column = j;
					for(int row = i; row < 8; row++){
						if (temparray[row][column] == 1){
							returnval = 3;
							flipPieces(i, j, Color.BLACK, 4, 1);
							
						}	//Looks down
					}
				}	
				//DIAGONALS														
				if(i-1 != -1 && j-1 != -1 && temparray[i-1][j-1] == 2){			
					for(int row = i, column = j; row > -1 && column > -1; row--, column--){				
							if (temparray[row][column] == 1){
								System.out.println("up/left");
								flipPieces(i, j, Color.BLACK, 5, 1);
								returnval = 3;
								
							}		//Looks up/left
						
					}
				}
				if(i+1 != 8 && j+1 != 8 && temparray[i+1][j+1] == 2){
					for(int row = i, column = j; row < 8 && column < 8; row++, column++){
							if (temparray[row][column] == 1){
								System.out.println("down/right");
								flipPieces(i, j, Color.BLACK, 6, 1);
								returnval = 3;
								
							}		//Looks down/right
					}
				}
				if(i+1 != 8 && j-1 != -1 && temparray[i+1][j-1] == 2){
					for(int row = i, column = j; row < 8 && column > -1; row++, column--){
							if (temparray[row][column] == 1){
								System.out.println("down/left");
								flipPieces(i, j, Color.BLACK, 7, 1);
								returnval = 3;
								
						}		//Looks down/left
					}
				}
				if(i-1 != -1 && j+1 != 8 && temparray[i-1][j+1] == 2){
					for(int row = i, column = j; row > -1 && column < 8; row--, column++){
							if (temparray[row][column] == 1){
								System.out.println("up/right");
								flipPieces(i, j, Color.BLACK, 8, 1);
								returnval = 3;
								
						}		//Looks up/right
					}
				}
				
			
		}
		
		else if (temp == Color.WHITE){											// the && are to make sure search doesn't go out of bound
			if(j+1 != 8 && temparray[i][j+1] == 2){					 			//This version checks for adjacent BLACK squares, hence == 2					 
				int row = i;				
				for(int column = j; column < 8; column++){
					if (temparray[row][column] == 2){
						returnval = 3;
						flipPieces(i, j, Color.WHITE, 1, 2);				
				
					}	//Looks right	
				}		
			}
				
				if(j-1 != -1 && temparray[i][j-1] == 1){
					int row = i;
					for(int column = j; column > -1; column--){
						if (temparray[row][column] == 2){
							returnval = 3;
							flipPieces(i, j, Color.WHITE, 2, 2);
							
						}	//Looks left	
					}	
				}
				
				if(i-1 != -1 && temparray[i-1][j] == 1){
					int column = j;							
					for(int row = i; row >-1; row--){		
						if (temparray[row][column] == 2){
							returnval = 3;
							flipPieces(i, j, Color.WHITE, 3, 2);
							
						}	//Looks up
					}	
				}
				if(i+1 != 8 && temparray[i+1][j] == 1){
					int column = j;
					for(int row = i; row < 8; row++){
						if (temparray[row][column] == 2){
							returnval = 3;
							flipPieces(i, j, Color.WHITE, 4, 2);
						}	//Looks down
					}
				}
				if(i-1 != -1 && j-1 != -1 && temparray[i-1][j-1] == 1){
					for(int row = i, column = j; row > -1 && column > -1; row--, column--){
							if (temparray[row][column] == 2){
								returnval = 3;
								flipPieces(i, j, Color.WHITE, 5, 2);
								
						}		//Looks up/left
					}
				}
				if(i+1 != 8 && j+1 != 8 && temparray[i+1][j+1] == 1){
					for(int row = i, column = j; row < 8 && column < 8; row++, column++){
							if (temparray[row][column] == 2){
								returnval = 3;
								flipPieces(i, j, Color.WHITE, 6, 2);
								
						}		//Looks down/right
					}
				}
				if(i+1 != 8 && j-1 != -1 && temparray[i+1][j-1] == 1){
					for(int row = i, column = j; row < 8 && column > -1; row++, column--){
							if (temparray[row][column] == 2){
								returnval = 3;
								flipPieces(i, j, Color.WHITE, 7, 2);
								
						}		//Looks down/left
					}
				}
				if(i-1 != -1 && j+1 != 8 && temparray[i-1][j+1] == 1){
					for(int row = i, column = j; row > -1 && column < 8; row--, column++){
							if (temparray[row][column] == 2){
								returnval = 3;
								flipPieces(i, j, Color.WHITE, 8, 2);
								
						}		//Looks up/right
					}
				}
				
				
		}
	return returnval;
	}
	
	
	public static void flipPieces(int i, int j, Color colorPass, int directionIdentifier, int colorNum){
		Color color = colorPass;
		int direction = directionIdentifier;
		if (direction == 1){						//Right
				for(int column = j+1; column < 8; column++){
					if (Game.board[i][column] == colorNum) break;
					else{
						GameUI.setColor(i, column, color);
						Game.setPieceFlip(i, column, colorNum);
					}
				}
		}
		else if (direction == 2){					//Left
			for(int column = j-1; column > -1; column--){
				if (Game.board[i][column] == colorNum) break;
				else{
					GameUI.setColor(i, column, color);
					Game.setPieceFlip(i, column, colorNum);
				}
			}
		}
		else if (direction == 3){					//Up
			for(int row = i-1; row >-1; row--){
				if (Game.board[row][j] == colorNum) break;
				else{
					GameUI.setColor(row, j, color);
					Game.setPieceFlip(row, j, colorNum);
				}
			}
		}
		else if (direction == 4){					//Down
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
		else if (direction == 5){					//up/left	
			for(int row = i, column = j; row > -1 && column > -1; row--, column--){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);
						System.out.println(row + " " + j);
					}
			}	
		}
		else if (direction == 6){					//down/right	
			for(int row = i, column = j; row < 8 && column < 8; row++, column++){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);

					}
			}	
		}
		else if (direction == 7){					//down/left	
			for(int row = i, column = j; row < 8 && column > -1; row++, column--){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);
						
					}
			}	
		}
		else if (direction == 8){					//up/right	
			for(int row = i, column = j; row > -1 && column < 8; row--, column++){		
					if (Game.board[row][column] == colorNum) break;
					else{
						GameUI.setColor(row, column, color);
						Game.setPieceFlip(row, column, colorNum);
						
					}
			}	
		}
		
		
		
		
	}
	
}
