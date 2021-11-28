package lilmachine;

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
        };
    }

    public void write(ProgramState state, int data){
        switch (mode) {
            case IMMEDIATE_MODE -> throw new IllegalModeException();
            case POSITION_MODE -> state.set(value, data);
        };
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "mode=" + mode +
                ", value=" + value +
                '}';
    }
}
