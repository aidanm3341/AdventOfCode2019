package lilmachine.io.output;

import java.util.ArrayList;
import java.util.List;

public class ListenerOutputHandler implements OutputHandler{

    private final List<OutputHandler> listeners;

    public ListenerOutputHandler(){
        listeners = new ArrayList<>();
    }

    @Override
    public void handleOutput(long output) {
        for(OutputHandler listener : listeners)
            listener.handleOutput(output);
    }

    public void addListener(OutputHandler outputListener){
        listeners.add(outputListener);
    }

    public void removeListener(OutputHandler outputListener){
        listeners.remove(outputListener);
    }
}
