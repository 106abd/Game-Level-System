package LevelSystem.DemoFiles;

import LevelSystem.Level;
import LevelSystem.LevelObjective;

import java.util.List;

public class DemoLevel extends Level {
    public DemoLevel(int levelID, String levelName, List<LevelObjective> levelObjectives) {
        super(levelID, levelName, levelObjectives);
    }

    @Override
    public boolean setUpLevel() {
        System.out.println("Level successfully setup");
        return true;
    }

    @Override
    protected void eventDispatcher(String event) {
        for (int index = 0; index <= objectivesCompleted.length; index++) {
            LevelObjective objective = levelObjectives.get(index);
            objective.handleEvent(event);
            syncObjectiveCompletion(objective, index);
        }
        areObjectivesComplete();
    }
}
