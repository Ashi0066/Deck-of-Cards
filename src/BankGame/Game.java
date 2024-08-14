package BankGame;


import DeckOfCards.Card;
import DeckOfCards.Deck;

import java.util.*;


/*

       This is a game built using on the principles of a common game called bank.
       Which includes picking up card from a deck of cards.
       Every card has a specific score.
       The player with the highest score wins the game.


* */

public class Game
{

    // List to store players
    List<Player> playerList;

    // Get an instance of the deck class
    Deck deck = Deck.getInstance();

    // Stack to hold cards which goes in a stack after the game starts.
    Stack<Card> cardStack;

    // Cards which are on display o the ground where the player can access any card
    List<Card> displayCards;


    // Initialization class

    public Game()
    {
        deck.intializeDeck();

        playerList = new ArrayList<>();
        displayCards = new ArrayList<>();
        cardStack = new Stack<>();


    }


    // Add player in the game

    public void addPlayer(String name)
    {
        if (playerList.size() <= 4)
        {
            Player player = new Player(name);
            playerList.add(player);
            System.out.println(player.getName() + " added ");
        } else
        {
            System.out.println("Game can not have more than 4 player ");
        }
    }

    // Remove player from the game
    public boolean removePlayer(Player name)
    {
        for (int i = 0; i < playerList.size(); i++)
        {
            Player player = playerList.get(i);
            if (player.getName().equals(name.toString()))
            {
                playerList.remove(player);
                return true;
            }

        }
        return false;

    }


    // Function to count player score based on the card provided it takes a string and return the score for that card
    public int scoreTable(Card card)
    {

        String rank = card.rank();


        try
        {
            int score = Integer.parseInt(rank);
            if (score >= 2 && score <= 10 )
            {
                return 5;
            }
        }catch (NumberFormatException e){

        }

            return switch (card.rank())
            {
                case "K", "J", "Q" -> 10;
                case "A" -> 20;
                default -> throw new IllegalStateException("Unexpected value: " + card.rank());
            };



    }



    // Function to start the game
    public void begin()
    {
        for (Player player : playerList)
        {


            for (int j = 0; j < 4; j++)
            {
                Card card = deck.getRandomCard();
                player.pickCard(card);
                deck.cardArrayList.remove(card);
            }


        }
        setDisplayCards();
        deck.shuffle();
        cardStack.addAll(deck.cardArrayList);
        System.out.println("Stack of cards"+cardStack);


    }


    // Function to add cards in the display at the start of the game.
    public void setDisplayCards()
    {

        if (displayCards.isEmpty())
        {

            for (int i = 0; i < 4; i++)
            {

                Card card = deck.cardArrayList.get(i);
                displayCards.add(card);
                deck.cardArrayList.remove(card);

            }
            return;
        }
        while (displayCards.size() > 4)
        {
            displayCards.add(cardStack.pop());

        }


    }


    //  Makes a complete move everytime it is called
    public void makeMove()
    {



        // for every player in the player list, we check and move individually
        for (Player player : playerList)
        {

            // if the player has less than 4 cards we continue picking up cards. i.e pop cards from the cards stack
            while (player.playersCard.size() < 4 && !cardStack.empty())
            {

               player.pickCard(cardStack.pop());
            }


            while (player.playersCard.size() > 5)
            {
                Random random = new Random();
                int randomIndex = random.nextInt(player.playersCard.size());
                Card card = player.playersCard.get(randomIndex);
                player.dropCard(card);

            }

            boolean matchfound = false;
            for (int i = 0; i < player.playersCard.size()-1; i++)
            {

                Card card = player.playersCard.get(i);

                for (int j = 0; j < displayCards.size()-1; j++)
                {
                    if (card.rank().equals(displayCards.get(j).rank()))
                    {

                        player.scoreCard(card);
                        player.scoreCard(displayCards.get(j));
                        player.playersCard.remove(i);
                        displayCards.remove(j);



                        int nextPlayer = i+1;



                        Player player1 = playerList.get(nextPlayer);
                        if (player1.playerStackCardsNumber()>1&&card.rank().equals(player1.checkCard().rank())){
                            if (nextPlayer>playerList.size()){break;}
                            player.scoreCard(card);
                            player.scoreCard(displayCards.get(j));

                            player.playersCard.remove(i);

                        }


                        matchfound = true;
                        break;



                    }
                }



                if (matchfound) break;

            }
            if (!matchfound && !player.playersCard.isEmpty())
            {
                displayCards.add(player.playersCard.remove(0));
            }

            while (player.playersCard.size()>4){
                player.dropCard(player.playersCard.remove(player.playersCard.size()-1));
            }

            System.out.println(player.getName()+ "Stack " + player.cardStack);


        }


    }




    // Lists scores of the player

    public void scoring()
    {

        int highestScore = 0 ;
        String winnerName ="";
        List<Integer> rank = new ArrayList<>();

        for (Player player : playerList){

            int score = 0 ;

            for (Card card: player.cardStack){

                score+=scoreTable(card);
            }

            if (score>highestScore){
                highestScore=score;
                winnerName=player.name;
            }


            System.out.println(player.name +" score: "+score);


        }

        System.out.println("Congratulations  "+ "\033[1m" +winnerName +"\033[0m"+ " have won the game with score of  "+highestScore);








    }


}
