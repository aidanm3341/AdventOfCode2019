package day2.part1;

import utils.InputReader;

import java.util.List;

public class Part1 {
    public Part1(){ }

    public List<Integer> computeProgram(List<Integer> i){
        int programCounter = 0;
        int opCode;
        do{
            opCode = i.get(programCounter);
            switch(opCode){
                case 1: // add
                    int addition = i.get(i.get(programCounter + 1)) + i.get(i.get(programCounter + 2));
                    i.set(i.get(programCounter + 3), addition);
                    break;
                case 2: // multiply
                    int multiplication = i.get(i.get(programCounter + 1)) * i.get(i.get(programCounter + 2));
                    i.set(i.get(programCounter + 3), multiplication);
                    break;
                case 99: // halt
                    break;
            }
            programCounter += 4;
        } while (opCode != 99);
        return i;
    }


    public static void main(String[] args) throws Exception{
        Part1 part1 = new Part1();
        List<Integer> finalState = part1.computeProgram(
                new InputReader().readProgram("day2.txt")
        );
        System.out.println(finalState.get(0));
    }
}
