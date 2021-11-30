package lilmachine.opcodeMapper;

import lilmachine.ProgramState;
import lilmachine.exceptions.UnknownOpCodeException;
import lilmachine.opcodes.*;
import lilmachine.parameters.Parameter;
import lilmachine.parameters.ParameterMode;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectionMapper implements OpCodeMapper{

    private final Map<Integer, Class<? extends OpCode>> opcodes;

    public ReflectionMapper(){
        opcodes = new HashMap<>();
        opcodes.put(1, Addition.class);
        opcodes.put(2, Multiplication.class);
        opcodes.put(3, Input.class);
        opcodes.put(4, Output.class);
        opcodes.put(5, JumpIfTrue.class);
        opcodes.put(6, JumpIfFalse.class);
        opcodes.put(7, LessThan.class);
        opcodes.put(8, Equals.class);
        opcodes.put(9, Rebase.class);

        opcodes.put(99, Halt.class);
    }

    @Override
    public OpCode getOpCode(ProgramState state, String opStr) {
        try {
            int op = Integer.parseInt(opStr.substring(3,5));
            if(!opcodes.containsKey(op))
                throw new UnknownOpCodeException();

            Class<? extends OpCode> opcode = opcodes.get(op);

            List<Parameter> parameters = new ArrayList<>();
            int parameterCount = 0;
            if(opcode.getConstructors()[0] != null)
                parameterCount = opcode.getConstructors()[0].getParameterCount();

            assert parameterCount <= 3 && parameterCount >= 0;

            for (int i = 1; i <= parameterCount; i++) {
                parameters.add(
                        new Parameter(
                                state.get(state.getIP() + i),
                                ParameterMode.getMode(opStr.charAt(3 - i)))
                );
            }

            if(parameterCount > 0)
                return (OpCode) opcode.getConstructors()[0].newInstance(parameters.toArray());
            else
                return (OpCode) opcode.getConstructors()[0].newInstance();

        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
