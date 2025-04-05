package ca.mcmaster.se2aa4.mazerunner;

public class PathFactory {

    public static PathStrategy getPathStrategy(String strategyType) {
        if ("FIND".equalsIgnoreCase(strategyType)) {
            return new FindPath();
        } else if ("CHECK".equalsIgnoreCase(strategyType)) {
            return new CheckPath();
        } else {
            throw new IllegalArgumentException("Invalid path strategy: " + strategyType);
        }
    }
}
