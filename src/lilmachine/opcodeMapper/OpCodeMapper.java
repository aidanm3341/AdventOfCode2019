package lilmachine.opcodeMapper;

import lilmachine.ProgramState;
import lilmachine.opcodes.IOpCode;

public interface OpCodeMapper {
    IOpCode getOpCode(ProgramState state, String opStr);
}
