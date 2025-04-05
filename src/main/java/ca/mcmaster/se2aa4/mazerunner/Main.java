package ca.mcmaster.se2aa4.mazerunner;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();
        Maze maze = new Maze();
        DisplayResults displayResults = new DisplayResults();
        MazeInvoker invoker = new MazeInvoker();

        player.PlayerFlags(args);
        maze.InitializeMaze(args);
        maze.displayMazeArray();

        String inputFlag = player.getInputFlag();
        String checkPathFlag = player.getCheckPathFlag();

        if (inputFlag.equals("-i")) {
            invoker.setCommand(new FindPathCommand(displayResults, maze.getStartingXCoordinate(), maze.getStartingYCoordinate(), maze.getMazeArray(), maze.getRows(), maze.getCols()));
            invoker.runCommand();
        }

        if (checkPathFlag.equals("-p")) {
            invoker.setCommand(new CheckPathCommand(displayResults, maze.getStartingXCoordinate(), maze.getStartingYCoordinate(), maze.getMazeArray(), maze.getRows(), maze.getCols(), player.getGivenMazePath()));
            invoker.runCommand();
        }
    }
}
