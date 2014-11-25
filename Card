
public class Card 
{

	private int rank;
	private int suit;
	public static int CLUB = 1;
	public static int SPADE = 2;
	public static int HEART = 3;
	public static int DIAMOND = 4;
	public static int JACK = 10;
	public static int QUEEN = 11;
	public static int KING = 12;
	public static int ACE = 13;
	
	
	/**
	 * 
	 * @param rank int value of rank(see puplic static ints defined in Card)
	 * @param suit int value of suit(see puplic static ints defined in Card)
	 */
	public Card(int rank, int suit)
	{
		this.rank = rank;
		this.suit = suit;
	}
	
	/**
	 * gets rank
	 * @return int rank
	 */
	public int getRank()
	{
		return rank;
	}

	
	/**
	 * gets suit
	 * @return int suit
	 */
	public int getSuit()
	{
		return suit;
	}

	/**
	 * converts the int related to the suit to a string
	 * @return string of the suit
	 */
	public String stringSuit()
	{
		String output = new String();
		switch(getSuit())
		{
			case 1:
			{
				output = "Clubs";
				break;
			}
		
			case 2:
			{
				output = "Spades";
				break;
			}
		
			case 3:
			{
				output = "Hearts";
				break;
			}
		
			case 4:
			{
				output = "Diamonds";
				break;
			}
		}
		
		return output;
	}
	
	
	/**
	 * returns a string structured "(rank) of (suit)"
	 */
	public String toString()
	{
		String output = new String();
		switch(getRank())
		{
			case 1:
			{
				output = "One of " + stringSuit();
				break;
			}
		
			case 2:
			{
				output = "Two of " + stringSuit();
				break;
			}
		
			case 3:
			{
				output = "Three of " + stringSuit();
				break;
			}
		
			case 4:
			{
				output = "Four of " + stringSuit();
				break;
			}
		
			case 5:
			{
				output = "Five of " + stringSuit();
				break;
			}
		
			case 6:
			{
				output = "Six of " + stringSuit();
				break;
			}
		
			case 7:
			{
				output = "Seven of " + stringSuit();
				break;
			}
		
			case 8:
			{
				output = "Eight of " + stringSuit();
				break;
			}
		
			case 9:
			{
				output = "Nine of " + stringSuit();
				break;
			}
		
			case 10:
			{
				output = "Jack of " + stringSuit();
				break;
			}
		
			case 11:
			{
				output = "Queen of " + stringSuit();
				break;
			}
		
			case 12:
			{
				output = "King of " + stringSuit();
				break;
			}
		
			case 13:
			{
				output = "Ace of " + stringSuit();
				break;
			}
		
		}
		return output;
	}

	/**
	 * renamed compareTo() to beats() for coding purposes
	 * @param other card battling with this card
	 * @return int that represents this card winning, losing, or tying
	 */
	public int beats(Card other)
	{
		int result;
		if(this.getRank() > other.getRank())
			result = 1;
		if(this.getRank() < other.getRank())
			result = -1;
		else
			result = 0;
		return result;
	}
}
