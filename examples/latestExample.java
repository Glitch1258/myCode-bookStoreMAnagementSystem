import javax.swing.*;
import java.awt.*;

public class latestExample extends JFrame {
    public latestExample() {
        setTitle("Scroll Pane Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a JScrollPane
        JScrollPane scrollPane = new JScrollPane();

        // Create a JPanel to hold all the child panels
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 1)); // Use GridLayout for vertical stacking

        // Create and add child panels
        for (int i = 0; i < 10; i++) {
            JPanel childPanel = new JPanel();
            childPanel.setPreferredSize(new Dimension(200, 50)); // Set preferred size for demonstration
            childPanel.setBackground(Color.WHITE); // Set background color
            mainPanel.add(childPanel);
        }

        // Add the main panel to the scroll pane
        scrollPane.setViewportView(mainPanel);

        // Add the scroll pane to the JFrame
        add(scrollPane, BorderLayout.CENTER);

        setSize(300, 300);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new latestExample());
    }
}
