package day13.part2;

import day13.part2.engine.*;
import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import lilmachine.io.input.InputHandler;
import lilmachine.io.output.ListenerOutputHandler;
import utils.InfiniteGrid;

import java.io.FileNotFoundException;

public class ArcadeMachine implements ArcadeMachineOutputListener, Renderable {

    private final InfiniteGrid<Long> grid;
    private LilMachine machine;

    private final ListenerOutputHandler outputHandler;

    public ArcadeMachine(){
        try {
            machine = new LilMachine(new ProgramReader().readProgram("day13.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        grid = new InfiniteGrid<>(0L);

        outputHandler = new ListenerOutputHandler();

        TileBuildingOutputHandler tileBuildingOutputHandler = new TileBuildingOutputHandler();
        tileBuildingOutputHandler.addListener(this);



        outputHandler.addListener(tileBuildingOutputHandler);
        machine.setOutputHandler(outputHandler);
    }

    @Override
    public void initialise(ProgramViewer programViewer) {
        outputHandler.addListener(output -> programViewer.draw());
    }

    public void turnOn(){
        machine.computeProgram();

    }

    @Override
    public void render(Screen screen) {
        for (int i = 0; i < grid.getWidth(); i++) {
            for (int j = 0; j < grid.getHeight(); j++) {
                switch(Tile.getTileFromID(grid.getElementAt(i, j).intValue())){
                    case EMPTY -> screen.render(i, j, Color.getRGB(0, 0, 0));
                    case WALL -> screen.render(i, j, Color.getRGB(100, 100, 100));
                    case BLOCK -> screen.render(i, j, Color.getRGB(60, 190, 60));
                    case PADDLE -> screen.render(i, j, Color.getRGB(100, 100, 200));
                    case BALL -> screen.render(i, j, Color.getRGB(195, 20, 20));
                }
            }
        }
    }

    @Override
    public void sendNewTile(int x, int y, int tileID) {
        grid.set((long) tileID, x, y);
    }

    @Override
    public void updateScore(long score) {
        System.out.println(score);
    }

    public InfiniteGrid<Long> getGrid() {
        return grid;
    }

    public void setInputHandler(InputHandler inputHandler){
        machine.setInputHandler(inputHandler);
    }
}
