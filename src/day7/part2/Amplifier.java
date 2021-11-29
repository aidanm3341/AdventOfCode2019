package day7.part2;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import lilmachine.io.input.BlockingQueueMultipleInputHandler;
import lilmachine.io.input.QueueBasedMultipleInputHandler;
import lilmachine.io.output.OutputHandler;

import java.io.FileNotFoundException;

public class Amplifier implements Runnable{

    private LilMachine lilMachine;
    private final BlockingQueueMultipleInputHandler inputHandler;
    private int output;
    private boolean isComplete;

    public Amplifier(int phaseSetting){
        lilMachine = null;
        try {
            lilMachine = new LilMachine(new ProgramReader().readProgram("day7.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        inputHandler = new BlockingQueueMultipleInputHandler();
        inputHandler.addInput(phaseSetting);
        lilMachine.setInputHandler(inputHandler);

        isComplete = false;
    }

    public void setOutputHandler(OutputHandler outputHandler) {
        lilMachine.setOutputHandler(outputHandler);
    }

    public void addInput(int input){
        inputHandler.addInput(input);
    }

    public int getOutput() {
        return output;
    }

    public void setOutput(int output) {
        this.output = output;
    }

    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public void run() {
        lilMachine.computeProgram();
        isComplete = true;
    }
}
