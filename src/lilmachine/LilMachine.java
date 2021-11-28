package lilmachine;

import lilmachine.opcodeMapper.HardCodedMapper;
import lilmachine.opcodeMapper.OpCodeMapper;
import lilmachine.opcodeMapper.ReflectionMapper;
import lilmachine.opcodes.*;

import java.util.List;

public class LilMachine {

    private final ProgramState state;
    private final OpCodeMapper opCodeMapper;

    public LilMachine(List<Integer> i){
        state = new ProgramState(i);
        opCodeMapper = new ReflectionMapper();
    }

    public void computeProgram(){
        OpCode opCode;
        do{
            opCode = getNextOpCode();
            opCode.apply(state);
        } while (!(opCode instanceof Halt));
    }

    private OpCode getNextOpCode(){
        StringBuilder builder = new StringBuilder(String.valueOf(state.get(state.getIP())));
        while(builder.length() < 5)
            builder.insert(0, "0");

        String value = builder.toString();

        return opCodeMapper.getOpCode(state, value);
    }

    public List<Integer> getState() {
        return state.getState();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer i : state.getState()){
            builder.append(",").append(i);
        }
        builder.deleteCharAt(0);
        return "LilMachine: " + builder.toString();
    }
}
