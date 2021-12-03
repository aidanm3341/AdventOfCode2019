package lilmachine.opcodes;

import lilmachine.ProgramState;

public class Halt implements IOpCode {

    @Override
    public void apply(ProgramState state) {
        state.setIP(state.getIP()+1);
    }
}
