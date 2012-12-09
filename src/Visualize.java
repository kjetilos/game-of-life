import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Visualize extends JPanel {

    private Board board;

    public void update(Board board) {
        this.board = board;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (board == null) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(0, 0, getWidth(), getHeight());
        double xscale = (double)getWidth() / board.getWidth();
        double yscale = (double)getHeight() / board.getHeight();
        g2d.scale(xscale, yscale);
        g2d.setColor(Color.BLACK);
        board.paint(g2d);
    }

}
