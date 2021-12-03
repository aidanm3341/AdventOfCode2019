package lilmachine.opcodes;

import lilmachine.ProgramState;

public interface IOpCode {
    void apply(ProgramState state);
}
