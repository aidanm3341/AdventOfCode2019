package lilmachine.parameters;

import lilmachine.exceptions.IllegalModeException;

public enum ParameterMode {
    POSITION_MODE, IMMEDIATE_MODE, RELATIVE_MODE;

    public static ParameterMode getMode(char c){
        return switch (c){
            case '0' -> POSITION_MODE;
            case '1' -> IMMEDIATE_MODE;
            case '2' -> RELATIVE_MODE;
            default -> throw new IllegalModeException();
        };
    }
}
