package org.utility.classes;

import org.utility.classes.Player;

import java.util.Random;

public class Team {
    public static final int TOTALNUMBEROFPLAYERS = 11;
    public static final int TOTALNUMBEROFBOWLERS = 6;
    private Player[] batsman = new Player[TOTALNUMBEROFPLAYERS];
    private Player[] bowlers = new Player[TOTALNUMBEROFBOWLERS];
    private int runs;
    private int wickets;
    private Player currentBowler;
    private Player currentBatsman;
    public int numberOfOvers;
    private final int maximumOversPerBowler;

    Team(int numberOfOvers) {
        this.numberOfOvers = numberOfOvers;
        maximumOversPerBowler = (int) (Math.ceil(((double) numberOfOvers) / ((double) TOTALNUMBEROFBOWLERS)));
        for (int i = 0; i < TOTALNUMBEROFPLAYERS; i++) {
            batsman[i] = new Player();
        }

        for (int i = 0; i < TOTALNUMBEROFBOWLERS; i++) {
            bowlers[i] = batsman[i + 5];
        }
        batsman[0].setBattingStatus(BattingStatus.NOTOUT);
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public boolean allOut() {
        return wickets >= TOTALNUMBEROFPLAYERS;
    }

    private void fallWicket() {
        wickets++;
        if (allOut()) return;
        batsman[wickets].setBattingStatus(BattingStatus.NOTOUT);
    }

    public void ballOutcomeOnBatting(int ballResult, Player bowler) {
        batsman[wickets].battingOutCome(ballResult, bowler);
        if (ballResult <= 6)
            setRuns(getRuns() + ballResult);
        else
            fallWicket();
    }

    public Player getNewBowler() {
        int bowlerIndex = (new Random()).nextInt(6);
//        while (currentBowler != null && (currentBowler == bowlers[bowlerIndex] ||
//                bowlers[bowlerIndex].getNumberOfOversBowled() < maximumOversPerBowler))
//            bowlerIndex = (new Random()).nextInt(6);
        currentBowler = bowlers[bowlerIndex];
        currentBowler.setNumberOfOversBowled(currentBowler.getNumberOfOversBowled() + 1);
        return currentBowler;
    }

    public void printBattingScorcard() {
        System.out.println("|  Batting            R  B  4s  6s  S/R  |");
        for (Player player : batsman) {
            System.out.println("|"+player.getName() + "(" + player.getBattingStatus() + ")" + "    " + player.getRunsScored() + "  "
                    + player.getNumberOfBallsPlayed() + "  " + player.getNumberOfFours() + "  " + player.getNumberOfSixes() + "  " +
                    player.getStrikeRate()+"|");
            System.out.println("--------------------------------------------------------------------");
        }
        System.out.println("Total Runs -" + getRuns());
    }

    public void printBowlingScorecard() {
        System.out.println();
        System.out.println("|  Bowling            O  R  W  Econ  |");
        for (Player bowler : bowlers) {
            if (bowler.getNumberOfOversBowled() == 0) continue;
            System.out.println("|"+ bowler.getName() + "           " + bowler.getNumberOfOversBowled() + "  " + bowler.getRunsGiven() +
                    "  " + bowler.getWickets() + "  " + bowler.getEconomy()+"|");
            System.out.println("----------------------------------------------------------------------");
        }
    }
}
