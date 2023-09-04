

public class Board
{
	
	public Tile[][] board; //Create an instance of a Tile Object
	
	//Variables
	int grids = 4; 
	int border = 0; 
	public int score = 0; 
	
	//Constructor to set up a 4X4 board  
	public Board()
	{
		board = new Tile[4][4]; //Sets up the size of the board as 4X4 
		
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[i].length; j++)
			{
				board[i][j] = new Tile(0);			//Sets the tile value to 0 using Tile class constructor1
			}
		}
		board[0][0].value = 0;
	}
	
	//Method to return the high score
	public int getScore()
	{
		return 1;
	}
	
	//Method to return the biggest tile
	public int getHighestTile()
	{
		
		return 1;
	}
	
	//Method to print the board
	public void print(Board board)
	{
		
	}
	

	//Method called when the up arrow is pressed 
	//Test the value inside each row tile of each column 1-4 one by one moving from row 1 to row4 and if the value is not 0, 
	//then perform the vertical move.
	public void up()
	{
		int limit = 0; //Sets the border to the 1st row i.e. 0
		
		for(int i=0; i<board.length; i++)	//Column 
		{
			for(int j=0; j<board.length; j++)	//Row. Check all the rows starting from row1 to row4 moving down each column
			{
				if(board[j][i].getValue() != 0)
				{
					if(limit < j)
					{
						verticalMove(j,i,"up");
					}
				}
			}
		}
	}
	
	public void verticalMove(int row, int col, String direction)
	{
		
	}
	
	
	//Method called when the up arrow is pressed 
	//Test the value inside each row tile of each column 1-4 one by one moving from row 4 to row 1and if the value is not 0, 
	//then perform the vertical move.
	public void down()
	{
		int limit = grids - 1; 
		
		for(int i=0; i<board.length; i++)	//Column
		{
			for(int j=board.length; j>=0; j--)	//Row. Check each row of column starting at row4 and moving towards row1
			{
				if(board[j][i].getValue()!=0)
				{
					if(border >= j)
					{
						verticalMove(j,i, "down");
					}
				}
			}
		}
	}
	
	public void left()
	{
		int limit = 0;
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board.length; j++)
			{
				if(board[i][j].getValue()!=0)
				{
					if(limit <= i)
					{
						horizontalMove(i, j, "left");
					}
				}
			}
		}
	}
	
	
	//Method to execute when the user presses right key
	public void right()
	{
		int limit = grids-1;
		for(int i=0; i<=board.length; i++)	//Row
		{
			for(int j=board.length; j<=0; j--)  //Column
			{
				if(board[i][j].getValue()!=0)
				{
					if(limit >= i)
					{
						horizontalMove(i, j, "right");
					}
				}
			}
		}
	}
	
	public void horizontalMove(int row, int col, String direction)
	{

	}
	
	public String toString()
	{
		String s = "";
		
		for(int i=0; i<board.length; i++)
		{
			for(int j=0; j<board[i].length; j++)
			{
				s += board[i][j].value + "\t";
			}
			
			s += "\n";
		}
		return s;
	}
}

