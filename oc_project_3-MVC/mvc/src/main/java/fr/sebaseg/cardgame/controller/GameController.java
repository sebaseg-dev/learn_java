package fr.sebaseg.cardgame.controller;

import java.util.ArrayList;
import java.util.List;

import fr.sebaseg.cardgame.model.*;
import fr.sebaseg.cardgame.view.GameViewable;
import fr.sebaseg.cardgame.games.GameEvaluator;

public class GameController {
    
    enum GameState {
        AddingPlayers, CardsDealt, WinnerRevealed
    }
    
    Deck deck;
    List<IPlayer> Players;
    IPlayer winner;
    GameViewable view;
    
    GameState gameState;
    GameEvaluator evaluator;
    
    public GameController(Deck deck, GameViewable view, GameEvaluator gameEvaluator) {
        super();
        this.deck = deck;
        this.view = view;
        this.Players = new ArrayList<IPlayer>();
        this.gameState = GameState.AddingPlayers;
        view.setController(this);
        this.evaluator = gameEvaluator;
    }
    
    public void run() {
        while (gameState == GameState.AddingPlayers) {
            view.promptForPlayerName();
        }
        
        switch (gameState) {
            case CardsDealt:
                view.promptForFlip();
                break;
            case WinnerRevealed:
                view.promptForNewGame();
                break;
        }
    }
    
    public void addPlayer(String playerName) {
        if (gameState == GameState.AddingPlayers) {
            Players.add(new Player(playerName));
            view.showPlayerName(Players.size(), playerName);
        }
    }
    
    public void startGame() {
        if (gameState != GameState.CardsDealt) {
            deck.shuffle();
            int playerIndex = 1;
            for (IPlayer Player : Players) {
                Player.addCardToHand(deck.removeTopCard());
                view.showFaceDownCardForPlayer(playerIndex++, Player.getName());
            }
            gameState = GameState.CardsDealt;
        }
        this.run();
    }
    
    public void flipCards() {
        int playerIndex = 1;
        for (IPlayer Player : Players) {
            PlayingCard pc = Player.getCard(0);
            pc.flip();
            view.showCardForPlayer(
                    playerIndex++,
                    Player.getName(),
                    pc.getRank().toString(),
                    pc.getSuit().toString()
            );
        }
        
        evaluateWinner();
        
        displayWinner();
        
        rebuildDeck();
        gameState = GameState.WinnerRevealed;
        this.run();
    }
    
    void evaluateWinner() {
        winner = new WinningPlayer(evaluator.evaluateWinner(Players));
    }
    
    void displayWinner() {
        view.showWinner(winner.getName());
    }
    
    void rebuildDeck() {
        for (IPlayer Player : Players) {
            deck.returnCardToDeck(Player.removeCard());
        }
    }
    
    void exitGame() {
        System.exit(0);
    }
    
    public void nextAction(String nextChoice) {
        if("+q".equals(nextChoice)) {
            exitGame();
        } else {
            startGame();
        }
    }
}