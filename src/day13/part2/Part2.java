package day13.part2;

import day13.part2.engine.*;

public class Part2 implements BasicGame {
    private static final int HEIGHT = 24;
    private static final int WIDTH = 42;
    private static final int SCALE = 12;

    private final ArcadeMachine arcadeMachine;
//    private final PlayableInputHandler playableInputHandler;

    private int controllerState;

    public Part2(ArcadeMachine arcadeMachine){
        this.arcadeMachine = arcadeMachine;
//        playableInputHandler = new PlayableInputHandler();
//        arcadeMachine.setInputHandler(playableInputHandler);
        arcadeMachine.setInputHandler(new AutomaticArcadeInputHandler(arcadeMachine.getGrid()));
    }

    @Override
    public void init(GameLoop gameLoop) {
//        gameLoop.addKeyListener(playableInputHandler);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < arcadeMachine.getGrid().getWidth(); i++) {
            for (int j = 0; j < arcadeMachine.getGrid().getHeight(); j++) {
                switch(Tile.getTileFromID(arcadeMachine.getGrid().getElementAt(i, j).intValue())){
                    case EMPTY -> screen.render(i, j, Color.getRGB(0, 0, 0));
                    case WALL -> screen.render(i, j, Color.getRGB(100, 100, 100));
                    case BLOCK -> screen.render(i, j, Color.getRGB(60, 190, 60));
                    case PADDLE -> screen.render(i, j, Color.getRGB(100, 100, 200));
                    case BALL -> screen.render(i, j, Color.getRGB(195, 20, 20));
                }
            }
        }
    }

    public static void main(String[] args) {
        ArcadeMachine arcadeMachine = new ArcadeMachine();
        new GameLoop("Braker", new Part2(arcadeMachine), WIDTH, HEIGHT, SCALE).start();
        arcadeMachine.turnOn();
    }
}
