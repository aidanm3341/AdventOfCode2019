package day11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Grid;

public class GridTest {

    private Grid<Integer> grid;

    @BeforeEach
    public void init(){

    }

    @Test
    public void testAddElement() {
        grid = new Grid<>();
        grid.write(1, 0, 0);
        Assertions.assertEquals(1, grid.getElementAt(0, 0));
    }

    @Test
    public void testNegativeIndices() {
        grid = new Grid<>();
        grid.write(1, -1, -1);
        System.out.println(grid.toString());
        Assertions.assertEquals(1, grid.getElementAt(-1, -1));
    }

    @Test
    public void testUnbalancedIndices() {
        grid = new Grid<>();
        grid.write(1, -2, -3);
        Assertions.assertEquals(1, grid.getElementAt(-2, -3));
    }

    @Test
    public void testMultipleAdditions() {
        grid = new Grid<>();
        grid.write(1, 0, 0);
        grid.write(2, -1, -2);
        grid.write(3, 1, 2);
        System.out.println(grid.toString());
        Assertions.assertEquals(1, grid.getElementAt(0, 0));
    }

    @Test
    public void testGettingElementOnBoundary() {
        grid = new Grid<>();
        grid.write(1, 1, 1);
        grid.write(2, -1, -2);
        grid.write(3, 4, 0);
        grid.write(4, -4, 0);
        System.out.println(grid.toString());
        Assertions.assertEquals(4, grid.getElementAt(-4, 0));
    }


}
