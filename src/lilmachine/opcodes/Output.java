package lilmachine.opcodes;

import lilmachine.io.output.OutputHandler;
import lilmachine.parameters.Parameter;
import lilmachine.ProgramState;

public class Output implements OpCode{

    private final Parameter input;

    private OutputHandler outputHandler;

    public Output(Parameter input){
        this.input = input;
    }

    @Override
    public void apply(ProgramState state) {
        outputHandler.handleOutput(input.read(state));
        state.incrementIP(2);
    }

    public void setOutputHandler(OutputHandler outputHandler) {
        this.outputHandler = outputHandler;
    }
}
