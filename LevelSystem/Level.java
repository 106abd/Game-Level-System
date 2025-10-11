package LevelSystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Level {

    private int levelID;
    private String levelName;
    protected List<LevelObjective> levelObjectives;
    private boolean levelUnlocked = false;
    private boolean levelCompleted = false;
    protected boolean[] objectivesCompleted;


    public Level(int levelID, String levelName, List<LevelObjective> levelObjectives) {
        this.levelID = levelID;
        this.levelName = levelName;
        this.levelObjectives = levelObjectives;
        this.objectivesCompleted = new boolean[levelObjectives.size()];
    }

    public int getLevelID() { return levelID; }
    public String getLevelName() { return levelName; }
    public boolean isLevelUnlocked() { return levelUnlocked; }
    public boolean isLevelCompleted() { return levelCompleted; }

    public void unlockLevel() { levelUnlocked = true; }
    public void completeLevel() { levelCompleted = true; }

    public abstract boolean setUpLevel();
    protected abstract void eventDispatcher(String event);
    protected void syncObjectiveCompletion(LevelObjective objective, int index) {
        if (objective.isCompleted()) {
            this.objectivesCompleted[index] = true;
        }
    }

    protected void areObjectivesComplete() {
        for (boolean completionStatus : objectivesCompleted) {
            if (!completionStatus) {
                return;
            }
        }
        completeLevel();
    }

}
