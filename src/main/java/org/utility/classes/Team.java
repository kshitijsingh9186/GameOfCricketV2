package org.utility.classes;

import org.utility.classes.Player;

public class Team {
    private Player[] players = new Player[11];
    private int runs;
    private int wickets;
    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }
    public boolean canPlay()
    {
        return wickets<10;
    }

    public void ballOutome(int ballResult)
    {
        System.out.println(ballResult);
        if(ballResult<=6)
            runs += ballResult;
        else
            wickets++;
    }

}
