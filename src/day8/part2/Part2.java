package day8.part2;

import utils.InputReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Part2 {

    public static final int LAYER_WIDTH = 25, LAYER_HEIGHT = 6;

    private final List<Integer> data;
    private int width, height;

    public Part2(List<Integer> data, int width, int height){
        this.data = data;
        this.width = width;
        this.height = height;
    }

    public int countNumberOfOccurencesOnLayer(int layer, int target){
        int count = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if(getDataForLayerAndCoordinate(layer, i, j) == target)
                    count++;
            }
        }
        return count;
    }

    public int layerCount(){
        return data.size() / (width * height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDataForLayerAndCoordinate(int layerNum, int x, int y){
        int layerOffset = (layerNum * width * height);
        return data.get(layerOffset + x + (width * y));
//        return data.get(layerOffset + y + (height * x));
    }


    public static void main(String[] args) throws FileNotFoundException {
        String input = new InputReader().readAsList("day8.txt").get(0);
        Part2 part2 = new Part2(input.chars()
                .mapToObj(c -> (char)c)
                .map(c -> Integer.parseInt(String.valueOf(c)))
                .collect(Collectors.toList()),
                LAYER_WIDTH, LAYER_HEIGHT);


//        int[][] finalImage = new int[LAYER_HEIGHT][LAYER_WIDTH];
//        for (int i = part2.layerCount()-1; i >= 0; i--) {
////        for (int i = 0; i < part1.layerCount(); i++) {
//            for (int j = 0; j < LAYER_WIDTH; j++) {
//                for (int k = 0; k < LAYER_HEIGHT; k++) {
//                    int data = part2.getDataForLayerAndCoordinate(i, j, k);
//                    if(data != 2)
//                        finalImage[k][j] = data;
//                }
//            }
//        }

        int[] finalImage = new int[LAYER_WIDTH * LAYER_HEIGHT];
        for (int i = part2.layerCount()-1; i >= 0; i--) {
            for (int j = 0; j < LAYER_WIDTH; j++) {
                for (int k = 0; k < LAYER_HEIGHT; k++) {
                    int data = part2.getDataForLayerAndCoordinate(i, j, k);
                    if(data != 2)
//                        finalImage[(j * LAYER_HEIGHT) + k] = data;
                        finalImage[j + (LAYER_WIDTH * k)] = data;
                }
            }
        }

        Part2 image = new Part2(Arrays.stream(finalImage).boxed().collect(Collectors.toList()), LAYER_WIDTH, LAYER_HEIGHT);

        List<String> outputRows = new ArrayList<>();
        for (int i = 0; i < LAYER_HEIGHT; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < LAYER_WIDTH; j++) {
                builder.append(image.getDataForLayerAndCoordinate(0, j, i));
                builder.append(' ');
            }
            outputRows.add(builder.toString());
        }

        outputRows.stream()
                .map(s -> s.replaceAll("0", " "))
                .map(s -> s.replaceAll("1", "X"))
                .forEach(System.out::println);

        //System.out.println(outputRows.stream().reduce((acc, str) -> acc + str));
    }
}
