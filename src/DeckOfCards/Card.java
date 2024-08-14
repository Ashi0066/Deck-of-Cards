package DeckOfCards;

public record Card(Suit suit, String rank)
{
    @Override
    public String toString(){

        return  rank+suit.getShape()+" ";

    }
}
