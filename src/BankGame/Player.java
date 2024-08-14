package BankGame;

import DeckOfCards.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Player {

    String name ;
    List<Card> playersCard;
    Stack<Card> cardStack;


    // Constructor to initialize the player class
    public Player(String name){
        this.name=name;
        playersCard= new ArrayList<>();
        cardStack= new Stack<>();
    }

    // Getter for name
    public String getName(){
        return this.name;
    }

    // Function to add card to the player hand.
    public void pickCard(Card card){
        playersCard.add(card);
    }

    // function to drop card from the player hand
    public boolean dropCard(Card card){
        if (playersCard.contains(card)){
            playersCard.remove(card);
            return true;
        }else {
            System.out.println("the player does not have the card ");
            return false;
        }

    }


    // function to add card to the scoring stack
    public void scoreCard(Card card){
        cardStack.push(card);
    }

    // function to remove card from the player scoring stack.
    public void looseCard(Card card){cardStack.pop();}

    // function to check the card player has at the top of the scoring stack
    public Card checkCard(){return cardStack.peek();}

    // function to
    public int playerStackCardsNumber(){return cardStack.size();}








}
