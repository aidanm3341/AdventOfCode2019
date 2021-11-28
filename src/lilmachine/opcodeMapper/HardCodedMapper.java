package lilmachine.opcodeMapper;

import lilmachine.ProgramState;
import lilmachine.exceptions.UnknownOpCodeException;
import lilmachine.opcodes.*;
import lilmachine.parameters.Parameter;
import lilmachine.parameters.ParameterMode;

public class HardCodedMapper implements OpCodeMapper{
    @Override
    public OpCode getOpCode(ProgramState state, String opStr) {
        int op = Integer.parseInt(opStr.substring(3,5));

        Parameter param1, param2, param3;
        switch (op) {
            case 1 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(opStr.charAt(2)));
                param2 = new Parameter(state.get(state.getIP() + 2), ParameterMode.getMode(opStr.charAt(1)));
                param3 = new Parameter(state.get(state.getIP() + 3), ParameterMode.getMode(opStr.charAt(0)));
                return new Addition(param1, param2, param3);
            }
            case 2 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(opStr.charAt(2)));
                param2 = new Parameter(state.get(state.getIP() + 2), ParameterMode.getMode(opStr.charAt(1)));
                param3 = new Parameter(state.get(state.getIP() + 3), ParameterMode.getMode(opStr.charAt(0)));
                return new Multiplication(param1, param2, param3);
            }
            case 3 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(opStr.charAt(2)));
                return new Input(param1);
            }
            case 4 -> {
                param1 = new Parameter(state.get(state.getIP() + 1), ParameterMode.getMode(opStr.charAt(2)));
                return new Output(param1);
            }
            case 99 -> {
                return new Halt();
            }
            default -> throw new UnknownOpCodeException();
        }
    }
}
