package lilmachine.opcodeMapper;

import lilmachine.ProgramState;
import lilmachine.opcodes.OpCode;

public interface OpCodeMapper {
    OpCode getOpCode(ProgramState state, String opStr);
}
