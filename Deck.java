import java.util.ArrayList;
import java.util.Random;

public class Deck
{
    private final int CARDS_IN_DECK = 52;
    private ArrayList<Card> deck;

    
    public Deck()
    {
        freshDeck();
    }

    /**
     * Creates 52 Card ArrayList
     */
    public void freshDeck()
    {
        deck = new ArrayList<Card>(CARDS_IN_DECK);

        for (int i = 2; i <= 14;i++)
        {
            for (int k = 1;k <= 4;k++)
            {
                deck.add(new Card(i,k));
            }
        }

    }

    /**
     * Method removes the first card
     *
     * @return Card cardat front of ArrayList.
     */
    public Card dealCard()
    {
        Card c = deck.remove(0);  //  remove it (returns removed object)
        return c;
    }

    /**
     * size of deck
     *
     * @return integer size of the ArrayList.
     */
    public int cardsRemaining()
    {
        return deck.size();
    }

    /**
     * shuffles deck
     *
     */
    public void shuffle()
    {
        int randNum;
        Card temp;
        Random r = new Random();
        for (int i = 0; i < deck.size(); i++)
        {
            randNum = r.nextInt(deck.size());
            temp = deck.get(i);
            deck.set(i,deck.get(randNum));
            deck.set(randNum,temp);
        }
    }

    
    public boolean isEmpty()
    {
        return (deck.size() == 0);
    }
}