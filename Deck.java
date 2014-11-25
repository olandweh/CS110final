import java.util.*;


public class Deck extends QueueReferenceBased 
{
	
	ArrayList<Card> deck = new ArrayList();
	
	public Deck()
	{
		for(int i = 1; i < 5; i++)
			for(int j = 1; j < 14; j++)
			{
				Card temp = new Card(j,i);
				deck.add(temp);
			}
		Collections.shuffle(deck);
		for(int i = 1; i < 53; i++)
		{
			super.enqueue(deck.get(i));
		}
	}
	
	public Object Draw()
	{
		if(!super.isEmpty())
			return super.dequeue();
		else 
			return null;
	}
	
	public void add(Card newCard)
	{
		super.enqueue(newCard);
	}

}
