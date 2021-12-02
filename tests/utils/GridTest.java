package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridTest {

    private InfiniteGrid<Integer> grid;

    @BeforeEach
    public void init(){

    }

    @Test
    public void testAddElement() {
        grid = new InfiniteGrid<>(0);
        grid.set(1, 0, 0);
        Assertions.assertEquals(1, grid.getElementAt(0, 0));
    }

    @Test
    public void testNegativeIndices() {
        grid = new InfiniteGrid<>();
        grid.set(1, -1, -1);
        System.out.println(grid.toString());
        Assertions.assertEquals(1, grid.getElementAt(-1, -1));
    }

    @Test
    public void testUnbalancedIndices() {
        grid = new InfiniteGrid<>();
        grid.set(1, -2, -3);
        Assertions.assertEquals(1, grid.getElementAt(-2, -3));
    }

    @Test
    public void testMultipleAdditions() {
        grid = new InfiniteGrid<>(0);
        grid.set(1, 0, 0);
        grid.set(2, -1, -2);
        grid.set(3, 1, 2);
        System.out.println(grid.toString());
        Assertions.assertEquals(1, grid.getElementAt(0, 0));
    }

    @Test
    public void testGettingElementOnBoundary() {
        grid = new InfiniteGrid<>();
        grid.set(1, 1, 1);
        grid.set(2, -1, -2);
        grid.set(3, 4, 0);
        grid.set(4, -4, 0);
        System.out.println(grid.toString());
        Assertions.assertEquals(4, grid.getElementAt(-4, 0));
    }


}
