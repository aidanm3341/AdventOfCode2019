package lilmachine.opcodes;

import lilmachine.parameters.Parameter;
import lilmachine.ProgramState;

import java.util.Scanner;

public class Input extends OpCode {

    private final Parameter output;

    public Input(Parameter output){
        this.output = output;
    }

    @Override
    public void apply(ProgramState state) {
        Scanner reader = new Scanner(System.in);
        System.out.print("> ");
        int input = reader.nextInt();
        reader.close();

        output.write(state, input);

        state.incrementIP(2);
    }
}
