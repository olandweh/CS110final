
public interface WarGameInterface {

    public char battle(Card playerCard, Card computerCard);

    public void war(Card playerCard, Card computerCard);

    public Card playerDraw();

    public Card computerDraw();

    public void dealHand(Deck inputDeck);
    
    public Integer getPlayersCardsRemaining();

    public Integer getComputersCardsRemaining();

    public void gameOver(String s);
    
    public String getWarComputerCard();

    public String getWarPlayerCard();

    
}