# Using MVC and SOLID Principles

Project based on the OpenClassrooms course: [Écrivez du code Java maintenable avec MVC et SOLID](https://openclassrooms.com/fr/courses/6810956-ecrivez-du-code-java-maintenable-avec-mvc-et-solid).

## Architecture

This project was built using **Maven** with the `quickstart` archetype.

## Compile and Run

To build and launch the application, run the following commands:

```bash
cd ./mvc
mvn package
java -cp target/mvc-1.0-SNAPSHOT.jar fr.sebaseg.cardgame.games.Games
```

## Game Rules & Features

This is a simple card game with the following logic:

* **Deck:** Uses a standard 52-card deck.
* **Players:** Supports up to 5 players with custom names.
* **Gameplay:**
    * The deck is **shuffled**.
    * Each player is dealt a single face-down card.
    * All players reveal their cards simultaneously.
* **Winning Conditions:**
    * The winner is the player with the highest card value (**Ace > King > Queen > Jack > 10 > ... > 2**).
    * In case of a **tie (draw)**, the suit determines the winner by priority: **Clubs > Spades > Hearts > Diamonds**.
* **End of Round:**
    * The app displays the players' names and their respective cards.
    * All cards are returned to the deck.
    * The game resets and can be played again with the full deck.