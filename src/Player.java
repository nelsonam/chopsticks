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
			hands.add(new Hand());
		}
	}

	public void split()
	{
		// can we split? (one even hand one empty hand)
		if((hands.get(0).canSplit() && hands.get(1).getValue() == 0) ||
			(hands.get(1).canSplit() && hands.get(0).getValue() == 0))
		{
			int splitPoints = (hands.get(0).getValue() + hands.get(1).getValue()) / 2;
			hands.get(0).setValue(splitPoints);
			hands.get(1).setValue(splitPoints);
		}
		else
		{
			System.out.println("You can't split with this configuration.");
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
