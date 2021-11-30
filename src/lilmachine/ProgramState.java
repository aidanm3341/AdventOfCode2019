package lilmachine;

import java.util.Collections;
import java.util.List;

public class ProgramState {
    private int instructionPointer;
    private final List<Long> state;

    private int relativeBase;

    public ProgramState(List<Long> initialState){
        // initialise the memory and add some blank memory at the end
        state = initialState;
        for (int i = 0; i < 1000; i++)
            state.add(0L);

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
        while(index >= state.size())
            state.add(0L);
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
