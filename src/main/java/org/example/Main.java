package org.example;

import org.utility.classes.TwentyTwenty;

public class Main {
    public static void main(String[] args) {
      TwentyTwenty twentyTwentyMatch = new TwentyTwenty();
        System.out.println("First team runs = "+twentyTwentyMatch.getFirstTeamRuns());
        System.out.println("Second team runs = "+twentyTwentyMatch.getSecondTeamRuns());
        if(twentyTwentyMatch.getFirstTeamRuns()>twentyTwentyMatch.getSecondTeamRuns())
            System.out.println("First Team Wins!!!!");
        else if(twentyTwentyMatch.getFirstTeamRuns()<twentyTwentyMatch.getSecondTeamRuns())
            System.out.println("Second Team Wins!!!!");
        else
            System.out.println("It's a tie");
    }

}