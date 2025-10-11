package LevelSystem.DemoFiles;

import LevelSystem.LevelObjective;

import java.io.IOException;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {

        List<LevelObjective> demoLevelObjectives = List.of(
                new DemoLevelObjective(0, 4),
                new DemoLevelObjective(0, 4)
        );
    }
}
