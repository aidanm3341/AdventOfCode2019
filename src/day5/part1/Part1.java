package day5.part1;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;

import java.io.FileNotFoundException;

public class Part1 {
    public static void main(String[] args) throws FileNotFoundException {
        LilMachine lilMachine = new LilMachine(new ProgramReader().readProgram("day5.txt"));
        lilMachine.computeProgram();
    }
}
