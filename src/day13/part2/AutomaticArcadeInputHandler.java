package day13.part2;

import day13.part2.engine.Tile;
import lilmachine.io.input.InputHandler;
import utils.InfiniteGrid;

public class AutomaticArcadeInputHandler implements InputHandler {

    private final InfiniteGrid<Long> grid;

    public AutomaticArcadeInputHandler(InfiniteGrid<Long> grid){
        this.grid = grid;
    }

    @Override
    public long getInput() {
        long startingTime = System.currentTimeMillis();

        while(System.currentTimeMillis() - startingTime < 5) { }

        int ballX = grid.findFirst((long) Tile.BALL.getId()).getFst();
        int paddleX = grid.findFirst((long) Tile.PADDLE.getId()).getFst();
        return Integer.compare(ballX, paddleX);
    }
}
