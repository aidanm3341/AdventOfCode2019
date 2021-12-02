package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class PairTest {

    @BeforeEach
    public void init(){

    }

    @Test
    public void testEquals() {
        Pair<Integer, Integer> p1 = new Pair<>(1, 1), p2 = new Pair<>(1, 1);
        Assertions.assertEquals(p2, p1);
    }

    @Test
    public void testEqualsWithSet() {
        Set<Pair<Integer, Integer>> pairSet = new HashSet<>();
        Pair<Integer, Integer> p1 = new Pair<>(1, 1), p2 = new Pair<>(1, 1);
        pairSet.add(p1);
        pairSet.add(p2);
        Assertions.assertEquals(1, pairSet.size());
    }


}
