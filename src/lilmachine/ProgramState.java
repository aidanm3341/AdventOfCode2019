package lilmachine;

import java.util.Collections;
import java.util.List;

public class ProgramState {
    private int instructionPointer;
    private final List<Long> state;

    private int relativeBase;

    public ProgramState(List<Long> initialState){
        state = initialState;
        instructionPointer = 0;
        relativeBase = 0;
    }

    public int getIP() {
        return instructionPointer;
    }

    public void setIP(int instructionPointer) {
        this.instructionPointer = instructionPointer;
    }

    public void setIP(long instructionPointer) {
        this.instructionPointer = (int) instructionPointer;
    }

    public void incrementIP(int count){
        instructionPointer += count;
    }

    public long get(int index) {
        return state.get(index);
    }

    public void set(int index, long value) {
        state.set(index, value);
    }

    public List<Long> getState() {
        return Collections.unmodifiableList(state);
    }

    public int getRelativeBase() {
        return relativeBase;
    }

    public void setRelativeBase(int relativeBase) {
        this.relativeBase = relativeBase;
    }

    public void setRelativeBase(long relativeBase) {
        this.relativeBase = (int) relativeBase;
    }
}
