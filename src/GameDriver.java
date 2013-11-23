import java.util.Scanner;


public class GameDriver
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Chopsticks game!");
		System.out.println();
		System.out.println("How many opponents?");
		int numPlayers = in.nextInt();
		
		Game theGame = new Game(numPlayers);
		while(!theGame.isDone())
		{
			theGame.playTurn();
		}
		System.out.println("The game is over! Player "+theGame.getWinner()+" wins!");
	}

}
