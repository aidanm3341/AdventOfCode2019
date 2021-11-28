package lilmachine;

import java.util.List;

public class LilMachine {

    private List<Integer> state;

    public LilMachine(List<Integer> i){
        state = i;
    }

    public void computeProgram(){
        int programCounter = 0;
        int opCode;
        do{
            opCode = state.get(programCounter);
            switch(opCode) {
                case 1: // add
                    int addition = state.get(state.get(programCounter + 1)) + state.get(state.get(programCounter + 2));
                    state.set(state.get(programCounter + 3), addition);
                    break;
                case 2: // multiply
                    int multiplication = state.get(state.get(programCounter + 1)) * state.get(state.get(programCounter + 2));
                    state.set(state.get(programCounter + 3), multiplication);
                    break;
                case 99: // halt
                    break;
                default:
                    throw new UnknownOpCodeException();
            }
            programCounter += 4;
        } while (opCode != 99);
    }

    public List<Integer> getState() {
        return state;
    }
}
