package day6.part2;

import utils.InputReader;
import utils.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    private final List<Pair<String, String>> orbits;

    public Part2(List<String> input){
        orbits = new ArrayList<>();

        for(String s : input){
            orbits.add(parsePair(s));
        }

        TreeNode<String> com = buildTree("COM");
        TreeNode<String> lowestCommonNode = com.findLowestCommonNode("YOU", "SAN");
        System.out.println(lowestCommonNode.calculateDepthOf("YOU")-1 + lowestCommonNode.calculateDepthOf("SAN")-1);
    }

    private TreeNode<String> buildTree(String data){
        TreeNode<String> t = new TreeNode<>(data);
        for(String child : findChildrenFor(data))
            t.addChild(buildTree(child));
        return t;
    }

    private List<String> findChildrenFor(String s){
        List<String> output = new ArrayList<>();
        for(Pair<String, String> p : orbits){
            if(p.getFst().equals(s)){
                output.add(p.getSnd());
            }
        }
        return output;
    }

    public Pair<String, String> parsePair(String s){
        return new Pair<>(s.substring(0, s.indexOf(')')), s.substring(s.indexOf(')')+1));
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Part2(new InputReader().readAsList("day6.txt"));
    }
}
