package day2.part2;

import lilmachine.ProgramReader;
import utils.Pair;
import lilmachine.exceptions.UnknownOpCodeException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public Part2(){ }

    public List<Long> computeProgram(List<Long> i){
        int programCounter = 0;
        int opCode;
        do{
            opCode = Math.toIntExact(i.get(programCounter));
            switch(opCode) {
                case 1: // add
                    long addition = i.get(Math.toIntExact(i.get(programCounter + 1))) + i.get(Math.toIntExact(i.get(programCounter + 2)));
                    i.set(Math.toIntExact(i.get(programCounter + 3)), addition);
                    break;
                case 2: // multiply
                    long multiplication = i.get(Math.toIntExact(i.get(programCounter + 1))) * i.get(Math.toIntExact(i.get(programCounter + 2)));
                    i.set(Math.toIntExact(i.get(programCounter + 3)), multiplication);
                    break;
                case 99: // halt
                    break;
                default:
                    throw new UnknownOpCodeException();
            }
            programCounter += 4;
        } while (opCode != 99);
        return i;
    }

    public Pair<Long, Long> getInputsWhichGive(int target) throws FileNotFoundException {
        List<Long> initialState = new ProgramReader().readProgram("day2.txt");
        List<Long> attemptState = new ArrayList<>();

        long noun = 0, verb = 0;
        for(noun = 0; noun <= 99; noun++) {
            for(verb = 0; verb <= 99; verb++) {
                attemptState.clear();
                attemptState.addAll(initialState);
                attemptState.set(1, noun);
                attemptState.set(2, verb);
                computeProgram(attemptState);
                if(attemptState.get(0) == target) {
                    return new Pair<>(noun, verb);
                }
            }
        }
        return new Pair<Long, Long>(0L, 0L);
    }


    public static void main(String[] args) throws Exception{
        Part2 part1 = new Part2();

        int target = 19690720;
        Pair<Long, Long> answer = part1.getInputsWhichGive(target);

        System.out.println(100 * answer.getFst() + answer.getSnd());
    }
}
