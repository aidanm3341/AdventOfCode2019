package lilmachine.io.input;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueBasedMultipleInputHandler implements InputHandler{

    private final Queue<Long> queue;

    public QueueBasedMultipleInputHandler(){
        queue = new LinkedBlockingQueue<>();
    }

    public void addInput(long input){
        queue.add(input);
    }

    @Override
    public long getInput() {
        return Objects.requireNonNullElse(queue.poll(), 0L);
    }
}
