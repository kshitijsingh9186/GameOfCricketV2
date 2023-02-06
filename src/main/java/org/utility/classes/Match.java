package org.utility.classes;

import java.util.Random;

public abstract class Match {
    private Team teamFirst;
    private Team teamSecond;
    public final int NUMBEROFBALLS;

    Match(int numberOfBalls)
    {
        NUMBEROFBALLS = numberOfBalls;
        teamFirst = new Team();
        teamSecond = new Team();
        initializeTeamRuns();
    }
    private void setRuns(Team team) {
        for(int ball = 1; ball<=NUMBEROFBALLS;ball++) {
            team.ballOutome((new Random()).nextInt(8));
            if(!team.canPlay())
                break;
        }
    }
    public void setFirstTeamRuns()
    {
         setRuns(teamFirst);
    }
    public int getFirstTeamRuns()
    {
       return teamFirst.getRuns();
    }
    public void setSecondTeamRuns()
    {
         setRuns(teamSecond);
    }
    public int getSecondTeamRuns()
    {
        return teamSecond.getRuns();
    }
    public void initializeTeamRuns()
    {
        setRuns(teamFirst);
        setRuns(teamSecond);
    }
}
