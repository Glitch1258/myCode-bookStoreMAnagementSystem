import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HomePage extends JFrame implements ActionListener {
    String QUERY;
    DatabaseHandler databaseHandler;
    JComboBox<String> sortByOptionsComboBox;
    JTextArea searchBarTextArea;
    JTextField sellByIdTextField;
    JButton sortButton, searchButton , sellButton , addToInventoryButton;
    String []sortByOptionsComboBoxOptionsArray = {"id","numberOfPages","title","genre","authorName","costPrice",
            "sellingPrice","description","coverPageIcon"};
    JLabel moneySpentLabel,moneyEarnedLabel,netIncomeLabel,sortByComboBoxLabel, searchBarTextAreaLabel , sellByIdLabel;
    double  moneySpentValue,moneyEarnedValue;
    public HomePage(String query) {
        //=======================================
        this.databaseHandler = new DatabaseHandler("bookStore");






        //========================================
        this.databaseHandler = new DatabaseHandler("bookStore");
        this.QUERY = query;
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);

        // Create parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS

        // Add child panels to the parent panel
        for (int i = 0; i < 100; i++) {
            JPanel childPanel = new JPanel();
            childPanel.setLayout(new GridLayout(10, 1)); // Use GridLayout for 5 labels in each child panel
            //childPanel.setPreferredSize(new Dimension(200, 100));
            childPanel.setBackground(getRandomColor()); // Vary background color

            // Add labels to the child panel
            for (int j = 0; j < 10; j++) {
                JLabel label = new JLabel("Label " + (j + 1));
                childPanel.add(label);
            }

            parentPanel.add(childPanel);
        }

        // Create JScrollPane and add the parent panel to it
        JScrollPane scrollPane = new JScrollPane(parentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(80);
        scrollPane.getVerticalScrollBar().setBlockIncrement(80);

        scrollPane.setPreferredSize(new Dimension(500, 800)); // Set JScrollPane size to 300x300

        // Create a JPanel to add to the left of the JScrollPane
        JPanel controlMenu = new JPanel();
        controlMenu.setBackground(Color.RED); // Just to visualize it better
        controlMenu.setPreferredSize(new Dimension(400, 800)); // Set size of the left panel

        //--------------------------------------------------------------------------------------------------

        controlMenu.setLayout(null);
        moneyEarnedLabel = new JLabel("Money Earned : "+moneyEarnedValue);
        moneySpentLabel = new JLabel("Money Spent : "+moneySpentValue);
        netIncomeLabel = new JLabel("Net Income : "+(moneyEarnedValue-moneySpentValue));

        moneySpentLabel.setBounds(0,0,100,25);
        moneyEarnedLabel.setBounds(0,25,100,25);
        netIncomeLabel.setBounds(0,50,100,25);

        //-----------------------------------------------------------------------------------------

        sortByOptionsComboBox = new JComboBox<String>(sortByOptionsComboBoxOptionsArray);
        sortByOptionsComboBox.addActionListener(this);

        sortByComboBoxLabel = new JLabel("sort by :");
        sortByComboBoxLabel.setBounds(0,75,100,25);
        sortByOptionsComboBox.setBounds(50,75,100,25);

        sortButton = new JButton("sort");
        sortButton.setBounds(150,75,100,25);
        sortButton.setFocusable(false);
        sortButton.addActionListener(this);


        controlMenu.add(moneySpentLabel);
        controlMenu.add(moneyEarnedLabel);
        controlMenu.add(netIncomeLabel);
        controlMenu.add(sortByComboBoxLabel);
        controlMenu.add(sortByOptionsComboBox);
        controlMenu.add(sortButton);


        //-----------------------------------------------------------------------------------------



        searchBarTextArea = new JTextArea();
        searchBarTextAreaLabel = new JLabel("search");
        searchButton = new JButton("search");


        searchBarTextAreaLabel.setBounds(150,125,100,25);
        searchBarTextArea.setBounds(0,175,400,50);
        searchButton.setBounds(150,230,100,25);


        searchBarTextAreaLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        searchBarTextArea.setLineWrap(true);
        searchBarTextArea.setEditable(true);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);


        controlMenu.add(searchBarTextAreaLabel);
        controlMenu.add(searchBarTextArea);
        controlMenu.add(searchButton);


        //-----------------------------------------------------------------------------------------


        sellByIdTextField = new JTextField();
        sellByIdLabel = new JLabel("Sell ID :");
        sellButton = new JButton("Sell");


        sellByIdLabel.setBounds(0,275,50,25);
        sellByIdTextField.setBounds(50,275,200,25);
        sellByIdTextField.addActionListener(this);
        sellButton.setBounds(250,275,100,25);


        sellButton.setFocusable(false);
        sellButton.addActionListener(this);


        controlMenu.add(sellByIdLabel);
        controlMenu.add(sellByIdTextField);
        controlMenu.add(sellButton);

        //-----------------------------------------------------------------------------------------
        addToInventoryButton = new JButton("Add Inventory");
        addToInventoryButton.setBounds(0,325,200,25);
        addToInventoryButton.addActionListener(this);
        addToInventoryButton.setFocusable(false);
        controlMenu.add(addToInventoryButton);
        //---------------------------------------------------------------------------------------------






        // Create a BorderLayout for the JFrame
        setLayout(new BorderLayout());//<--NULL layout

        // Add the JScrollPane to the center and the leftPanel to the west
        add(scrollPane, BorderLayout.CENTER);
        add(controlMenu, BorderLayout.WEST);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Method to generate random background color
    private Color getRandomColor() {
        //208, 211, 212 control Pane color
        int r = (int) (Math.random() * 256);//174, 214, 241
        int g = (int) (Math.random() * 256);//213, 219, 219
        int b = (int) (Math.random() * 256);//250, 215, 160
        return new Color(r, g, b);
    }
    public void actionPerformed(ActionEvent actionEvent){
        System.out.println("actionPerformed");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage("query"));
    }
}
