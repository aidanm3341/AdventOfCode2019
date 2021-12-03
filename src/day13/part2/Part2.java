package day13.part2;

import day13.part2.engine.*;

public class Part2 {
    private static final int HEIGHT = 24;
    private static final int WIDTH = 42;
    private static final int SCALE = 12;


    public static void main(String[] args) {
        ArcadeMachine arcadeMachine = new ArcadeMachine();
        arcadeMachine.setInputHandler(new AutomaticArcadeInputHandler(arcadeMachine.getGrid()));
        ProgramViewer loop = new ProgramViewer("Braker", arcadeMachine, WIDTH, HEIGHT, SCALE);
        arcadeMachine.turnOn();
    }
}
