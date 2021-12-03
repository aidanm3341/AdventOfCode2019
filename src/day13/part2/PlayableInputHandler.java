package day13.part2;

import lilmachine.io.input.InputHandler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayableInputHandler implements InputHandler, KeyListener {

    private int currentKey;

    @Override
    public synchronized long getInput() {
        long startingTime = System.currentTimeMillis();

        long returnVal = 0;

        while(System.currentTimeMillis() - startingTime < 500) {
            if(currentKey == KeyEvent.VK_LEFT || currentKey == KeyEvent.VK_D)
                returnVal = -1;
            else if(currentKey == KeyEvent.VK_RIGHT || currentKey == KeyEvent.VK_A)
                returnVal = 1;
        }
        System.out.println("returning " + returnVal);
        return returnVal;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentKey = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(currentKey == e.getKeyCode())
            currentKey = 0;
    }
}
