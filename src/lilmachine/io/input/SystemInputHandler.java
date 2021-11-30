package lilmachine.io.input;

import java.util.Scanner;

public class SystemInputHandler implements InputHandler{
    @Override
    public long getInput() {
        Scanner reader = new Scanner(System.in);
        System.out.print("> ");
        int input = reader.nextInt();
        reader.close();

        return input;
    }
}
