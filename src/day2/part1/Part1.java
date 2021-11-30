package day2.part1;

import lilmachine.ProgramReader;
import utils.InputReader;

import java.util.List;

public class Part1 {
    public Part1(){ }

    public List<Long> computeProgram(List<Long> i){
        long programCounter = 0;
        long opCode;
        do{
            opCode = i.get((int) programCounter);
            switch((int) opCode){
                case 1: // add
                    long addition = i.get(Math.toIntExact(i.get((int) (programCounter + 1)))) + i.get(Math.toIntExact(i.get((int) (programCounter + 2))));
                    i.set(Math.toIntExact(i.get((int) (programCounter + 3))), addition);
                    break;
                case 2: // multiply
                    long multiplication = i.get(Math.toIntExact(i.get((int) (programCounter + 1)))) * i.get(Math.toIntExact(i.get((int) (programCounter + 2))));
                    i.set(Math.toIntExact(i.get((int) (programCounter + 3))), multiplication);
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
        List<Long> finalState = part1.computeProgram(
                new ProgramReader().readProgram("day2.txt")
        );
        System.out.println(finalState.get(0));
    }
}
