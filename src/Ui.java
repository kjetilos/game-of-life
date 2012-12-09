import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Ui {

    private Visualize v;

    public Ui() {
        JFrame frame = new JFrame("Ui");
        v = new Visualize();
        frame.add(v);

        frame.setBounds(0, 0, 640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void update(Board board) {
        v.update(board);
    }
}
