//Owen Landwehr
//cs110
import java.util.ArrayList;
import javax.swing.*;

public class WarGame implements WarGameInterface {

    private QueueReferenceBased computerHand = new QueueReferenceBased();
    private QueueReferenceBased playerHand = new QueueReferenceBased();
    private ArrayList<Card> warCardsPot= new ArrayList<Card>();
    private Card warPlayerCard;
    private Card warComputerCard;


    public WarGame(){
        Deck newDeck = new Deck();
        newDeck.shuffle();

        dealHand(newDeck);
    }

    

    public void dealHand(Deck inputDeck){
        for (int x = 0; x < 26; x++){

            playerHand.enqueue(inputDeck.dealCard());
            computerHand.enqueue(inputDeck.dealCard());
        }
    }

    /**
     * compares the cards in the players hands
     * @return  V if player wins L if player loses W if there is a war
     */
    public char battle(Card playerCard, Card computerCard){
        if (playerCard.getRank() > computerCard.getRank()){
            playerHand.enqueue(playerCard);
            playerHand.enqueue(computerCard);

            int loopSize = warCardsPot.size();
            for (int x = 0; x < loopSize; x++){
                playerHand.enqueue(warCardsPot.remove(0));
            }

            return 'V';
        }

        else if (playerCard.getRank() < computerCard.getRank()){
            computerHand.enqueue(playerCard);
            computerHand.enqueue(computerCard);

            int loopSize = warCardsPot.size();
            for (int x = 0; x < loopSize; x++){
                computerHand.enqueue(warCardsPot.remove(0));
            }

            return 'L';
        }

        else{
            war(playerCard, computerCard);
        }

        return 0;
    }

    
    public void war(Card playerCard, Card computerCard){
        Card faceDownPlayerCard = playerDraw();
        Card faceDownComputerCard = computerDraw();

        warCardsPot.add(playerCard);
        warCardsPot.add(computerCard);
        warCardsPot.add(faceDownPlayerCard);
        warCardsPot.add(faceDownComputerCard);

        warPlayerCard = playerDraw();
        warComputerCard = computerDraw();

        char warResults = battle(warPlayerCard, warComputerCard);

        if (warResults == 'V'){
            System.out.println("Win");
        }

        if (warResults == 'L'){
            System.out.println("Lose");
        }
    }

    /**
     *@return The top card 
     */
    public Card playerDraw(){
        if (playerHand.isEmpty()){
            gameOver("Player");
        }
        return (Card)playerHand.dequeue();
    }

    /**
     * @return The top card
     */
    public Card computerDraw(){
        if (computerHand.isEmpty()){
            gameOver("Computer");
        }
        return (Card) computerHand.dequeue();
    }

   
    public Integer getPlayersCardsRemaining() {
        return playerHand.getSize();
    }

   
    public Integer getComputersCardsRemaining() {
        return computerHand.getSize();
    }

    
    public String getWarPlayerCard(){
        return warPlayerCard.getCardPic();
    }

    
    public String getWarComputerCard(){
        return warComputerCard.getCardPic();
    }

   
    public void gameOver(String s){
        if (s.equals("Player")){
            JOptionPane.showMessageDialog(null, "you lose");
        }
        else if (s.equals("Computer")){
            JOptionPane.showMessageDialog(null, "you win!");
        }

        System.exit(0);
    }
}