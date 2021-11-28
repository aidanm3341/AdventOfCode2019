package lilmachine;

import java.util.Collections;
import java.util.List;

public class ProgramState {
    private int instructionPointer;
    private List<Integer> state;

    public ProgramState(List<Integer> initialState){
        state = initialState;
        instructionPointer = 0;
    }

    public int getIP() {
        return instructionPointer;
    }

    public void setIP(int instructionPointer) {
        this.instructionPointer = instructionPointer;
    }

    public int get(int index) {
        return state.get(index);
    }

    public void set(int index, int value) {
        state.set(index, value);
    }

    public List<Integer> getState() {
        return Collections.unmodifiableList(state);
    }
}
