package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

    public Stream<String> readAsStream(String src) throws FileNotFoundException {
        FileReader fr = new FileReader("resources/" + src);
        BufferedReader br = new BufferedReader(fr);
        return br.lines();
    }

    public List<String> readAsList(String src) throws FileNotFoundException {
        FileReader fr = new FileReader("resources/" + src);
        BufferedReader br = new BufferedReader(fr);
        return br.lines().collect(Collectors.toList());
    }

    public List<Integer> readProgram(String src) throws FileNotFoundException {
        FileReader fr = new FileReader("resources/" + src);
        BufferedReader br = new BufferedReader(fr);

        String programAsLine = br.lines().collect(Collectors.toList()).get(0);

        return Arrays.stream(programAsLine.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}