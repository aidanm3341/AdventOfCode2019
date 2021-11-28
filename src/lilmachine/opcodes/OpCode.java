package lilmachine.opcodes;

import lilmachine.ProgramState;

public interface OpCode {
    void apply(ProgramState state);
}
