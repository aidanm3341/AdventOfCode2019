package lilmachine;

import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class ComparisonIOpCodeTests {

    private LilMachine lilMachine;
    private ProgramReader programReader;

    private static final String program = "3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31," +
            "1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104," +
            "999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99";

    @BeforeEach
    public void init(){
        programReader = new ProgramReader();
    }

    @Test
    public void testLessThanOpCode() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString(program));
        lilMachine.setInputHandler(() -> 6);
        lilMachine.setOutputHandler(output -> Assertions.assertEquals(999, output));
        lilMachine.computeProgram();
    }

    @Test
    public void testMoreThanOpCode() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString(program));
        lilMachine.setInputHandler(() -> 10);
        lilMachine.setOutputHandler(output -> Assertions.assertEquals(1001, output));
        lilMachine.computeProgram();
    }

    @Test
    public void testEqualOpCode() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString(program));
        lilMachine.setInputHandler(() -> 8);
        lilMachine.setOutputHandler(output -> Assertions.assertEquals(1000, output));
        lilMachine.computeProgram();
    }

}
