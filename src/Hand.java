
public class Hand
{
	private Player player;
	private int value;
	private boolean canSplit;
	private boolean active;
	
	public Hand(Player p)
	{
		this.player = p;
		this.value = 1;
		this.canSplit = false;
		this.active = true;
	}
	
	public void add(int number)
	{
		this.value += (number % 5); // 5 fingers on each hand
		if(this.value%2==0)
		{
			this.canSplit = true;
		}
		else
		{
			this.canSplit = false;
		}
		
		if(this.value == 5)
		{
			this.value = 0;
			this.active = false;
		}
	}
	
	public int getValue()
	{
		return this.value;
	}
}
