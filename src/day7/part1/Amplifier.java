package day7.part1;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import lilmachine.io.input.InputHandler;
import lilmachine.io.input.QueueBasedMultipleInputHandler;
import lilmachine.io.output.OutputHandler;

import java.io.FileNotFoundException;

public class Amplifier {

    private LilMachine lilMachine;
    private final QueueBasedMultipleInputHandler inputHandler;
    private long output;

    public Amplifier(int phaseSetting){
        lilMachine = null;
        try {
            lilMachine = new LilMachine(new ProgramReader().readProgram("day7.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        inputHandler = new QueueBasedMultipleInputHandler();
        inputHandler.addInput(phaseSetting);
        lilMachine.setInputHandler(inputHandler);
    }

    public long calculateOutput(long input){
        inputHandler.addInput(input);

        lilMachine.setOutputHandler(x -> output = x);
        lilMachine.computeProgram();
        return output;
    }
}
