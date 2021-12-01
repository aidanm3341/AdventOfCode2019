package lilmachine.io.output;

import java.util.ArrayList;
import java.util.List;

public class ListenerOutputHandler implements OutputHandler{

    private final List<OutputListener> listeners;

    public ListenerOutputHandler(){
        listeners = new ArrayList<>();
    }

    @Override
    public void handleOutput(long output) {
        for(OutputListener listener : listeners)
            listener.receiveOutput(output);
    }

    public void addListener(OutputListener outputListener){
        listeners.add(outputListener);
    }

    public void removeListener(OutputListener outputListener){
        listeners.remove(outputListener);
    }
}
