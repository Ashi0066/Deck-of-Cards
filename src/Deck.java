import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck
{

    ArrayList<Card> cardArrayList;

    public Deck(){
        cardArrayList= new ArrayList<>();


    }



    public void intializeDeck(){
        for (Suit suit:Suit.values()){
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

    public void getRandomCard(){


        Random random = new Random();
        System.out.println("-----".repeat(20));
        Card card= cardArrayList.get(random.nextInt(2,36));

        System.out.println("Randomly selected card "+ card.suit() + " " + card.rank());



        System.out.println(card);
    }








    public String toString(){
        return cardArrayList.toString();
    }






}
