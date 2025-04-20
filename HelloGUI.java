import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloGUI {
    public static void main(String[] args) {
        // Create the Window.
        JFrame frame = new JFrame("My First Interface");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text
        JLabel label = new JLabel("Hello, World!", JLabel.CENTER);

        // Add text to window
        frame.add(label);

        // Show window
        frame.setVisible(true);
    }
}
