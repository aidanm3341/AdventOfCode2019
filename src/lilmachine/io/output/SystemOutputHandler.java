package lilmachine.io.output;

public class SystemOutputHandler implements OutputHandler{
    @Override
    public void handleOutput(long output) {
        System.out.println(output);
    }
}
