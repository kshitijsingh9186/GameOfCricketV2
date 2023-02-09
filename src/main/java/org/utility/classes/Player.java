package org.utility.classes;


public class Player {
    private String name;
    private int runsScored;
    private int wicketsTaken;
    private int numberOfOversBowled;
    private BattingStatus battingStatus;
    private int runsGiven;
    private int battingPower;
    private int bowlingPower;
    private String wicketBy;
    private int numberOfBallsPlayed;
    private int numberOfFours;

    private int numberOfSixes;

    Player(String teamName, int serialNumber) {
        name = teamName +" Player " +serialNumber;
        battingStatus = BattingStatus.YETTOBAT;
    }

    public int getNumberOfFours() {
        return numberOfFours;
    }

    public void setNumberOfFours(int numberOfFours) {
        this.numberOfFours = numberOfFours;
    }

    public int getNumberOfSixes() {
        return numberOfSixes;
    }

    public void setNumberOfSixes(int numberOfSixes) {
        this.numberOfSixes = numberOfSixes;
    }

    public String getWicketBy() {
        return wicketBy;
    }

    public void setWicketBy(String wicketBy) {
        this.wicketBy = wicketBy;
    }

    public int getNumberOfBallsPlayed() {
        return numberOfBallsPlayed;
    }

    public void setNumberOfBallsPlayed(int numberOfBallsPlayed) {
        this.numberOfBallsPlayed = numberOfBallsPlayed;
    }


    public int getNumberOfOversBowled() {
        return numberOfOversBowled;
    }

    public void setNumberOfOversBowled(int numberOfOversBowled) {
        this.numberOfOversBowled = numberOfOversBowled;
    }

    public BattingStatus getBattingStatus() {
        return battingStatus;
    }

    public void setBattingStatus(BattingStatus battingStatus) {
        this.battingStatus = battingStatus;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public void increaseRunsGiven(int runs) {
        runsGiven += runs;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public String getName() {
        return name;
    }

    public void setRunsScored(int runs) {
        this.runsScored = runs;
    }

    private void increaseRunsScored(int ballToken) {
        runsScored += ballToken;
    }

    public int getWickets() {
        return wicketsTaken;
    }

    public void setWickets(int wickets) {
        this.wicketsTaken = wickets;
    }

    public void increaseWicket() {
        wicketsTaken++;
    }

    public void bowlingOutcome(int ballToken) {
        if (ballToken <= 6)
            increaseRunsGiven(ballToken);
        else
            increaseWicket();
    }

    public void battingOutCome(int ballToken, Player bowler) {
        setNumberOfBallsPlayed(getNumberOfBallsPlayed() + 1);
        if (ballToken == 4) setNumberOfFours(getNumberOfFours() + 1);
        if (ballToken == 6) setNumberOfSixes(getNumberOfSixes() + 1);
        if (ballToken <= 6)
            increaseRunsScored(ballToken);
        else
            fallWicket(bowler.name);
    }

    private void fallWicket(String bowlerName) {
        setBattingStatus(BattingStatus.OUT);
        setWicketBy(bowlerName);
    }

    public double getStrikeRate() {
        if (getNumberOfBallsPlayed() == 0)
            return 0.0;
        return ((double) (getRunsScored()) / (double) (getNumberOfBallsPlayed())) * 100.0;
    }

    public Double getEconomy() {
        if (getNumberOfOversBowled() == 0) return 0.0;
        return (double) (getRunsGiven()) / (double) (getNumberOfOversBowled());
    }
}
