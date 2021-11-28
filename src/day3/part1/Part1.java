package day3.part1;

import utils.InputReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    private List<StringBuilder> map;
    private int x, y;
    private int startingX, startingY;

    public Part1(){ }

    public void initialiseMap(List<String> lines){
        int maxX = 0, minX = 0, maxY = 0, minY = 0;
        int currentX, currentY;

        for(String line : lines) {
            currentX = 0;
            currentY = 0;
            for (String s : line.split(",")) {
                int instruction = s.charAt(0);
                int amountToMove = Integer.parseInt(s.substring(1));
                switch (instruction) {
                    case 'R' -> {
                        currentX += amountToMove;
                        maxX = Math.max(maxX, currentX);
                    }
                    case 'L' -> {
                        currentX -= amountToMove;
                        minX = Math.min(minX, currentX);
                    }
                    case 'U' -> {
                        currentY += amountToMove;
                        maxY = Math.max(maxY, currentY);
                    }
                    case 'D' -> {
                        currentY -= amountToMove;
                        minY = Math.min(minY, currentY);
                    }
                }
            }
        }

        int actualWidth = Math.abs(minX) + maxX + 1;
        int actualHeight = Math.abs(minY) + maxY + 1;

        map = new ArrayList<>(actualHeight);
        for (int i = 0; i < actualHeight; i++) {
            StringBuilder row = new StringBuilder(actualWidth);
            row.append(" ".repeat(actualWidth));
            map.add(row);
        }

        startingX = x = Math.abs(minX);
        startingY = y = Math.abs(minY);
        map.get(y).insert(x, 'o');
    }

    public void parseLineString(String lineString){
        x = startingX;
        y = startingY;
        for (String s : lineString.split(",")){
            int instruction = s.charAt(0);
            int amountToMove = Integer.parseInt(s.substring(1));
            switch (instruction) {
                case 'R' -> goRight(amountToMove);
                case 'L' -> goLeft(amountToMove);
                case 'U' -> goUp(amountToMove);
                case 'D' -> goDown(amountToMove);
            }
        }
    }

    private void drawLineSegment(){
        if(map.get(y).charAt(x) == '.')
            map.get(y).insert(x, 'X'); // found an intersection, mark it with an X
        else if(map.get(y).charAt(x) == (' '))
            map.get(y).insert(x, '.'); // just need to write a normal line
    }

    private void goRight(int amount){
        int targetX = x + amount;
        while(x < targetX){
            x++;
            drawLineSegment();
        }
    }

    private void goLeft(int amount){
        int targetX = x - amount;
        while(x > targetX){
            x--;
            drawLineSegment();
        }
    }

    private void goDown(int amount){
        int targetY = y - amount;
        while(y > targetY){
            y--;
            drawLineSegment();
        }
    }

    private void goUp(int amount){
        int targetY = y + amount;
        while(y < targetY){
            y++;
            drawLineSegment();
        }
    }

    public void parseMultipleLines(List<String> lines){
        for(String line : lines){
            parseLineString(line);
        }
    }


    public String visualiseMap(){
        StringBuilder mapString = new StringBuilder();
        for(StringBuilder xs : map){
            mapString.append(xs.toString()).append("\n");
        }
        return mapString.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Part1 part1 = new Part1();
        List<String> input = new InputReader().readAsList("day3.txt");
        part1.initialiseMap(input);
        part1.parseMultipleLines(input);
        System.out.println(part1.visualiseMap());
    }
}
