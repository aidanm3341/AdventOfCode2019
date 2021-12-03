package day13.part2.engine;

public interface BasicGame {
    void init(ProgramViewer programViewer);
    void update();
    void render(Screen screen);
}
