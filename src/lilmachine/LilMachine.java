package lilmachine;

import lilmachine.io.input.InputHandler;
import lilmachine.io.input.SystemInputHandler;
import lilmachine.io.output.OutputHandler;
import lilmachine.io.output.SystemOutputHandler;
import lilmachine.opcodeMapper.OpCodeMapper;
import lilmachine.opcodeMapper.ReflectionMapper;
import lilmachine.opcodes.*;

import java.util.List;

public class LilMachine {

    private final ProgramState state;
    private final OpCodeMapper opCodeMapper;

    private InputHandler inputHandler;
    private OutputHandler outputHandler;

    private int timer;

    public LilMachine(List<Long> i){
        state = new ProgramState(i);
        opCodeMapper = new ReflectionMapper();

        inputHandler = new SystemInputHandler();
        outputHandler = new SystemOutputHandler();

        timer = 0;
    }

    public void computeProgram(){
        IOpCode opCode;
        do{
            opCode = getNextOpCode();
            opCode.apply(state);
        } while (!(opCode instanceof Halt));
    }

    public void computeProgram(int FPS){
        IOpCode opCode = null;
        do{
            if(timer > FPS) {
                opCode = getNextOpCode();
                opCode.apply(state);
                timer = 0;
            }
            timer++;
        } while (!(opCode instanceof Halt));
    }

    private IOpCode getNextOpCode(){
        StringBuilder builder = new StringBuilder(String.valueOf(state.get((int) state.getIP())));
        while(builder.length() < 5)
            builder.insert(0, "0");

        String value = builder.toString();

        IOpCode opCode = opCodeMapper.getOpCode(state, value);

        if(opCode instanceof Input)
            ((Input) opCode).setInputHandler(inputHandler);
        else if(opCode instanceof Output)
            ((Output) opCode).setOutputHandler(outputHandler);

        return opCode;
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }

    public List<Long> getState() {
        return state.getState();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Long i : state.getState()){
            builder.append(",").append(i);
        }
        builder.deleteCharAt(0);
        return "LilMachine: " + builder.toString();
    }
}
