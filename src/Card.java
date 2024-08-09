public record Card(Suit suit,String rank)
{
    @Override
    public String toString(){

        return suit.getShape()+ " " + rank;

    }
}
