package day11;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import lilmachine.io.output.OutputHandler;
import utils.InfiniteGrid;
import utils.Pair;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class Robot implements OutputHandler {

    private LilMachine brain;

    private final InfiniteGrid<Long> panel;
    private Direction direction;
    private int x, y;

    private int outputCount;

    private final Set<Pair<Integer, Integer>> allPositionsCovered;

    public Robot(){
        try {
            brain = new LilMachine(new ProgramReader().readProgram("day11.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        direction = Direction.NORTH;

        brain.setInputHandler(this::whatDoesTheCameraSee);
        brain.setOutputHandler(this);

        panel = new InfiniteGrid<>(0L);
        panel.set(1L, 0, 0);

        allPositionsCovered = new HashSet<>();

        x = 0;
        y = 0;
    }

    public void bootUp(){
        brain.computeProgram();
        System.out.println(panel.toString().replaceAll("0", "."));
    }

    private long whatDoesTheCameraSee(){
        return panel.getElementAt(x, y);
    }

    @Override
    public void handleOutput(long output) {
        if(outputCount % 2 == 0)
            paintPanel(output);
        else
            adjustDirectionAndMove(output);

        outputCount++;
    }

    private void paintPanel(long value){
        panel.set(value, x, y);
        allPositionsCovered.add(new Pair<>(x, y));
    }

    private void adjustDirectionAndMove(long value){
        if(value == 0L)
            direction = direction.cycleLeft();
        else if(value == 1L)
            direction = direction.cycleRight();

        moveOnceInCurrentDirection();
    }

    private void moveOnceInCurrentDirection(){
        switch(direction){
            case NORTH ->
                y += 1;
            case EAST ->
                x += 1;
            case SOUTH ->
                y -= 1;
            case WEST ->
                x -= 1;
        }
    }

    public Set<Pair<Integer, Integer>> getAllPositionsCovered() {
        return allPositionsCovered;
    }
}
