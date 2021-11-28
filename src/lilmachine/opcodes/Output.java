package lilmachine.opcodes;

import lilmachine.parameters.Parameter;
import lilmachine.ProgramState;

public class Output implements OpCode{

    private final Parameter input;

    public Output(Parameter input){
        this.input = input;
    }

    @Override
    public void apply(ProgramState state) {
        System.out.println(input.read(state));
        state.incrementIP(2);
    }
}
