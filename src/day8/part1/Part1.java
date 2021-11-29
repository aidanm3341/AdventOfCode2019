package day8.part1;

import utils.InputReader;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class Part1 {

    public static final int LAYER_WIDTH = 25;
    public static final int LAYER_HEIGHT = 6;

    private final List<Integer> data;

    public Part1(List<Integer> data){
        this.data = data;
    }

    public int countNumberOfOccurencesOnLayer(int layer, int target){
        int count = 0;
        for (int i = 0; i < LAYER_WIDTH; i++) {
            for (int j = 0; j < LAYER_HEIGHT; j++) {
                if(getDataForLayerAndCoordinate(layer, i, j) == target)
                    count++;
            }
        }
        return count;
    }

    public int layerCount(){
        return data.size() / (LAYER_HEIGHT * LAYER_WIDTH);
    }


    public int getDataForLayerAndCoordinate(int layerNum, int x, int y){
        int layerOffset = (layerNum * LAYER_WIDTH * LAYER_HEIGHT);
        return data.get(layerOffset + (x * LAYER_HEIGHT) + y);
    }


    public static void main(String[] args) throws FileNotFoundException {
        String input = new InputReader().readAsList("day8.txt").get(0);
        Part1 part1 = new Part1(input.chars()
                .mapToObj(c -> (char)c)
                .map(c -> Integer.parseInt(String.valueOf(c)))
                .collect(Collectors.toList()));

        int min = Integer.MAX_VALUE;
        int layerWithMin = -1;
        for (int i = 0; i < part1.layerCount(); i++) {
            int count = part1.countNumberOfOccurencesOnLayer(i, 0);
            if(count < min){
                min = count;
                layerWithMin = i;
            }
        }
        System.out.println(part1.countNumberOfOccurencesOnLayer(layerWithMin, 1) * part1.countNumberOfOccurencesOnLayer(layerWithMin, 2));
    }
}
