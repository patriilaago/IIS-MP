package uo.mp.lab01.game2048.model;

import java.util.Random;

/**
 * Abstraction of the game 2048. This abstraction represents the game 2048, more information about
 * this game can be found at: <a href="http://juego2048.es/">http://juego2048.es/</a>. This class
 * allows to create instances of different sizes, the default size being 3x3. In addition, it allows
 * to perform the different actions of interacting with the board: moveRight, moveLeft, moveUp and
 * moveDown.
 *
 * @author Programming Methodology 2023 Teaching Staff
 * @version 2023
 */
public class Game2048 {

	private int[][] board;
	public static final int FIRST_INITIAL_SIZE =3;
	public static final int MAXIMUM =5;
	
  /**
   * Default builder for the 2048 game. Creates a new game instance with a 3x3 board. It makes use
   * of the {@code DEFAULT_BOARD_SIZE} constant and invokes the constructor that receives the size
   * as a parameter.
   */
  public Game2048() {
    board = new int[FIRST_INITIAL_SIZE][FIRST_INITIAL_SIZE];
  }

  /**
   * This constructor creates an instance of the game 2048 with a board whose size is given by the
   * constructor parameter. The size has to be within the limits of 3 and 5, both included. If the
   * given size is not within these limits then the created instance will use a board with size
   * equal to {@code DEFAULT_BOARD_SIZE}. To do this, creates a size x size square integer array and
   * invokes the Game2048 constructor which takes an integer array as a parameter.
   *
   * @parameter size is an integer representing the size of the board to be used during the game. If the
   *        given value is not between 3 and 5 inclusive, then the value of
   *        {@code DEFAULT_BOARD_SIZE} is used as the board size.
   */
  public Game2048(int size) {
    if(size>=FIRST_INITIAL_SIZE && size<=MAXIMUM) {
    	board = new int[size][size];
    }
    else {
    	board = new int[FIRST_INITIAL_SIZE][FIRST_INITIAL_SIZE]; 
    }
  }

  /**
   * This constructor creates an instance of the game 2048 and assigns the given integer array as
   * the game board. To do so, the given matrix must meet the conditions that it is a square matrix
   * with size between 3 and 5, both included. If any of these conditions is not met, then the game
   * is initialized with a default game board. Also, if the reference of the integer array given as
   * parameter points to null then the NullPointerException is thrown and the game instance is not
   * created.
   *
   * @parameter board is an array of integers that will be assigned as the board of the game to be
   *        created. This matrix has to be square with size between 3 and 5, both included. It must
   *        also be composed of numbers that are powers of 2. In case the given matrix does not meet
   *        any of the conditions, the game will be initialized with the default board. If it points
   *        to null then NullPointerException.
   * @throws IllegalArgumentException if board is null.
   */
  public Game2048(int[][] board) {
   if(board==null) {
	throw new RuntimeException("Null is not valid");
	   }
   boolean correct=true;
   if(board.length==board[0].length && board.length>=FIRST_INITIAL_SIZE && board.length<=MAXIMUM){
	  for(int row=0;row<board.length;row++){
		  for(int column=0;column<board[0].length;column++){
			  if(isNumberPowerOfTwo(board[row][column])) {
				   correct=false;
			  }
		  }
	  }
	  if(correct){
		  this.board=new int[board.length][board[0].length];
		  for(int row=0;row<board.length;row++){
			  for(int column=0;column<board[0].length;column++){
				  this.board[row][column]=board[row][column];
		   }
		}
	 } 
   }
   else {
	   this.board=new int[FIRST_INITIAL_SIZE][FIRST_INITIAL_SIZE];
   }
   
  }

  /**
   * Returns a copy of the board Useful for testing purposes
   *
   * @return an exact copy of the board
   */
  public int[][] getBoard() {
    int[][]copy= new int[board.length][board[0].length];
    for(int row=0;row<board.length;row++) {
    	for(int column=0;column<board[0].length;column++){
    		copy[row][column]=board[row][column];
    	}
    }
    return copy;
  }

  /**
   * This method resets all board positions to 0 and then calls next() to place a 2 at a random
   * position on the board.
   */
  public void restart() {
	 for(int row=0;row<board.length;row++) {
	    for(int column=0;column<board[0].length;column++){
	    	board[row][column]=0;
	    	}
	    }
	  }

  /**
   * Understanding that a position containing a 0 on the board is an empty position, this method
   * tells us whether the board is full or not. That is, if it does not have any position with a 0
   * then it returns true and if any position has a 0 then it returns false. To do this it goes
   * through all the positions on the board and if it finds any position that is 0 then it returns
   * false and terminates the execution.
   *
   * @return if the board does not have any position with a 0 then it returns true and if any
   *         position has a 0 then it returns false.
   */
  public boolean isBoardFull(){
    for(int row=0;row<board.length;row++) {
    	for (int column=0;column<board[0].length;column++) {
    		if(board[row][column]==0){
    			return false;
    		}
    	}
    }
    return true;
  }

  /**
   * @return true if the player has not won yet and there are some free tiles on the board; false
   *         otherwise. True = not(hasWon) + not (isBoardFull)
   */
  public boolean isGameFinished() {
    if(hasWon() && isBoardFull()) {
    	return false;
    }
    else{
    	return true;
    }
  }

  /**
   * This method checks if the condition to finish the game and win is reached. That is, if some
   * tile contains a 2048. Then, it returns true; otherwise, returns false.
   * 
   * @return true if the condition to finish the game and win is reached.
   */
  private boolean hasWon() {
    for(int row=0;row<board.length;row++) {
    	for(int column=0;column<board[0].length;column++) {
    		if(board[row][column]==2048) {
    			return true;
    		}
    	}
    }
	return false;
  }

