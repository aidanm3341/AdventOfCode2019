package day3.part1;

import utils.InputReader;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Part1 {
    private final List<List<Character>> map;
    private int x, y;
    private int startingX, startingY;

    public Part1(){
        x = 0;
        y = 0;
        startingX = x;
        startingY = y;

        map = new LinkedList<>();
        List<Character> firstRow = new LinkedList<>();
        firstRow.add('o');
        map.add(firstRow); // first row
    }

    public void parseLineString(String lineString){
        x = startingX;
        y = startingY;
        for (String s : lineString.split(",")){
            int instruction = s.charAt(0);
            int amountToMove = Integer.parseInt(s.substring(1));
            switch (instruction){
                case 'R':
                    goRight(amountToMove);
                    break;
                case 'L':
                    goLeft(amountToMove);
                    break;
                case 'U':
                    goUp(amountToMove);
                    break;
                case 'D':
                    goDown(amountToMove);
                    break;
            }
        }
    }

    private void drawLineSegment(){
        if(map.size() <= y)
            while(map.size() <= y)
                map.add(new LinkedList<>());
        if(map.get(y).size() <= x)
            while(map.get(y).size() <= x)
                map.get(y).add(' ');

        if(map.get(y).get(x).equals('.'))
            map.get(y).set(x, 'X'); // found an intersection, mark it with an X
        else if(map.get(y).get(x).equals(' '))
            map.get(y).set(x, '.'); // just need to write a normal line
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
            if(x < 0)
                while(x < 0) {
                    map.get(y).add(0, ' ');
                    x++;
                    targetX++;
                    startingX++;
                }
            drawLineSegment();
        }
    }

    private void goDown(int amount){
        int targetY = y - amount;
        while(y > targetY){
            y--;
            if(y < 0)
                while(y < 0) {
                    map.add(0, new LinkedList<>());
                    y++;
                    targetY++;
                    startingY++;
                }
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
        for(List<Character> xs : map){
            String row = xs.stream().map(c -> ""+c).reduce("", (acc, c) -> acc + c);
            mapString.append(row).append("\n");
        }
        return mapString.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Part1 part1 = new Part1();
        part1.parseMultipleLines(new InputReader().readAsList("day3.txt"));
        System.out.println(part1.visualiseMap());
    }
}
