package lilmachine;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgramReader {
    public List<Long> readProgram(String src) throws FileNotFoundException {
        FileReader fr = new FileReader("resources/" + src);
        BufferedReader br = new BufferedReader(fr);

        String programAsLine = br.lines().collect(Collectors.toList()).get(0);

        return Arrays.stream(programAsLine.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    public List<Long> readProgramFromString(String programAsLine){
        return Arrays.stream(programAsLine.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }
}
