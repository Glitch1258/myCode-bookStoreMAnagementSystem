import javax.swing.*;
import java.awt.*;

public class ScrollPaneWithMultiplePanelsExample {
    public static void main(String[] args) {
        // Create JPanels with different content
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(5, 1)); // Example layout manager for panel1
        panel1.setBackground(Color.RED);
        for (int i = 1; i <= 5; i++) {
            panel1.add(new JLabel("Label " + i));
        }

        JPanel panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Example layout manager for panel2
        panel2.setBackground(Color.GREEN);
        for (int i = 6; i <= 10; i++) {
            panel2.add(new JLabel("Label " + i));
        }

        JPanel panel3 = new JPanel();
        panel3.setLayout(new FlowLayout()); // Example layout manager for panel3
        panel3.setBackground(Color.BLUE);
        for (int i = 11; i <= 15; i++) {
            panel3.add(new JLabel("Label " + i));
        }

        // Create a JScrollPane and add the panels to it
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setLayout(new ScrollPaneLayout()); // Set the layout policy of the JScrollPane (not commonly done)
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Example scrollbar policy
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // Example scrollbar policy
        scrollPane.setViewportView(panel1); // Set panel1 as the view of the scroll pane

        // Add more panels to the JScrollPane
        scrollPane.setColumnHeaderView(panel2); // Add panel2 as the column header
        scrollPane.setRowHeaderView(panel3); // Add panel3 as the row header

        // Create a JFrame to hold the scroll pane
        JFrame frame = new JFrame("ScrollPane with Multiple Panels Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
