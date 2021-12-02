package day13.part1;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;
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

    public int countOccurrencesOf(long target){
        int occurences = 0;
        for(long l : grid)
            if(l == target)
                occurences++;
        return occurences;
    }

    @Override
    public void sendNewTile(int x, int y, int tileID) {
        grid.set((long) tileID, x, y);
    }

    @Override
    public void updateScore(long score) {

    }

    public InfiniteGrid<Long> getGrid() {
        return grid;
    }
}
