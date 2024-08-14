package BankGame;

import DeckOfCards.Deck;

public class Main
{
    public static void main(String[] args)
    {
        Game game = new Game();
        game.addPlayer("Ali");
        game.addPlayer("Ashir");
        game.addPlayer("Hamza");
        game.addPlayer("Rehan");

        System.out.println(game.deck.cardArrayList.size());

        game.deck.deckPrinter();
        game.begin();



        game.makeMove();
        game.makeMove();
        game.makeMove();
        game.makeMove();
        game.makeMove();
        game.makeMove();
        game.makeMove();
        game.makeMove();






        game.scoring();

    }
}
