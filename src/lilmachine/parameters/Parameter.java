package lilmachine.parameters;

import lilmachine.ProgramState;
import lilmachine.exceptions.IllegalModeException;

public class Parameter {

    private ParameterMode mode;
    private final int value;

    public Parameter(int value, ParameterMode mode){
        this.value = value;
        this.mode = mode;
    }

    public int read(ProgramState state){
        return switch (mode) {
            case IMMEDIATE_MODE -> value;
            case POSITION_MODE -> state.get(value);
            case RELATIVE_MODE -> state.get(value + state.getRelativeBase());
        };
    }

    public void write(ProgramState state, int data){
        switch (mode) {
            case IMMEDIATE_MODE -> throw new IllegalModeException();
            case POSITION_MODE -> state.set(value, data);
            case RELATIVE_MODE -> state.set(value + state.getRelativeBase(), data);
        }
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "mode=" + mode +
                ", value=" + value +
                '}';
    }
}
