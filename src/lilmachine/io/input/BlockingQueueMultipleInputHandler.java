package lilmachine.io.input;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueMultipleInputHandler implements InputHandler{

    private final Queue<Integer> queue;

    public BlockingQueueMultipleInputHandler(){
        queue = new LinkedBlockingQueue<>();
    }

    public void addInput(int input){
        queue.add(input);
    }

    @Override
    public int getInput() {
        while(queue.isEmpty()) {}
        return queue.poll();
    }
}
