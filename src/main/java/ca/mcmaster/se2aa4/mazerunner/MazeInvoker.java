package ca.mcmaster.se2aa4.mazerunner;

public class MazeInvoker {
    private MazeCommand command;

    public void setCommand(MazeCommand command) {
        this.command = command;
    }

    public void runCommand() {
        if (command != null) {
            command.execute();
        }
    }
}
