
/**
 * Game
 *
 * Dennis Amadi
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game extends JPanel
{
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this);
    
    public Game() {
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {
            }
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
            }
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
            }
        });
        setFocusable(true);
    }
    private void move() {
        ball.move();
        racquet.move();
    }
    
    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        System.exit(ABORT);
    }
    
    private void moveBall() {
        // if (x + xa < 0) {
            // xa = 1;
        // }
        // if (x + xa > getWidth() - 30) {
            // xa = -1;
        // }
        // if (y + ya < 0) {
            // ya = 1;
        // }
        // if (y + ya > getHeight() - 30) {
            // ya = -1;
        // }
        // x += xa;
        // y += ya;
    }

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);
        Graphics2D canvas = (Graphics2D) gr;
        // canvas.fillOval(x, y, 30, 30);
        ball.paint(canvas);
        racquet.paint(canvas);
        canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }
    
    public static void main(String args[]) throws InterruptedException
    {
        JFrame frame = new JFrame("My Game"); // title of the window
        
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
