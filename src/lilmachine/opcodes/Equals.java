package lilmachine.opcodes;

import lilmachine.ProgramState;
import lilmachine.parameters.Parameter;

public class Equals implements IOpCode {

    private final Parameter left, right, output;

    public Equals(Parameter left, Parameter right, Parameter output){
        this.left = left;
        this.right = right;
        this.output = output;
    }

    @Override
    public void apply(ProgramState state) {
        if(left.read(state) == right.read(state))
            output.write(state, 1);
        else
            output.write(state, 0);
        state.incrementIP(4);
    }
}
