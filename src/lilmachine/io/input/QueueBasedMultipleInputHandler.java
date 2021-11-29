package lilmachine.io.input;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueBasedMultipleInputHandler implements InputHandler{

    private final Queue<Integer> queue;

    public QueueBasedMultipleInputHandler(){
        queue = new LinkedBlockingQueue<>();
    }

    public void addInput(int input){
        queue.add(input);
    }

    @Override
    public int getInput() {
        return Objects.requireNonNullElse(queue.poll(), 0);
    }
}
