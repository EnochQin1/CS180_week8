package com.example.cs180.Week9;

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
        return String.format("Battleship Game Log:\nWinning Player: Player %d\n" +
                "Hits: %d - %d\nNumber of Turns To Win: %d\nPlayer 1 Board Pattern: %s\n" +
                "Player 2 Board Pattern: %s\n", winningPlayer, losingPlayerHits, numTurns, numTurns,
                boardPatternOne, boardPatternTwo);
    }
}
