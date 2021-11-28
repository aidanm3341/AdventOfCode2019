package lilmachine.opcodes;

import lilmachine.ProgramState;

public abstract class OpCode {

    public OpCode(){ }

    public abstract void apply(ProgramState state);

}
