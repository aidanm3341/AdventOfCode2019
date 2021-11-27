package day1.part1;

import utils.InputReader;

public class Part1 {
    public static void main(String[] args) throws Exception{
        InputReader reader = new InputReader();
        System.out.println(
                reader.readAsStream("day1.txt")
                        .map(Integer::parseInt)
                        .mapToInt(Part1::calculateFuel)
                        .sum()
        );
    }

    public static int calculateFuel(int mass){
        return Math.floorDiv(mass, 3) - 2;
    }
}
