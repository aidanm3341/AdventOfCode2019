package lilmachine.opcodes;

import lilmachine.ProgramState;
import lilmachine.parameters.Parameter;

public class Rebase implements IOpCode {

    private final Parameter amount;

    public Rebase(Parameter amount){
        this.amount = amount;
    }

    @Override
    public void apply(ProgramState state) {
        state.setRelativeBase(state.getRelativeBase() + amount.read(state));
        state.incrementIP(2);
    }
}
