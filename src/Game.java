import java.util.Random;

/**
 *
 */
public class Game {

    private Board board;
    private Ui ui;

    public Game(int width, int height) {
        this.board = new Board(width, height);

        Random random = new Random();
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (random.nextBoolean()) {
                    board.set(x, y);
                }
            }
        }
        board.set(2, 1);
        board.set(2, 2);
        board.set(2, 3);
    }

    public static void main(String[] args) throws InterruptedException {
        Ui ui = new Ui();
        Game game = new Game(50, 50);
        game.setUi(ui);
        while (true) {
            game.tick();
            game.printBoard();
            Thread.sleep(200);
        }
    }

    private void setUi(Ui ui) {
        this.ui = ui;
    }

    void tick() {
        board = board.nextState();
    }

    void printBoard() {
        ui.update(board);
    }
}
