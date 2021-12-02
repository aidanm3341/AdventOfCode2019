package day13;

import lilmachine.io.output.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class TileBuildingOutputHandler implements OutputHandler {

    private int outputCount;
    private int x, y, tileID;

    private final List<TileListener> listeners;

    public TileBuildingOutputHandler(){
        listeners = new ArrayList<>();
    }

    @Override
    public void handleOutput(long output) {
        if(outputCount == 0)
            x = (int) output;
        else if(outputCount == 1)
            y = (int) output;
        else if(outputCount == 2) {
            tileID = (int) output;
            sendTile();
        }

        outputCount++;
        if(outputCount > 2)
            outputCount = 0;
    }

    private void sendTile(){
        for(TileListener tileListener : listeners)
            tileListener.sendNewTile(x, y, tileID);
    }

    public void addListener(TileListener listener){
        listeners.add(listener);
    }
}
