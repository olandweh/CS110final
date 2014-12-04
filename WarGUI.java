import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;

public class WarGUI  extends JFrame{
    private WarGame game;                                       
    private static final String BLANK = "cardPics/back.jpg";    
    private JLabel blankCardLabelLeft;                       
    private JLabel blankCardLabelRight;
    private JLabel playerCardLabel;                            
    private JLabel computerCardLabel;  
    private ImageIcon blankCard;                                
    private ImageIcon blankCard2;
    private ImageIcon blank;                                    //placeholder
    private ImageIcon playerCard;                               //Holds path to the current player card
    private ImageIcon computerCard;                             //Holds path to the current computer card
    private JButton playCardButton; 
    private JTextField playerCardsLeft;
    private JTextField computerCardsLeft;
    private JPanel buttonPanel;                                 
    private JPanel rightDeckPanel;                              
    private JPanel leftDeckPanel;                              
    private JPanel cardsPanel;                                  
    private JPanel counterPanel;                                
    private final int WINDOW_WIDTH = 1000;                      
    private final int WINDOW_HEIGHT = 400;                      
    private String war = "false";                               


   
    public WarGUI(){
       
        game = new WarGame();

        
        setLayout(new BorderLayout());
        setTitle("********WAR********");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //Builds the button panel.
        buildButtonPanel();
        //Adds it to the JFrame content pane
        add(buttonPanel, BorderLayout.PAGE_END);
        buildDecksPanel();
        add(leftDeckPanel, BorderLayout.LINE_START);
        add(rightDeckPanel, BorderLayout.LINE_END);
        buildCounterPanel();
        add(counterPanel, BorderLayout.PAGE_START);
        buildCardsPanel();
        add(cardsPanel, BorderLayout.CENTER);
        setVisible(true);

        
    }

    
    private void buildButtonPanel(){
       
        playCardButton = new JButton("Draw");
        playCardButton.setPreferredSize(new Dimension(100,50));

       
        playCardButton.addActionListener(new PlayCardListener());

        //Add the buttons to the panel.
        buttonPanel = new JPanel();
        buttonPanel.add(playCardButton);
        //Set the panel color to a nice blueish color which is not one of the standard colors available.
        buttonPanel.setBackground(Color.WHITE);
    }

    
    private void buildCardsPanel(){
        
        blank = new ImageIcon();

        playerCardLabel = new JLabel(blank);
        computerCardLabel = new JLabel(blank);

        cardsPanel = new JPanel();
        cardsPanel.add(playerCardLabel);
        cardsPanel.add(computerCardLabel);
        cardsPanel.setBackground(new Color(89, 3, 67));
        cardsPanel.setPreferredSize(new Dimension(600, 600));
    }

    
    private void buildDecksPanel(){
        
        blankCard = new ImageIcon(BLANK);
        blankCard2 = new ImageIcon(BLANK);

        blankCardLabelLeft = new JLabel();
        blankCardLabelLeft.setIcon(blankCard);
        blankCardLabelRight = new JLabel();
        blankCardLabelRight.setIcon(blankCard);

        rightDeckPanel = new JPanel();
        rightDeckPanel.setPreferredSize(new Dimension(152,213));
        rightDeckPanel.add(blankCardLabelRight);
        leftDeckPanel = new JPanel();
        leftDeckPanel.setPreferredSize(new Dimension(152,213));
        leftDeckPanel.add(blankCardLabelLeft);

        leftDeckPanel.setBackground(Color.GRAY);
        rightDeckPanel.setBackground(Color.GRAY);
    }

    
    private void buildCounterPanel(){

        playerCardsLeft = new JTextField("Player's Cards: 26", 26);
        computerCardsLeft = new JTextField("Computer's Cards: 26", 26);

        playerCardsLeft.setEditable(false);
        computerCardsLeft.setEditable(false);

        counterPanel = new JPanel();
        counterPanel.add(playerCardsLeft);
        counterPanel.add(computerCardsLeft);
    }

    /**
     *monitors clicks of the Play Card button
     */
    private class PlayCardListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
           
            if (war.equals("last")){
                
                playerCard = new ImageIcon(game.getWarPlayerCard());
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(game.getWarComputerCard());
                computerCardLabel.setIcon(computerCard);

                
                war = "final";
            }

            
            if (war.equals("true")){
                playerCard = new ImageIcon(BLANK);
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(BLANK);
                computerCardLabel.setIcon(computerCard);

                war = "last";
            }

            if (war.equals("false")){
                Card playersCard = game.playerDraw();
                Card computersCard = game.computerDraw();

                playerCard = new ImageIcon(playersCard.getCardPic());
                playerCardLabel.setIcon(playerCard);

                computerCard = new ImageIcon(computersCard.getCardPic());
                computerCardLabel.setIcon(computerCard);

                game.battle(playersCard, computersCard);

                if (playersCard.equals(computersCard)){
                    war = "true";
                    JOptionPane.showMessageDialog(null, "WAR!");
                }

               if (!war.equals("true")){
                    playerCardsLeft.setText("Player's Cards: " + (game.getPlayersCardsRemaining() - 1));
                    computerCardsLeft.setText("Computer's Cards: " + (game.getComputersCardsRemaining() - 1));

                }
            }

           if (war.equals("final")){
                war = "false";
                playerCardsLeft.setText("Player's Cards: " + (game.getPlayersCardsRemaining() - 1));
                computerCardsLeft.setText("Computer's Cards: " + (game.getComputersCardsRemaining() - 1));
            }
        }
    }

   	public static void main(String[] args) {
		WarGUI wg = new WarGUI();

	}

}
