package day13.part2;

import day13.part2.engine.*;

public class Part2 implements BasicGame {
    private static final int HEIGHT = 24;
    private static final int WIDTH = 42;
    private static final int SCALE = 12;

    private final ArcadeMachine arcadeMachine;
    private PlayableInputHandler playableInputHandler;
//    private InputHandler inputHandler;

    private int controllerState;

    public Part2(ArcadeMachine arcadeMachine){
        this.arcadeMachine = arcadeMachine;
        playableInputHandler = new PlayableInputHandler();
        arcadeMachine.setInputHandler(playableInputHandler);
    }

    @Override
    public void init(GameLoop gameLoop) {
        gameLoop.addKeyListener(playableInputHandler);
//        inputHandler = new InputHandler(gameLoop);
    }

    @Override
    public void update() {
//        if(inputHandler.left.down)
//            controllerState = -1;
//        else if(inputHandler.right.down)
//            controllerState = 1;
//        else
//            controllerState = 0;
    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < arcadeMachine.getGrid().getWidth(); i++) {
            for (int j = 0; j < arcadeMachine.getGrid().getHeight(); j++) {
                switch(arcadeMachine.getGrid().getElementAt(i, j).intValue()){
                    case 0 -> screen.render(i, j, Color.getRGB(0, 0, 0));
                    case 1 -> screen.render(i, j, Color.getRGB(100, 100, 100));
                    case 2 -> screen.render(i, j, Color.getRGB(60, 190, 60));
                    case 3 -> screen.render(i, j, Color.getRGB(100, 100, 200));
                    case 4 -> screen.render(i, j, Color.getRGB(195, 20, 20));
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
