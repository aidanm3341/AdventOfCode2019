package lilmachine.opcodes;

import lilmachine.io.input.InputHandler;
import lilmachine.parameters.Parameter;
import lilmachine.ProgramState;

public class Input implements IOpCode {

    private final Parameter output;

    private InputHandler inputHandler;

    public Input(Parameter output){
        this.output = output;
    }

    @Override
    public void apply(ProgramState state) {
        output.write(state, inputHandler.getInput());

        state.incrementIP(2);
    }

    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
}
