import javax.swing.*;
import java.awt.*;

public class ProbablyTheFinalFormat extends JFrame {
    public ProbablyTheFinalFormat() {
        setTitle("Scroll Pane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // Set window size to 500x500

        // Create parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS

        // Add child panels to the parent panel
        for (int i = 0; i < 100; i++) {
            JPanel childPanel = new JPanel();
            childPanel.setLayout(new GridLayout(5, 1)); // Use GridLayout for 5 labels in each child panel
            childPanel.setPreferredSize(new Dimension(200, 100));
            childPanel.setBackground(getRandomColor()); // Vary background color

            // Add labels to the child panel
            for (int j = 0; j < 5; j++) {
                JLabel label = new JLabel("Label " + (j + 1));
                childPanel.add(label);
            }

            parentPanel.add(childPanel);
        }

        // Create JScrollPane and add the parent panel to it
        JScrollPane scrollPane = new JScrollPane(parentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(300, 300)); // Set JScrollPane size to 300x300

        // Create a JPanel to add to the left of the JScrollPane
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.RED); // Just to visualize it better
        leftPanel.setPreferredSize(new Dimension(100, 300)); // Set size of the left panel

        // Create a BorderLayout for the JFrame
        setLayout(new BorderLayout());

        // Add the JScrollPane to the center and the leftPanel to the west
        add(scrollPane, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to generate random background color
    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProbablyTheFinalFormat::new);
    }
}
