import java.util.Random;

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
		
		Random rand = new Random();
		int x = rand.nextInt(4);
		int y = rand.nextInt(4);
		
		board[0][3].value = 8;
		board[0][2].value = 2;
		board[0][1].value = 4;
		board[0][0].value = 2;
		
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

	
	//Find an empty tile and spawn either a 2 or a 4 in the tile
	public void spawn()
	{
		boolean flag = true;
		Random rand = new Random();
		while(flag)
		{
			int col = rand.nextInt(3);
			int row = rand.nextInt(3);
			
			System.out.println("don2");
			
			if(board[row][col].value == 0)
			{
				double randomNum = Math.random();
				
				int spawnNum = (randomNum > 0.5) ? 2:4;
				
				board[row][col].setValue(spawnNum);
				flag = false;
			}
			
		}
		
	}
	

	//Method called when the up arrow is pressed 
	//Test the value inside each row tile of each column 1-4 one by one moving from row 1 to row4 and if the value is not 0, 
	//then perform the vertical move.
	public void up() throws InterruptedException
	{
		for(int i=0; i<board.length; i++)	//Column 
		{
			border = 0; 
			for(int j=0; j<board.length; j++)	//Row. Check all the rows starting from row1 to row4 moving down each column
			{
				System.out.print(board[i][j].getValue() + "\t");
				if(board[j][i].getValue() != 0)
				{
					if(border <= j)
					{
						//verticalMove(j,i,"up");
					}
				}
			}
			System.out.println();
		}
		System.out.println("\n");
		System.out.println("NOW WE TRY RECURSION");
		up2(board, grids-1, 0, grids-1);
	}
	
	public void up2(Tile[][] testArr, int row, int col, int compare) throws InterruptedException
	{
		
		System.out.println("col == " +  col);
		if(col >= 4)
		{	
			System.out.println("sTIME TO STOP");
			return;
		}
		
		else if(col<=3)
		{
			if(compare<0)
			{			
				row = testArr.length-1;
				compare = row;
				col+=1;
				
				if(col >=4)
				{
					return;
				}
				up2(testArr, row, col, compare);
			}
			
				Tile initialTile = board[row][col];
				Tile compareTile = board[compare][col];
			
			if(compare == row)
			{
				System.out.println("Row equal to compare to reduce by 1;");
				compare--;
				up2(testArr, row, col, compare);
			}

			else if(initialTile.value == 0 || compareTile.value == initialTile.value)
			{
				
				if(compare < row)
				{
					System.out.println("Row after changing value " + row);
					System.out.println("Compare = " + compare + "   Compare tile value = " + compareTile.value);
					int score = initialTile.value + compareTile.value; 
					initialTile.setValue(score);
					compareTile.setValue(0);
					Thread.sleep(100);
					compare -=1;
					up2(testArr, row, col, compare);
				}
				else 
				{
					compare-=1;
					up2(testArr, row, col, compare);
				}
			}
	
		}
	}
	

	//Performs vertical move i.e. adding and moving the tiles based upon their tile values
	public void verticalMove(int row, int col, String direction)
	{
		Tile currentTile = board[border][col];
		Tile nextTile = board[row][col];
		
		if(currentTile.value == 0 || currentTile.value == nextTile.value)
		{
			//Move Vertically
			if(row < border && direction == "down"  || row > border) 
			{
				int score = currentTile.value += nextTile.value;
				currentTile.setValue(score);
				nextTile.setValue(0);	
			}
		}
		else
		{
			if(direction == "up")
			{
				border++;
				
			}
			
			else if(direction == "down")
			{
				border--;
			}
			
			verticalMove(row, col, direction);
			
		}
	}
	

	//Method called when the up arrow is pressed 
	//Test the value inside each row tile of each column 1-4 one by one moving from row 4 to row 1and if the value is not 0, 
	//then perform the vertical move.
	public void down()
	{
		for(int i=0; i<grids; i++)	//Column
		{
		 	border = grids - 1; 
			for(int j=grids-1; j>=0; j--)	//Row. Check each row of column starting at row4 and moving towards row1
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
		
		for(int i=0; i<grids-1; i++)
		{
			border = 0;
			for(int j=0; j<=grids-1; j++)
			{
				if(board[i][j].getValue()!=0)
				{
					if(border <= j)
					{
						System.out.println("column = " + j);
						horizontalMove(i, j, "left");
					}
				}
			}
		}
	}
	
	
	//Method to execute when the user presses right key
	public void right()
	{
		for(int i=0; i<grids; i++)	//Row
		{
			border = 3;
			for(int j=grids-1; j>=0; j--)  //Column
			{
				
				if(board[i][j].getValue()!=0)
				{	
					if(border >= i)
					{				
						horizontalMove(i, j, "right");
					}
				}
			}
		}
	}
	
	public void horizontalMove(int row, int col, String direction)
	{
		Tile currentTile = board[row][border];
		Tile nextTile = board[row][col];
		//System.out.println(border);
		//System.out.println("column = " + col);
		if(currentTile.value == 0 || currentTile.value == nextTile.value)
		{
			if(col < border || col > border && direction =="left")
			{	
				int score = currentTile.value + nextTile.value;
				currentTile.setValue(score);
				nextTile.setValue(0); 
			}
		}
		
		else
		{
			if(direction == "right")
			{
				border--;
			}
			
			else
			{
				border++;
			}
			horizontalMove(row, col, direction);
		}
		
	}
	
	public String toString()
	{
		String s = "";
		
		for(int i=0; i<grids; i++)
		{
			for(int j=0; j<grids; j++)
			{
				s += board[i][j].value + "\t";
			}
			
			s += "\n";
		}
		return s;
	}
}

