import java.awt.Graphics2D;
import java.io.PrintStream;

public class Board {
    private final int width;
    private final int height;
    private Cell[] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new Cell[width * height];
        for (int i=0; i<cells.length; i++) {
            cells[i] = new Cell();
        }

        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                Cell cell = getCell(x,y);
                cell.addNeighbour(getCell(x - 1, y + 1));
                cell.addNeighbour(getCell(x, y + 1));
                cell.addNeighbour(getCell(x + 1, y + 1));
                cell.addNeighbour(getCell(x - 1, y));
                cell.addNeighbour(getCell(x + 1, y));
                cell.addNeighbour(getCell(x - 1, y - 1));
                cell.addNeighbour(getCell(x, y - 1));
                cell.addNeighbour(getCell(x+1, y-1));
            }
        }
    }

    private Cell getCell(int x, int y) {
        if (x < 0 || x >= width) {
            return new NullCell();
        }
        if (y < 0 || y >= height) {
            return new NullCell();
        }
        return cells[x + y*width];
    }

    public Board nextState() {
        Board nextboard = new Board(this.width, this.height);
        for (int i=0; i<cells.length; i++) {
            nextboard.cells[i].setState(this.cells[i].nextState());
        }
        return nextboard;
    }

    public void set(int x, int y) {
        getCell(x, y).setState(State.ALIVE);
    }

    public void print(PrintStream out) {
        for (int i=0; i<cells.length; i++) {
            if (i%width == 0) {
                out.println();
            }
            cells[i].print(out);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void paint(Graphics2D g2d) {
        for (int x=0; x<width; x++) {
            for (int y=0; y<height; y++) {
                Cell cell = getCell(x, y);
                if (cell.isAlive()) {
                    g2d.fillRect(x, y, 1, 1);
                }
            }
        }
    }
}
