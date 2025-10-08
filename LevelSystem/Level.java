package LevelSystem;

abstract class Level {

    private int levelID;
    private String levelName;
    private boolean levelUnlocked = false;
    private boolean levelCompleted = false;


    public Level(int levelID, String levelName) {
        this.levelID = levelID;
        this.levelName = levelName;
    }

    public int getLevelID() { return levelID; }
    public String getLevelName() { return levelName; }
    public boolean isLevelUnlocked() { return levelUnlocked; }
    public boolean isLevelCompleted() { return levelCompleted; }

    public void unlockLevel() { levelUnlocked = true; }
    public void completeLevel() { levelCompleted = true; }

    public abstract void setUpLevel();
}
