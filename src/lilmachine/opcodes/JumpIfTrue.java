package lilmachine.opcodes;

import lilmachine.ProgramState;
import lilmachine.parameters.Parameter;

public class JumpIfTrue implements IOpCode {

    private final Parameter test, value;

    public JumpIfTrue(Parameter test, Parameter value){
        this.test = test;
        this.value = value;
    }

    @Override
    public void apply(ProgramState state) {
        if(test.read(state) > 0)
            state.setIP(value.read(state));
        else
            state.incrementIP(3);
    }
}
