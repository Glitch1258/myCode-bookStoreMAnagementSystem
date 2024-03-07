import javax.swing.*;
import java.awt.*;

public class ScrollPaneExampleNestedPanels extends JFrame {
    public ScrollPaneExampleNestedPanels() {
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

        add(scrollPane);

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
