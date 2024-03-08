import javax.swing.*;

public class ScrollPaneExample2 {
    public static void main(String[] args) {
        // Create a JTextArea (or any other component) to put inside the scroll pane
        JTextArea textArea = new JTextArea(10, 30); // Example JTextArea with 10 rows and 30 columns
        textArea.setLineWrap(true);

        // Create a JLabel for additional content
        JLabel additionalLabel = new JLabel("Additional Label");

        // Create a JPanel to hold the text area and the additional label vertically
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical arrangement
        panel.add(textArea);
        panel.add(additionalLabel);

        // Create a JScrollPane and add the JPanel to it
        JScrollPane scrollPane = new JScrollPane(panel);

        // Set the horizontal scrolling policy to NEVER
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Create a JFrame to hold the scroll pane
        JFrame frame = new JFrame("Scroll Pane Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane); // Add the scroll pane to the frame
        frame.pack(); // Pack the frame to fit the preferred size of its components
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true); // Make the frame visible
    }
}
