package LevelSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelGraph {

    private Map<Integer, List<Integer>> levelProgression = new HashMap<>();
    private Map<Integer, List<Integer>> levelPrerequisites = new HashMap<>();

    public void connectLevel(int parentID, int childID) {

        levelProgression.computeIfAbsent(parentID, ignore ->
                new ArrayList<>()
        ).add(childID);

        levelPrerequisites.computeIfAbsent(childID, ignore ->
                new ArrayList<>()
        ).add(parentID);
    }

    public List<Integer> getNewLevels(int parentID) {
        return levelProgression.getOrDefault(parentID, List.of());
    }

    public List<Integer> getPrerequisiteLevels(int childID) {
        return levelPrerequisites.getOrDefault(childID, List.of());
    }

}
