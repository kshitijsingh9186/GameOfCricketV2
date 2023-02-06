package org.utility.classes;

public class Player {


    private String name;
    private int runs;
    private int wickets;
    private int battingPower;
    private int bowlingPower;
    public int getRuns() {
        return runs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }


}
