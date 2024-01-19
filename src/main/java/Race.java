public class Race {

    private long time;
    private long distanceGoal;
    private long numWaysToWin;

    public Race(long time, long distance) {
        this.time = time;
        this.distanceGoal = distance;

        simulateRaces();
    }

    private void simulateRaces() {
        for (long i = 0; i <= time; i++) {
            // speed increases by 1 per unit of time spend charging
            long speed = i;
            long timeRemaining = time-i;
            long distance = speed * timeRemaining;
            if (distance > distanceGoal){
                this.numWaysToWin++;
            }
        }
    }

    public long getNumWaysToWin(){
        return numWaysToWin;
    }

}
