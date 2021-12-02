package day13.part1;

public class Part1 {
    public static void main(String[] args) {
        ArcadeMachine arcadeMachine = new ArcadeMachine();
        arcadeMachine.turnOn();
        System.out.println(arcadeMachine.getGrid().toString());
        System.out.println(arcadeMachine.getGrid().getWidth() + " " + arcadeMachine.getGrid().getHeight());
        System.out.println(arcadeMachine.countOccurrencesOf(2L));
    }
}
