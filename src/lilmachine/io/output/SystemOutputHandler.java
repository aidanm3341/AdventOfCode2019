package lilmachine.io.output;

public class SystemOutputHandler implements OutputHandler{
    @Override
    public int handleOutput(int output) {
        System.out.println(output);
        return output;
    }
}
