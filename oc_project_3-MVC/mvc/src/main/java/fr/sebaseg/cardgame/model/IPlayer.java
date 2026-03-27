package fr.sebaseg.cardgame.model;

public interface IPlayer {
    void addCardToHand(PlayingCard pc);
    
    PlayingCard getCard(int index);

    PlayingCard removeCard();

    String getName();
}