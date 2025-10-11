package LevelSystem;

import java.util.*;

public class LevelManager {

    private Level currentLevel = null;
    private HashMap<Integer, Level> levels = new HashMap<>();
    private final LevelGraph levelGraph = new LevelGraph();

    public void registerLevel(Level level) {
        int levelID = level.getLevelID();
        levels.put(levelID, level);
    }

    public void connectLevels(int parentID, int childID) {
        levelGraph.connectLevel(parentID, childID);
    }

    public void startLevel(int levelID) {
        Level level = levels.get(levelID);
        if (level != null && level.isLevelUnlocked()) {
            currentLevel = level;
            currentLevel.setUpLevel();
        }
    }

    public void completeLevel(int levelID) {
        Level level = levels.get(levelID);
        if (level != null) {
            level.completeLevel();
            unlockLevels(levelID);
        }
    }

    public void unlockLevels(int parentID) {
        for (int childID : levelGraph.getNewLevels(parentID)) {
            List<Integer> prerequisiteLevels = levelGraph.getPrerequisiteLevels(childID);

            for (int levelID : prerequisiteLevels) {
                Level level = levels.get(levelID);
                if (level != null && !level.isLevelCompleted()) {
                    return;
                }
            }

            Level unlockedLevel = levels.get(childID);
            unlockedLevel.unlockLevel();
        }
    }
}
