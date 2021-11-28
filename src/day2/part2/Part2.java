package day2.part2;

import lilmachine.ProgramReader;
import utils.Pair;
import lilmachine.exceptions.UnknownOpCodeException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public Part2(){ }

    public List<Integer> computeProgram(List<Integer> i){
        int programCounter = 0;
        int opCode;
        do{
            opCode = i.get(programCounter);
            switch(opCode) {
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
                default:
                    throw new UnknownOpCodeException();
            }
            programCounter += 4;
        } while (opCode != 99);
        return i;
    }

    public Pair<Integer, Integer> getInputsWhichGive(int target) throws FileNotFoundException {
        List<Integer> initialState = new ProgramReader().readProgram("day2.txt");
        List<Integer> attemptState = new ArrayList<>();

        int noun = 0, verb = 0;
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
        return new Pair<>(0, 0);
    }


    public static void main(String[] args) throws Exception{
        Part2 part1 = new Part2();

        int target = 19690720;
        Pair<Integer, Integer> answer = part1.getInputsWhichGive(target);

        System.out.println(100 * answer.getFst() + answer.getSnd());
    }
}
