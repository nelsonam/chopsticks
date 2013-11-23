import java.util.ArrayList;
import java.util.Scanner;


public class Game
{
	private ArrayList<Player> players;
	private int turn;
	private int numPlayers;
	public Game(int numPlayers)
	{
		this.turn = 0;
		this.numPlayers = numPlayers;
		this.players = new ArrayList<Player>();
		// player 0 is the user's character
		for(int i = 0; i<numPlayers+1; i++)
		{
			Player newP = new Player();
			players.add(newP);
		}
		
	}
	
	public void playTurn()
	{
		System.out.println("It is player "+turn+"'s turn now!");
		System.out.println("Player "+turn+", your score: ");
		players.get(turn).printScore();
		System.out.println("What do you want to do?");
		System.out.println("1) Attack an opponent");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		if(choice == 1)
		{
			System.out.println("\nWhich of your hands do you want to use?");
			players.get(turn).printScore();
			int yourHandNum = in.nextInt();
			
			while(yourHandNum < 0 || yourHandNum >= 2)
			{
				System.out.println("Invalid choice, enter another choice.");
				yourHandNum = in.nextInt();
			}
			Hand yourHand = players.get(turn).getHand(yourHandNum);
			System.out.println("\nWhich opponent do you want to attack?");
			printOpponents(turn);
			int opponent = in.nextInt();
			
			// error checking
			while(opponent < 0 || opponent > numPlayers || opponent == turn)
			{
				System.out.println("Invalid choice, enter another choice.");
				opponent = in.nextInt();
			}
			Player opp = players.get(opponent);
			System.out.println("\nWhich hand of theirs do you want to attack?");
			opp.printScore();
			int oppHandNum = in.nextInt();
			
			while(oppHandNum < 0 || oppHandNum >= 2)
			{
				System.out.println("Invalid choice, enter another choice.");
				oppHandNum = in.nextInt();
			}
			Hand oppHand = opp.getHand(oppHandNum);
			oppHand.add(yourHand.getValue()); // adds your value to their hand
			
			System.out.println("Player "+opponent+"'s new score:");
			opp.printScore();
			System.out.println();
			
		}
		turn = (turn+1) % (numPlayers+1);
	}
	
	public void printOpponents(int player)
	{
		for(int i = 0; i < players.size(); i++)
		{
			if (i != player)
			{
				System.out.println("Player "+i+": ");
				players.get(i).printScore();
			}
		}
	}
	
	public boolean isDone()
	{
		for (Player p : players)
		{
			if(p.getScore() == 0)
			{
				return true;
			}
		}
		return false;
	}
	
	public int getWinner()
	{
		for (int pnum = 0; pnum < players.size(); pnum++)
		{
			if(players.get(pnum).getScore() > 0)
			{
				return pnum;
			}
		}
		return -1;
	}
}
