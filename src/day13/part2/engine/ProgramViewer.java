package day13.part2.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class ProgramViewer extends JPanel{

    public static int HEIGHT;
    public static int WIDTH;
    public static int SCALE;

    private final BufferedImage image;
    private final int[] pixels;
    private final Screen screen;

    private final JFrame frame;
    private final Canvas canvas;

    private final Renderable game;

    public ProgramViewer(String name, Renderable game, int width, int height, int scale)
    {
        WIDTH = width;
        HEIGHT = height;
        SCALE = scale;

        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        screen = new Screen(WIDTH, HEIGHT);

        game.initialise(this);

        canvas = new Canvas();
        canvas.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        canvas.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        canvas.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        this.game = game;

        frame = new JFrame(name);

        this.setLayout(new BorderLayout());
        this.add(canvas, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
        requestFocus();
    }

    public void draw() {
        BufferStrategy bs = canvas.getBufferStrategy();
        if (bs == null) {
            canvas.createBufferStrategy(3);
            canvas.requestFocus();
            return;
        }

        game.render(screen);

        for (int y = 0; y < screen.h; y++) {
            for (int x = 0; x < screen.w; x++) {
                pixels[x + y * WIDTH] = screen.pixels[x + y * screen.w];
            }
        }

        Graphics g = bs.getDrawGraphics();
        g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int ww = WIDTH * SCALE;
        int hh = HEIGHT * SCALE;
        int xo = (canvas.getWidth() - ww) / 2;
        int yo = (canvas.getHeight() - hh) / 2;
        g.drawImage(image, xo, yo, ww, hh, null);
        g.dispose();
        bs.show();
    }

    @Override
    public void add(Component comp, Object constraints) {
        super.add(comp, constraints);
        frame.pack();
    }

    public void addKeyListener(KeyListener keyListener){
        super.addKeyListener(keyListener);
        frame.addKeyListener(keyListener);
    }
}
