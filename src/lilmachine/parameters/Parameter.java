package lilmachine.parameters;

import lilmachine.ProgramState;
import lilmachine.exceptions.IllegalModeException;

public class Parameter {

    private ParameterMode mode;
    private final long value;

    public Parameter(long value, ParameterMode mode){
        this.value = value;
        this.mode = mode;
    }

    public long read(ProgramState state){
        return switch (mode) {
            case IMMEDIATE_MODE -> value;
            case POSITION_MODE -> state.get((int) value);
            case RELATIVE_MODE -> state.get((int) (value + state.getRelativeBase()));
        };
    }

    public void write(ProgramState state, long data){
        switch (mode) {
            case IMMEDIATE_MODE -> throw new IllegalModeException();
            case POSITION_MODE -> state.set((int) value, data);
            case RELATIVE_MODE -> state.set((int) (value + state.getRelativeBase()), data);
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
