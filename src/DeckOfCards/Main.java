package DeckOfCards;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        boolean flag = true;




        Deck deck= Deck.getInstance();
        deck.intializeDeck();
        Card card= deck.cardArrayList.get(9);
        System.out.println(card.rank());
        System.out.println(deck.cardArrayList.toString());
        String  display = """
                Press 1 to get random card.
                Press 2 to print the deck of cards.
                Press 3 to exit.""";


        while (flag){
            Deck deck1 = new Deck();
            deck1.intializeDeck();


            System.out.println(display);
            System.out.println("Please enter your choice here:: ");
            switch (sc.nextInt()){
                case 1-> deck.getRandomCard();
                case  2-> deck.deckPrinter2();
                case 3 -> flag=false;
                case 4 -> deck.deckPrinter();








        }
            System.out.println();







    }
}}
