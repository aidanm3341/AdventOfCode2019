package day7.part1;

import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public int tryCombination(int phase1, int phase2, int phase3, int phase4, int phase5){
        Amplifier amp1 = new Amplifier(phase1);
        Amplifier amp2 = new Amplifier(phase2);
        Amplifier amp3 = new Amplifier(phase3);
        Amplifier amp4 = new Amplifier(phase4);
        Amplifier amp5 = new Amplifier(phase5);

        return amp5.calculateOutput(amp4.calculateOutput(amp3.calculateOutput(amp2.calculateOutput(amp1.calculateOutput(0)))));
    }

    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        permuteHelper(list, new ArrayList<>(), arr);
        return list;
    }

    private void permuteHelper(List<List<Integer>> list, List<Integer> resultList, int [] arr){
        // Base case
        if(resultList.size() == arr.length){
            list.add(new ArrayList<>(resultList));
        }
        else{
            for(int i = 0; i < arr.length; i++){

                if(resultList.contains(arr[i])) {
                    // If element already exists in the list then skip
                    continue;
                }
                // Choose element
                resultList.add(arr[i]);
                // Explore
                permuteHelper(list, resultList, arr);
                // Unchoose element
                resultList.remove(resultList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Part1 part1 = new Part1();

        List<List<Integer>> permutations = part1.permute(new int[]{0, 1, 2, 3, 4});

        int max = 0;
        for(List<Integer> inputs : permutations){
            int output = part1.tryCombination(inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3), inputs.get(4));
            max = Math.max(max, output);
        }
        System.out.println(max);
    }
}
