package lilmachine.io.output;

public class SystemOutputHandler implements OutputHandler{
    @Override
    public void handleOutput(int output) {
        System.out.println(output);
    }
}
