import javax.swing.*;

public class BoxLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("BoxLayout Example");
        JPanel panel = new JPanel();

        // Set the layout manager of the panel to BoxLayout with vertical orientation
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add components to the panel
        panel.add(new JButton("Button 1"));
        panel.add(new JButton("Button 2"));
        panel.add(new JButton("Button 3"));

        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
