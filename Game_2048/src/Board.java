import java.util.Random;

public class Board
{
	
	public Tile[][] board; //Create an instance of a Tile Object
	
	//Variables
	int grids = 4; 
	int border = 0; 
	public int score = 0; 
	boolean flag = true;
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
		
		board[3][0].value = 8;
		board[3][1].value = 2;
		board[3][2].value = 4;
		board[3][3].value = 2;

		
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
			int col = rand.nextInt(4);
			int row = rand.nextInt(4);
			
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
//		for(int i=0; i<board.length; i++)	//Column 
//		{
//			border = 0; 
//			for(int j=0; j<board.length; j++)	//Row. Check all the rows starting from row1 to row4 moving down each column
//			{
//				System.out.print(board[i][j].getValue() + "\t");
//				if(board[j][i].getValue() != 0)
//				{
//					if(border <= j)
//					{
//						//verticalMove(j,i,"up");
//					}
//				}
//			}
//			System.out.println();
//		}
		flag = true;
		long startTime = System.nanoTime(); 
		up2(board, 0, 0, 0, "up");
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println( "Time take by the function " + estimatedTime);
	}
//	
//	public void up2()
//	{
//		int row = 0; 
//		int col = 0; 
//		border = row;
//		traverseUp(board, row, col);
//	}
//	
//	public void traverseUp(Tile[][] arr, int row, int col)
//
//	{
//		if(row < 0 || row >3)
//			return;
//	}
//	
//	
//	public void down2() 
//	{
//		int row = 3;
//		int col = 0;
//		border = row;
//		traverseDown(board, row, col);
//	}
	
	//Method called when the up arrow is pressed 
	//Test the value inside each row tile of each column 1-4 one by one moving from row 4 to row 1and if the value is not 0, 
	//then perform the vertical move.
	public void down() 
	{
		
//		for(int i=0; i<grids; i++)	//Column
//		{
//		 	border = grids - 1; 
//			for(int j=grids-1; j>=0; j--)	//Row. Check each row of column starting at row4 and moving towards row1
//			{
//				if(board[j][i].getValue()!=0)
//				{
//					if(border >= j)
//					{
//						//verticalMove(j,i, "down");
//					}
//				}
//			}
//		}
		flag = true;
		long startTime = System.nanoTime(); 
		//traverseDown(board, 3, 0);
		up2(board, 3, 0, 3, "down");
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println( "Time take by the function " + estimatedTime);
		
	}
	
//	
//	public void traverseDown(Tile[][] arr, int row, int col)
//	{
//		
//		if(row < 0 || border <0)
//		{
//			col++; 
//			row = 2; 
//			border = 3;
//		}
//		
//		if(col>=4)
//		{
//			return;
//		}
//		
//		if(board[row][col].getValue() != 0)
//		{
//			
//			if(border >= row)
//			{
//				verticalMove(row, col,"down");
//				row-=1;
//				traverseDown(arr, row, col);
//			}
//		}
//		
//		else
//		{
//			row--;
//			traverseDown(arr, row, col);
//		}
//		
//	}
//	
	public void up2(Tile[][] testArr, int row, int col, int compare, String direction)
	{	
		if(!flag)
		{
			return;
		}
		if(direction == "down" && compare<0 || direction == "up" && compare>3 )
		{	
			if(direction == "down")
				row = grids-1;
			else
				row = 0;
			compare = row;
			col+=1;	
			if(col >=4)
			{
				flag = false;
				return;
			}
			up2(testArr, row, col, compare, direction);
		}
		
		Tile initialTile = board[row][col];
		Tile compareTile = board[compare][col];
	
		if(compare == row)
		{
			compare += upORdown(direction);
			up2(testArr, row, col, compare, direction);
		}
		


		else if(initialTile.value == 0 && compareTile.value!=0 || compareTile.value == initialTile.value  && initialTile.value !=0 && board[compare][col]!=board[row][col])
		{		
			int score = initialTile.value + compareTile.value; 
			initialTile.setValue(score);
			compareTile.setValue(0);
			compare += upORdown(direction);
			up2(testArr, row, col, compare, direction);
			
		}
		
		else 
		{	
			if(compareTile.value!=0)
			{
				if(direction == "down")
					row-=1;
				else
					row+=1;
			}
			else
				compare += upORdown(direction);
			up2(testArr, row, col, compare, direction);
		}
	}
	
	public int upORdown(String direction)
	{
		if(direction == "down")
			return -1;
		else 
			return +1;
	}
	
	public void left2(Tile[][] testArr, int row, int col, int compare, String direction)
	{
		
		if(!flag)
		{
			return;
		}
		
		
		if(direction == "right" && compare<0 || direction == "left" && compare>3 )
		{		
			if(direction == "right")
				col = grids-1;
			else
				col = 0;
			compare = col;
			row+=1;	
			if(row >=4)
			{
				flag = false;
				return;
			}
			left2(testArr, row, col, compare, direction);
		}
		
		Tile initialTile = board[row][col];
		Tile compareTile = board[row][compare];
		
		if(compare == col)
		{
			
			compare += leftOrRight(direction);
			left2(testArr, row, col, compare, direction);
		}
		
		else if(initialTile.value == 0 && compareTile.value!=0 || compareTile.value == initialTile.value && initialTile.value !=0)
		{		
			int score = initialTile.value + compareTile.value; 
			initialTile.setValue(score);
			compareTile.setValue(0);
			compare += leftOrRight(direction);
			left2(testArr, row, col, compare, direction);
			
		}
		
		else 
		{	
			if(compareTile.value!=0)
			{
				if(direction == "right")
					col-=1;
				else
					col+=1;
			}
			else
				compare += leftOrRight(direction);
			left2(testArr, row, col, compare, direction);
		}
		
	}
	
	
	public int leftOrRight(String direction)
	{
		if(direction == "right")
			return -1;
		else 
			return +1;
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
	



	
	public void left()
	{
//		for(int i=0; i<grids-1; i++)
//		{
//			border = 0;
//			for(int j=0; j<=grids-1; j++)
//			{
//				if(board[i][j].getValue()!=0)
//				{
//					if(border <= j)
//					{
//						System.out.println("column = " + j);
//						//horizontalMove(i, j, "left");
//					}
//				}
//			}
//		}
		flag = true;
		left2(board, 0, 0, 0, "left");
	}
	
	
	//Method to execute when the user presses right key
	public void right()
	{
//		for(int i=0; i<grids; i++)	//Row
//		{
//			border = 3;
//			for(int j=grids-1; j>=0; j--)  //Column
//			{
//				
//				if(board[i][j].getValue()!=0)
//				{	
//					if(border >= i)
//					{				
//						//horizontalMove(i, j, "right");
//					}
//				}
//			}
//		}
		flag = true;
		left2(board, 0, 3, 3, "right");
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

