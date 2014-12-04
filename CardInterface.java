
public interface CardInterface {
    
    public int getSuit();

    
    public int getRank();

    
    public String getSuitAsString();

   
    public String getRankAsString();

    
    public String toString();

   
    public boolean equals(Card otherCard);

   
    public String getCardPic();
}