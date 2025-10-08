package LevelSystem;

public class DebugLevelObjective implements LevelObjective {

    private int counter;
    private final int counterLimit;

    public DebugLevelObjective(int counter, int counterLimit) {
        this.counter = counter;
        this.counterLimit = counterLimit;
    }

    private void incrementCounter() { counter++; }

    @Override
    public boolean isCompleted() {

        if (counter >= counterLimit) {
            return true;
        }

        incrementCounter();
        return false;
    }
}
