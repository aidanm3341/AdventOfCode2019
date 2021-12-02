package utils;

import java.util.LinkedList;
import java.util.List;

public class Grid<T> {
    private final LinkedList<LinkedList<T>> grid;

    private int xOffset, yOffset;

    public Grid(){
        grid = new LinkedList<>();
        LinkedList<T> firstElement = new LinkedList<>();
        firstElement.add(null);
        grid.add(firstElement);

        xOffset = 0;
        yOffset = 0;
    }

    public void write(T element, int x, int y){
        if(x < -xOffset){
            padRows(Math.abs(xOffset + x), true);
            xOffset = -x;
        }
        if(y < -yOffset){
            padColumns(Math.abs(yOffset + y), true);
            yOffset = -y;
        }
        if(x > grid.get(0).size()-1 - xOffset){
            padRows(x - (grid.get(0).size()-1 - xOffset), false);
        }
        if(y > grid.size()-1 - yOffset){
            padColumns(y - (grid.size()-1 - yOffset), false);
        }
        grid.get(y + yOffset).set(x + xOffset, element);
    }

    private void padRows(int amount, boolean atStart){
        for (LinkedList<T> ts : grid)
            for (int j = 0; j < amount; j++)
                if(atStart)
                    ts.addFirst( null);
                else
                    ts.addLast( null);
    }

    private void padColumns(int amount, boolean atStart){
        for (int i = 0; i < amount; i++) {
            LinkedList<T> list = new LinkedList<>();
            for (int j = 0; j < grid.get(0).size(); j++)
                list.add(null);
            if(atStart)
                grid.addFirst(list);
            else
                grid.addLast(list);
        }
    }

    public T getElementAt(int x, int y){
        return grid.get(y + yOffset).get(x + xOffset);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for(List<T> ts : grid){
            output.append(ts.stream().map(t -> {
                if(t == null)
                    return " . ";
                else
                    return " " + t.toString() + " ";
            }).reduce((acc, str) -> acc + " " + str).orElse(""));
            output.append("\n");
        }
        return output.toString();
    }
}
