package day13.part2;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import lilmachine.io.input.InputHandler;
import utils.InfiniteGrid;

import java.io.FileNotFoundException;

public class ArcadeMachine implements ArcadeMachineOutputListener {

    private final InfiniteGrid<Long> grid;
    private LilMachine machine;

    public ArcadeMachine(){
        try {
            machine = new LilMachine(new ProgramReader().readProgram("day13.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        grid = new InfiniteGrid<>(0L);

        TileBuildingOutputHandler outputHandler = new TileBuildingOutputHandler();
        outputHandler.addListener(this);
        machine.setOutputHandler(outputHandler);
    }

    public void turnOn(){
        machine.computeProgram();
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
