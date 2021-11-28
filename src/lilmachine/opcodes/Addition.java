package lilmachine.opcodes;

import lilmachine.parameters.Parameter;
import lilmachine.ProgramState;

public class Addition implements OpCode{

    private final Parameter x, y, output;

    public Addition(Parameter x, Parameter y, Parameter output){
        this.x = x;
        this.y = y;
        this.output = output;
    }

    @Override
    public void apply(ProgramState state) {
        int answer = x.read(state) + y.read(state);
        output.write(state, answer);
        state.incrementIP(4);
    }
}
