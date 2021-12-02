package day13;

public class Part1 {
    public static void main(String[] args) {
        ArcadeMachine arcadeMachine = new ArcadeMachine();
        arcadeMachine.turnOn();
        System.out.println(arcadeMachine.countOccurrencesOf(2L));
    }
}
