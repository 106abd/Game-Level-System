package LevelSystem.DemoFiles;

import LevelSystem.LevelObjective;

public class DemoLevelObjective implements LevelObjective {

    private boolean isObjectiveComplete = false;
    private int counter;
    private final int counterLimit;
    private final int initialValue;


    public DemoLevelObjective(int initialValue, int counterLimit) {
        this.initialValue = initialValue;
        this.counter = this.initialValue;
        this.counterLimit = counterLimit;
    }

    private void incrementCounter() { counter++; }

    @Override
    public void handleEvent(String event) {
        if (event.equals("DemoEvent")) {
            incrementCounter();
        }
    }

    @Override
    public void isObjectiveComplete() {
        if (counter >= counterLimit) {
            isObjectiveComplete = true;
        } else {
            isObjectiveComplete = false;
        }
    }

    @Override
    public boolean isCompleted() {
        return isObjectiveComplete;
    }
}
