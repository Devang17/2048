import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game //extends JPanel implements KeyListener
{

	
	static Board board = new Board();	//Set up a new Board object
	static Game game = new Game(); //Create w new Game object to setup a keyListener
	//static JFrame frame = new JFrame("KeyEvent Example");
	
/*	
	//Setup the GUI to act as a keylistener 
	public static void GUI()
	{
		frame.addKeyListener((KeyListener) game);
        frame.getContentPane().add(game);
        frame.setSize( 600, 400 );
        frame.setVisible( true );
        frame.setResizable( false );
	}
	
	//keypressed keyListener to detect the user input
	@Override
	public void keyPressed( KeyEvent e )
    {
		if(e.getKeyChar() == 'w')
		{
			System.out.println("UP");
		}
		
		else if(e.getKeyChar() == 'a')
		{
			System.out.println("left");
		}
		
		else if(e.getKeyChar() == 's')
		{
			System.out.println("down");
		}
		
		else if(e.getKeyChar() == 'd')
		{
			System.out.println("right");
		}
    }
	


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
 */
	public static void main(String[] args) throws InterruptedException
	{
		System.out.println(board.toString());
	
		//GUI();
		
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
						board.spawn();
						System.out.println(board.toString());
						
					break;
					
					case "a":
						board.left();
						board.spawn();
						System.out.println(board.toString());
					break;
						
					case "s":
						board.down();
						board.spawn();
						System.out.println(board.toString());
					break;
						
					case "d":
						board.right();
						board.spawn();
						System.out.println(board.toString());
					break;
					
					default: 
						break;
				}
			}
		}
        

        
	}


}
