package fr.sebaseg.cardgame.games;

import java.util.List;

import fr.sebaseg.cardgame.model.Player;
import fr.sebaseg.cardgame.model.PlayingCard;

public interface GameEvaluator {
    public Player evaluateWinner(List<Player> players);
}