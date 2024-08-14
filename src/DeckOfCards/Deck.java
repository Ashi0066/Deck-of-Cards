package DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck
{


    public static Deck intsance;



   public ArrayList<Card> cardArrayList;

    public Deck(){
        cardArrayList= new ArrayList<>();


    }

    public static Deck getInstance(){
        if (intsance==null){
            intsance = new Deck();
        }
        return intsance;
    }


    public void intializeDeck(){
        for (Suit suit: Suit.values()){
            for (int i =2 ; i<=14;i++){

                if (i>=11){
                    cardArrayList.add(new Card(suit,cardShapes(i)));
                }else
                {

                    cardArrayList.add(new Card(suit, String.valueOf(i)));
                }

            }

        }
    }

    public String cardShapes(int number){
        return switch (number){
            case 11-> "K";
            case 12 -> "Q";
            case 13 -> "J";
            case 14 -> "A";


            default -> throw new IllegalStateException("Unexpected value: " + number);
        };
    }

    public void deckPrinter(){
        System.out.println("-".repeat(40));

        for(int i = 0 ; i<cardArrayList.size();i++){

            Card card= cardArrayList.get(i);
            if (i%13==0){
                System.out.println();
                System.out.println(card.suit());
            }
            System.out.print(cardArrayList.get(i));

        }
        System.out.println();


    }



    public void deckPrinter2(){

        System.out.println("-".repeat(30));
        System.out.println("Printing the deck");

       Suit suit = null;


        for (Card card : cardArrayList)
        {
            if (card.suit()!=suit){
                System.out.println();
                suit = card.suit();
                System.out.println(suit);
            }


            System.out.print(card.rank());
            System.out.print(suit.getShape());
            System.out.print(" ");


        }
        System.out.println();
        System.out.println("-".repeat(30));
        System.out.println();







    }

    public Card getRandomCard(){


        Random random = new Random();
        Card card= cardArrayList.get(random.nextInt(2,36));
        return card;
    }

    public void shuffle(){
        Collections.shuffle(cardArrayList);
    }








    public String toString(){
        return cardArrayList.toString();
    }






}
