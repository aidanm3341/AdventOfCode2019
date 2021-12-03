package day13.part2.engine;

public enum Tile {
    EMPTY(0), WALL(1), BLOCK(2), PADDLE(3), BALL(4);

    private final int id;

    Tile(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Tile getTileFromID(int id){
        return switch(id){
            case 1 -> WALL;
            case 2 -> BLOCK;
            case 3 -> PADDLE;
            case 4 -> BALL;
            default -> EMPTY;
        };
    }
}
