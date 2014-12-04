public interface DeckInterface {
    
    public void freshDeck();
    
    public int cardsRemaining();
    
    public Card dealCard();

    public void shuffle();

    public boolean isEmpty();
}