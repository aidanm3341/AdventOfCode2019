package lilmachine.io.input;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueMultipleInputHandler implements InputHandler{

    private final Queue<Long> queue;

    public BlockingQueueMultipleInputHandler(){
        queue = new LinkedBlockingQueue<>();
    }

    public void addInput(long input){
        queue.add(input);
    }

    @Override
    public long getInput() {
        while(queue.isEmpty()) {}
        return queue.poll();
    }
}
