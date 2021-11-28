package lilmachine.opcodes;

import lilmachine.Parameter;
import lilmachine.ProgramState;

public class Output extends OpCode{

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
