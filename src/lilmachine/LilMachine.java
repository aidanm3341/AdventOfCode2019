package lilmachine;

import lilmachine.opcodes.*;

import java.util.List;

public class LilMachine {

    private final ProgramState state;

    public LilMachine(List<Integer> i){
        state = new ProgramState(i);
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

        int opCode = Integer.parseInt(value.substring(3,5));
        Parameter param1, param2, param3;
        switch (opCode) {
            case 1 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(value.charAt(2)));
                param2 = new Parameter(state.get(state.getIP() + 2), ParameterMode.getMode(value.charAt(1)));
                param3 = new Parameter(state.get(state.getIP() + 3), ParameterMode.getMode(value.charAt(0)));
                return new Addition(param1, param2, param3);
            }
            case 2 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(value.charAt(2)));
                param2 = new Parameter(state.get(state.getIP() + 2), ParameterMode.getMode(value.charAt(1)));
                param3 = new Parameter(state.get(state.getIP() + 3), ParameterMode.getMode(value.charAt(0)));
                return new Multiplication(param1, param2, param3);
            }
            case 3 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(value.charAt(2)));
                return new Input(param1);
            }
            case 4 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(value.charAt(2)));
                return new Output(param1);
            }
            case 99 -> {
                return new Halt();
            }
            default -> throw new UnknownOpCodeException();
        }
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
