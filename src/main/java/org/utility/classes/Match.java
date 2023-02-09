package org.utility.classes;

import java.util.Random;

public abstract class Match {
    private Team teamFirst;
    private Team teamSecond;
    private final int NUMBEROFOVERS;

    Match(int numberOfOvers) {
        NUMBEROFOVERS = numberOfOvers;
        teamFirst = new Team("TeamA", NUMBEROFOVERS);
        teamSecond = new Team("TeamB",NUMBEROFOVERS);
    }

    public void playGame() {
        playInnings(teamFirst, teamSecond);
        teamFirst.printBattingScorcard();
        teamSecond.printBowlingScorecard();
        System.out.println("---------------------Drinks Break declared by Ravi Shastri  ----------------------");
        playInnings(teamSecond, teamFirst);
        teamSecond.printBattingScorcard();
        teamFirst.printBowlingScorecard();
        printResult();
    }

    private void playInnings(Team battingTeam, Team bowlingTeam) {
        for (int over = 1; over <= NUMBEROFOVERS; over++) {
            completeOver(battingTeam, bowlingTeam.getNewBowler());
            if (battingTeam.allOut())
                break;
        }
    }

    public void completeOver(Team battingTeam, Player bowler) {
        for (int i = 1; i <= 6; i++) {
            int ballToken = getBallToken();
            //  System.out.println("Ball token =" +ballToken);
            battingTeam.ballOutcomeOnBatting(ballToken, bowler);
            bowler.bowlingOutcome(ballToken);
            if (battingTeam.allOut())
                return;
        }
    }

    public static int getBallToken() {
        double[] probability = {0.15, 0.35, 0.15, 0.05, 0.1, 0.05, 0.1, 0.05};
        int upperBound = 8;
        double random = (new Random()).nextDouble(1);
        // System.out.println(random);
        double totalProbability = 0.0;
        for (int i = 0; i < upperBound; i++) {
            totalProbability += probability[i];
            if (random <= totalProbability)
                return i;
        }
        return 0;
    }

    private void printResult() {
        if (teamFirst.getRuns() > teamSecond.getRuns())
            System.out.println("First Team won");
        else if (teamSecond.getRuns() > teamFirst.getRuns())
            System.out.println("Second Team won");
        else
            System.out.println("It's a tie");
    }
}
