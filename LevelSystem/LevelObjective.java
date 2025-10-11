package LevelSystem;

public interface LevelObjective {
    public void handleEvent(String event);
    public void isObjectiveComplete();
    public boolean isCompleted();
}
