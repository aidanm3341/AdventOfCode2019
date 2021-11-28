import lilmachine.LilMachine;
import lilmachine.ProgramReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class LilMachineTests {

    private LilMachine lilMachine;
    private ProgramReader programReader;

    @BeforeEach
    public void init(){
        programReader = new ProgramReader();
    }

    @Test
    public void testBasicAddition() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString("1,0,0,0,99"));
        lilMachine.computeProgram();
        Assertions.assertEquals(2, lilMachine.getState().get(0));
    }

    @Test
    public void testBasicMultiplication() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString("2,3,0,3,99"));
        lilMachine.computeProgram();
        Assertions.assertEquals(6, lilMachine.getState().get(3));
    }

    @Test
    public void testAdditionThenMultiplication() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString("2,4,4,5,99,0"));
        lilMachine.computeProgram();
        Assertions.assertEquals(9801, lilMachine.getState().get(5));
    }

    @Test
    public void testMoreComplexMultiplication() throws FileNotFoundException {
        lilMachine = new LilMachine(programReader.readProgramFromString("1,1,1,4,99,5,6,0,99"));
        lilMachine.computeProgram();
        Assertions.assertEquals(30, lilMachine.getState().get(0));
        Assertions.assertEquals(2, lilMachine.getState().get(4));
    }

}
