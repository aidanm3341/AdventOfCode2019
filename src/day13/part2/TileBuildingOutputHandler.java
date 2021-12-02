package day13.part2;

import lilmachine.io.output.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class TileBuildingOutputHandler implements OutputHandler {

    private int outputCount;
    private int x, y, tileID;

    private final List<ArcadeMachineOutputListener> listeners;

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
        for(ArcadeMachineOutputListener arcadeMachineOutputListener : listeners)
            arcadeMachineOutputListener.sendNewTile(x, y, tileID);
    }

    public void addListener(ArcadeMachineOutputListener listener){
        listeners.add(listener);
    }
}
