import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.JFrame;

public class Game 
{

	
	static Board board = new Board();	//Set up a new Board object
	
	
	public static void main(String[] args)
	{
		System.out.println(board.toString());
		Scanner scan = new Scanner(System.in);
		
		boolean flag = true;
		while(flag)
		{
			System.out.println("Play next move");
			String move = scan.nextLine();
			
			if(move != null)
			{
				switch(move)
				{
					case "w":
						board.up();
					break;
					
					case "a":
						board.left();
					break;
						
					case "s":
						board.down();
					break;
						
					case "d":
						board.right();
					break;
				}
			}
		}
	}
}
