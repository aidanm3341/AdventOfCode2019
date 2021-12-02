package day11.part1;

import day11.Robot;

public class Part1 {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.bootUp();
        System.out.println(robot.getAllPositionsCovered().size());
    }
}
