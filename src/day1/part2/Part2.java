package day1.part2;

import utils.InputReader;

public class Part2 {
    public static void main(String[] args) throws Exception{
        InputReader reader = new InputReader();
        System.out.println(
                reader.readAsStream("day1.txt")
                        .map(Integer::parseInt)
                        .mapToInt(Part2::calculateFuel)
                        .sum()
        );
    }

    public static int calculateFuel(int mass){
        if(mass <= 0)
            return 0;

        int fuel = Math.floorDiv(mass, 3) - 2;
        if(fuel <= 0)
            fuel = 0;
        return fuel + calculateFuel(fuel);
    }
}
