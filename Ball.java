
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball
{
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;
    private static final int DIAMETER = 30;
    
    public Ball(Game game) {
        this.game = game;
    }
    
    public void move() {
        if (x + xa < 0) {
            xa = 1;
        }
        if (x + xa > game.getWidth() - DIAMETER) {
            xa = -1;
        }
        if (y + ya < 0) {
            ya = 1;
        }
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()) {
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
        }
        x += xa;
        y += ya;
    }

    public void paint(Graphics gr) {
        gr.fillOval(x, y, DIAMETER, DIAMETER);
    }
    
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
    
    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }
    
    public static void main(String args[])
    {
    }
}
