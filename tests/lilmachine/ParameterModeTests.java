package lilmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ParameterModeTests {

    private LilMachine lilMachine;
    private ProgramReader programReader;

    @BeforeEach
    public void init(){
        programReader = new ProgramReader();
    }

    @Test
    public void testImmediateMode() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString("1101,100,1,5,99,0"));
        lilMachine.computeProgram();
        Assertions.assertEquals(101, lilMachine.getState().get(5));
    }

    @Test
    public void testImmediateAndPositionModeMixed() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString("101,100,1,5,99,0"));
        lilMachine.computeProgram();
        Assertions.assertEquals(200, lilMachine.getState().get(5));
    }
}
