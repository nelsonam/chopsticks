import java.util.ArrayList;


public class Player
{
	ArrayList<Hand> hands;
	public Player()
	{
		this.hands = new ArrayList<Hand>();
		// two hands
		for(int numHands = 0; numHands < 2; numHands++)
		{
			hands.add(new Hand(this));
		}
	}
	
	public int getScore()
	{
		int score = 0;
		for(Hand h : hands)
		{
			score += h.getValue();
		}
		return score;
	}

	public Hand getHand(int hand)
	{
		return hands.get(hand);
	}

	public void printScore()
	{
		for(int i = 0; i < hands.size(); i++)
		{
			System.out.println("Hand #"+i+" : "+hands.get(i).getValue());
		}
		System.out.println();
	}
	
}
