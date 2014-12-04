public class Card 
{     
    public final static int SPADES = 1,
                            HEARTS = 2,
                            DIAMONDS = 3,
                            CLUBS = 4;
    public final static int ACE = 14,
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
   private int suit;   
   private int rank; 

    //The image of the card.
    private String cardPic;
                             
   /**
   * @param suit the suit of this card.
   * @param rank the rank of this card.
   */
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;

        cardPic = "cardPics/" + rank + suit + ".jpg";
    }
    
   /**
   * @param otherCar the card to be copied
   */
    public Card(Card otherCard) 
    {
         this.rank = otherCard.rank;
         this.suit = otherCard.suit;
    }
    
   /**
   * Returns the suit
   * @return a Suit the suit value of the card.
   */
  
    public int getSuit() 
    {
      return suit;
    }
   /**
   * Returns the rank of the card.
   * @return a Rank the rank value of the card.
   */

    public int getRank() 
    {
       return rank;
    }
    
   /**
   *description of the suit of this card.
   * @return the suit as a string.
   */
    public String getSuitAsString() 
    {
        switch ( suit ) {
           case SPADES:   return "Spades";
           case HEARTS:   return "Hearts";
           case DIAMONDS: return "Diamonds";
           case CLUBS:    return "Clubs";
           default:       return "Invalid";
        }
    }
   /**
   * description of the rank
   * @return the rank value of the card as a string
   */
   public String getRankAsString() 
   {
        switch ( rank ) {
           case 14:   return "Ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "Jack";
           case 12:  return "Queen";
           case 13:  return "King";
           default:  return "??";
        }
    }
   /**
   * @return the name of the card.
   */

    public String toString() 
    {
        return getRankAsString() + " of " + getSuitAsString();
    }
    
   /**
   * @param oth
   * @return true if the two cards have the same rank,
   */
   public boolean equals(Card otherCard ) 
   {
      return rank == otherCard.rank;
   }

    /**
     * gets the image
     * @return the path to the image
     */
    public String getCardPic() {
        return cardPic;
    }
}
