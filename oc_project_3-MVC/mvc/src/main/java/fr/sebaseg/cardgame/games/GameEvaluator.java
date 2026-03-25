package fr.sebaseg.cardgame.games;

import java.util.List;

import fr.sebaseg.cardgame.model.IPlayer;

public interface GameEvaluator {
    IPlayer evaluateWinner(List<IPlayer> Players);
}