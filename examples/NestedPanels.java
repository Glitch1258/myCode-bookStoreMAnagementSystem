import javax.swing.*;
import java.awt.*;

public class NestedPanels extends JFrame {
    public NestedPanels() {
        setTitle("Panel Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout()); // Set layout manager

        // Create child panels
        JPanel childPanel1 = new JPanel();
        childPanel1.setBackground(Color.RED);
        childPanel1.setPreferredSize(new Dimension(200, 100));

        JPanel childPanel2 = new JPanel();
        childPanel2.setBackground(Color.BLUE);
        childPanel2.setPreferredSize(new Dimension(200, 100));

        // Add child panels to the main panel
        mainPanel.add(childPanel1, BorderLayout.NORTH);
        mainPanel.add(childPanel2, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);

        pack();
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NestedPanels::new);
    }
}
