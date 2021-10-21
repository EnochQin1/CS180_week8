package com.example.cs180.Week9;
/**
 * A class that writes the Game Log for the battleship game.
 *
 * Purdue University -- CS18000 -- Fall 2021 -- Project 03
 *
 * @author Enoch_Qin Purdue CS
 * @version October 21, 2021
 */
public class GameLog
{
    private int winningPlayer;
    private int losingPlayerHits;
    private int numTurns;
    private String boardPatternOne;
    private String boardPatternTwo;

    public GameLog(int winningPlayer, int losingPlayerHits, int numTurns,
                   String boardPatternOne, String boardPatternTwo)
    {
        this.winningPlayer = winningPlayer;
        this.losingPlayerHits = losingPlayerHits;
        this.numTurns = numTurns;
        this.boardPatternOne = boardPatternOne;
        this.boardPatternTwo = boardPatternTwo;
    }
    public String toString() {
        int player1;
        int player2;
        if (winningPlayer == 1) {
            player1 = 17;
            player2 = losingPlayerHits;
        } else {
            player1 = losingPlayerHits;
            player2 = 17;
        }
        return String.format("Battleship Game Log:\nWinning Player: Player %d\n" +
                "Hits: %d - %d\nNumber of Turns To Win: %d\nPlayer 1 Board Pattern: %s\n" +
                "Player 2 Board Pattern: %s", winningPlayer, player1, player2, numTurns,
                boardPatternOne, boardPatternTwo);
    }
}
