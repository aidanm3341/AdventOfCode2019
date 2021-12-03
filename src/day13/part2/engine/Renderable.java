package day13.part2.engine;

public interface Renderable {
    void initialise(ProgramViewer programViewer);
    void render(Screen screen);
}
