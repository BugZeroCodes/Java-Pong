
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Racquet
{
    int x = 0;
    int xa = 1;
    private Game game;
    private static final int Y = 330;
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    
    public Racquet(Game game) {
        this.game = game;
    }
    
    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH) {
            x += xa;
        }
    }

    public void paint(Graphics gr) {
        gr.fillRect(x, Y, WIDTH, HEIGHT);
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }
    
    public void keyReleased(KeyEvent e) {
        xa = 0;
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, Y, WIDTH, HEIGHT);
    }
    
    public int getTopY() {
        return Y;
    }
}
