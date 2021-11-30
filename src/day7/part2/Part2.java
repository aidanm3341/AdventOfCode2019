package day7.part2;

import utils.Permuter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Part2 {

    public long tryCombination(int... phases) throws InterruptedException {
        List<Amplifier> amps = Arrays.stream(phases)
                .mapToObj(Amplifier::new)
                .collect(Collectors.toList());

        for (int i = 0; i < amps.size()-1; i++)
            amps.get(i).setOutputHandler(amps.get(i+1)::addInput);

        // deal with case which loops back to the first amp, or terminates
        amps.get(amps.size()-1).setOutputHandler(output -> {
            if(amps.get(amps.size()-2).isComplete())
                amps.get(amps.size()-1).setOutput(output);
            else
                amps.get(0).addInput(output);
        });

        // start off the input chain
        amps.get(0).addInput(0);

        ExecutorService threadManager = Executors.newFixedThreadPool(amps.size());
        amps.forEach(amp -> threadManager.submit(new Thread(amp)));

        threadManager.shutdown();
        threadManager.awaitTermination(10, TimeUnit.SECONDS);

        return amps.get(amps.size()-1).getOutput();
    }

    public static void main(String[] args) throws InterruptedException {
        Part2 part2 = new Part2();

        List<List<Integer>> permutations = Permuter.permute(new int[]{5, 6, 7, 8, 9});

        long max = 0;
        for(List<Integer> inputs : permutations){
            long output = part2.tryCombination(inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3), inputs.get(4));
            max = Math.max(max, output);
        }
        System.out.println(max);
    }
}