  /**
   * Checks whether the number given as a parameter is a power of 2 or not. If yes, it returns true,
   * if no, it returns false.
   *
   * @parameter number to check if it is power of 2 or not.
   * @return true if the given number is a power of 2; false otherwise.
   */
  private boolean isNumberPowerOfTwo(int number) {
    return (number & number - 1) == 0;
  }

  /**
   * Writes a 2 value on a random free tile, assuming there is one.
   *
   * @return true if there were a free tile; false otherwise.
   */
  public boolean next() {
	  boolean place = false;
	  Random value = new Random();
	  int row=0;
	  int column=0;
	  while(!place){
	    row=value.nextInt(board.length);
	    column=value.nextInt(board.length);
	    if(board[row][column]==0) {
	    	board[row][column]=2;
	    	place=true;
	    	return true;
	    }		
	  }
	  return false;
  }
	
  /**
   * Compacts a column to the right. We start checking the whole board. In we find a 
   * position with a value different to 0, we look the the position next to it(to the right). In case 
   * that position has the value 0, we move the initial position to the right. 
   */
  public void compactRight() {
	for (int row = 0; row < board.length; row++) {
		for (int column = 0; column < board.length-1; column--) {
			if(board[row][column]==0){
				for (int k = column-1; k>=0; k--) {
					if(board[row][k]!=0){
						int aux=board[row][k];//first element different from 0
						board[row][k]=board[row][column];
						board[row][column]=aux;
					}
				}
			}
		}
	}
}
		
  
  
  public void moveRight() {
	 compactRight();
	 for(int row=board.length-1;row>=0;row--) {
	    for (int column=board[0].length-1;column>0;column--){
	    	if(board[row][column]==board[row][column-1]){   
	    		int suma = board[row][column]+board[row][column-1];
	    		board[row][column-1]=0;
	    		board[row][column]=suma;
	    	}
	    }
	 }
	 compactRight();
  }

  /**
   * Compacts a column to the left. We start checking the whole board. In we find a 
   * position with a value different to 0, we look the the position next to it(to the left). In case 
   * that position has the value 0, we move the initial position to the left.
   * 
   */
  public void compactLeft() {
	for (int row = 0; row < board.length; row++) {
		for (int column = 0; column < board[0].length; column++) {
			if(board[row][column]==0){
				for (int k = column+1; k < board.length; k++) {
					if(board[row][k]!=0){
						int aux=board[row][k];//first element different from 0
						board[row][k]=board[row][column];
						board[row][column]=aux;
					}
				}
			}
		}
	}
  }
	
  
  public void moveLeft() {
	  compactLeft();
		 for(int row=0;row<board.length;row++) {
		    for (int column=0;column<board[0].length;column++){
		    	if(board[row][column]==board[row][column+1]){   
		    		int suma = board[row][column]+board[row][column+1];
		    		board[row][column+1]=0;
		    		board[row][column]=suma;
		    	}
		    }
		 }
	  compactLeft();
  }

  /**
   * Compacts a row up. We start checking the whole board. In we find a 
   * position with a value different to 0, we look the the position above it. In case 
   * that position has the value 0, we move the initial position up.
   */
  public void compactUp() {
	for (int row = 0; row < board.length; row++) {
		for (int column = 0; column < board[0].length; column++) {
			if(board[row][column]==0){
				for (int k = column+1; k < board.length; k++) {
					if(board[row][k]!=0){
						int aux=board[row][k];//first element different from 0
						board[row][k]=board[row][column];
						board[row][column]=aux;
					}
				}
			}
		}
	}
}
  
  public void moveUp() {
	  compactUp();
		 for(int row=0;row<board.length;row++) {
		    for (int column=0;column<board[0].length;column++){
		    	if(board[column][row]==board[column+1][row]){   
		    		int suma = board[column][row]+board[column][row+1];
		    		board[column+1][row]=0;
		    		board[row][column]=suma;
		    	}
		    }
		 }
	  compactUp();
  }

  /**
   * Compacts a row down. We start checking the whole board. In we find a 
   * position with a value different to 0, we look the the position below it. In case 
   * that position has the value 0, we move the initial position down.
   */
  public void compactDown() {
	for (int row = 0; row < board.length; row++) {
		for (int column = 0; column < board[0].length-1; column--) {
			if(board[row][column]==0){
				for (int k = column-1; k>=0; k--) {
					if(board[row][k]!=0){
						int aux=board[row][k];//first element different from 0
						board[row][k]=board[row][column];
						board[row][column]=aux;
					}
				}
			}
		}
	}
}
  
  
  public void moveDown() {
	  compactDown();
		 for(int row=0;row<board.length;row++) {
		    for (int column=0;column<board[0].length;column--){
		    	if(board[column][row]==board[column-1][row]){   
		    		int suma = board[column][row]+board[column-1][row];
		    		board[column-1][row]=0;
		    		board[column][row]=suma;
		    	}
		    }
		 }
	  compactDown(); 
  }

  /**
   * Returns a String representation of this instance of the Game2048.
   *
   * @return a String with the content of the board to be printed out. Format each string so there
   *         are 5 spaces for every cell in the same row. Insert a new line between each two rows
   *         Example: 2 2 0 2 0 0 2 0 2 will be "2 2 0 \n2 0 0 \n2 0 2 "
   */
  @Override
  public String toString() {
    String result = "";
	for (int row = 0; row < this.board.length; row++) {
		for (int column = 0; column < this.board.length; column++) {
    		result+=board[row][column]+"";
    	}
    	result+="\n";
    }
    return result;
  }

}
