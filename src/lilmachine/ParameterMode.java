package lilmachine;

public enum ParameterMode {
    POSITION_MODE, IMMEDIATE_MODE;

    static ParameterMode getMode(int num){
        return switch (num){
            case 0 -> POSITION_MODE;
            case 1 -> IMMEDIATE_MODE;
            default -> throw new IllegalModeException();
        };
    }

    static ParameterMode getMode(char c){
        int num = Integer.parseInt(String.valueOf(c));
        return switch (num){
            case 0 -> POSITION_MODE;
            case 1 -> IMMEDIATE_MODE;
            default -> throw new IllegalModeException();
        };
    }
}
