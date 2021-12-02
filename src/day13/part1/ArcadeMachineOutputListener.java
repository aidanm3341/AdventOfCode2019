package day13.part1;

public interface ArcadeMachineOutputListener {
    void sendNewTile(int x, int y, int tileID);
    void updateScore(long score);
}
