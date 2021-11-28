package day3.part1;

import utils.InputReader;
import utils.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    private List<StringBuilder> map;
    private int x, y;
    private int startingX, startingY;
    private char currentLineMarker;

    List<Pair<Integer, Integer>> points;

    public Part1(){
        currentLineMarker = '1';
        points = new ArrayList<>();
    }

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

    public void parseLineString(String lineString, char lineMarker){
        x = startingX;
        y = startingY;
        for (String s : lineString.split(",")){
            int instruction = s.charAt(0);
            int amountToMove = Integer.parseInt(s.substring(1));
            switch (instruction) {
                case 'R' -> goRight(amountToMove, lineMarker);
                case 'L' -> goLeft(amountToMove, lineMarker);
                case 'U' -> goUp(amountToMove, lineMarker);
                case 'D' -> goDown(amountToMove, lineMarker);
            }
        }
    }

    private void drawLineSegment(char lineChar){
        if(map.get(y).charAt(x) != ' ' && map.get(y).charAt(x) != 'o' && map.get(y).charAt(x) != lineChar) {
            map.get(y).deleteCharAt(x);
            map.get(y).insert(x, 'X'); // found an intersection, mark it with an X
            points.add(new Pair<>(x, y));
        }
        else if(map.get(y).charAt(x) == (' ')) {
            map.get(y).deleteCharAt(x);
            map.get(y).insert(x, lineChar); // just need to write a normal line
        }
    }

    private void goRight(int amount, char lineMarker){
        int targetX = x + amount;
        while(x < targetX){
            x++;
            drawLineSegment(lineMarker);
        }
    }

    private void goLeft(int amount, char lineMarker){
        int targetX = x - amount;
        while(x > targetX){
            x--;
            drawLineSegment(lineMarker);
        }
    }

    private void goDown(int amount, char lineMarker){
        int targetY = y - amount;
        while(y > targetY){
            y--;
            drawLineSegment(lineMarker);
        }
    }

    private void goUp(int amount, char lineMarker){
        int targetY = y + amount;
        while(y < targetY){
            y++;
            drawLineSegment(lineMarker);
        }
    }

    public void parseMultipleLines(List<String> lines){
        for(String line : lines){
            currentLineMarker++;
            parseLineString(line, currentLineMarker);
        }
    }


    public String visualiseMap(){
        StringBuilder mapString = new StringBuilder();
        for(StringBuilder xs : map){
            mapString.append(xs.toString()).append("\n");
        }
        return mapString.toString();
    }

    public int calculateClosestIntersectionToOrigin(){
        int smallestDistance = Integer.MAX_VALUE;
        for(Pair<Integer, Integer> point : points){
            int distance = Math.abs(startingX - point.getFst()) + Math.abs(startingY - point.getSnd());
            smallestDistance = Math.min(smallestDistance, distance);
        }

        return smallestDistance;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Part1 part1 = new Part1();
        List<String> input = new InputReader().readAsList("day3.txt");
        part1.initialiseMap(input);
        part1.parseMultipleLines(input);
        System.out.println(part1.calculateClosestIntersectionToOrigin());
    }
}
