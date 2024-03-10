import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class HomePage extends JFrame implements ActionListener {
    int colourState = 0;
    String QUERY;
    DatabaseHandler databaseHandler;
    Connection databaseConnection;
    JComboBox<String> sortByOptionsComboBox;
    JTextArea searchBarTextArea;
    JTextField sellByIdTextField;
    JButton sortButton, searchButton, sellButton, addToInventoryButton;
    String[] sortByOptionsComboBoxOptionsArray = {"id", "numberOfPages", "title", "genre", "authorName", "costPrice",
            "sellingPrice", "description", "coverPageIcon"};
    JLabel moneySpentLabel, moneyEarnedLabel, netIncomeLabel, sortByComboBoxLabel, searchBarTextAreaLabel, sellByIdLabel;
    double moneySpentValue, moneyEarnedValue;

    public HomePage(String query) {
        //=======================================
        this.databaseHandler = new DatabaseHandler("bookStore");
        this.databaseConnection = databaseHandler.getDatabaseConnection();
        try (Statement statement = databaseConnection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM store");
            while (resultSet.next()) {
//                System.out.print("Money spent : ");
//                System.out.print(resultSet.getDouble("moneySpent"));
//                System.out.print("\nMoney made : ");
//                System.out.print(resultSet.getDouble("moneyMade"));
//                System.out.print("\nNet Income : ");
//                System.out.print(resultSet.getDouble("netIncome"));
                this.moneySpentValue = resultSet.getDouble("moneySpent");
                this.moneyEarnedValue = resultSet.getDouble("moneyMade");

            }

        } catch (SQLException sqlException) {
            System.out.println("Exception in accessing store data " + sqlException.getMessage());

        }


        //========================================
        this.databaseHandler = new DatabaseHandler("bookStore");
        this.QUERY = query;
        setTitle("Home Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);

        // Create parent panel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS)); // Use BoxLayout with Y_AXIS
        //--------------------------------------------------------------------------------------------------------------

        try (Statement stmt = databaseConnection.createStatement()) {

            ResultSet rs = stmt.executeQuery(QUERY);

            while (rs.next()) {
                String id = rs.getString("id");
                int numberOfPages = rs.getInt("numberOfPages");
                String title = rs.getString("title");
                String authorName = rs.getString("authorName");
                float costPrice = rs.getFloat("costPrice");
                float sellingPrice = rs.getFloat("sellingPrice");
                String description = rs.getString("description");
                String genre = rs.getString("genre");


                // Reading BLOB data from the coverPageIcon column
                byte[] coverPageIconBytes = rs.getBytes("coverPageIcon");

                System.out.println("ID: " + id + "\n NumberOfPages: " + numberOfPages +
                        "\n Title: " + title + "\n AuthorName: " + authorName +
                        "\n CostPrice: " + costPrice + "\n SellingPrice: " + sellingPrice +
                        "\n Description: " + description + "\n CoverPageIcon size: " + coverPageIconBytes.length +
                        "\n genre" + genre + "\n length of blob : " + coverPageIconBytes.length);
                System.out.println("---------------------------------------------------------------------------------");
                JPanel childPanel = new JPanel();
                childPanel.setLayout(new BoxLayout(childPanel, BoxLayout.Y_AXIS));
                childPanel.setBackground(getRandomColor());
                System.out.println(this.colourState);
                //"Click To Copy Book ID To Sell By ID Bar : "+id
                JButton copyIdButton = new JButton("Copy To Sell ID = " + id);
                copyIdButton.setFocusable(false);
                // copyIdButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
                // copyIdButton.setBackground(Color.white);
                // copyIdButton.setEditable(false);

                copyIdButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        // Copy the text to the system clipboard

                        // StringSelection selection = new StringSelection();
                        sellByIdTextField.setText(id);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // Change button color on hover
                        copyIdButton.setBackground(new Color(0, 102, 0));
                        //  copyIdButton.setBackground(new Color(255, 255, 255));

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        // Restore button color when mouse exits
                        copyIdButton.setBackground(UIManager.getColor("Button.background"));
                        // copyIdButton.setBackground(new Color(232, 217, 201));

                    }
                });
                // copyIdButton.setBorder(BorderFactory.createRaisedBevelBorder());
                copyIdButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                //  copyIdButton.setBackground(new Color(232, 217, 201));
                copyIdButton.setForeground(Color.BLACK); // White text color
                copyIdButton.setFocusPainted(false); // Remove focus border

                ImageIcon imageIcon = new ImageIcon(coverPageIconBytes);
                Image image = imageIcon.getImage();
                image = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                imageIcon = new ImageIcon(image);

                // Create a JLabel to display the image
                JLabel imageLabel = new JLabel(imageIcon);
                imageLabel.setText("Cover Page");
                imageLabel.setHorizontalTextPosition(JLabel.CENTER);
                imageLabel.setVerticalTextPosition(JLabel.TOP);

                //--------------

//                // Create an ImageIcon from the byte array
//                ImageIcon originalIcon = new ImageIcon(imageData);
//
//                // Get the Image from the ImageIcon
//                Image originalImage = originalIcon.getImage();
//
//                // Resize the image
//                Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//
//                // Create a new ImageIcon from the resized image
//                ImageIcon resizedIcon = new ImageIcon(resizedImage);
//
//                // Create a JLabel with the resized ImageIcon
//                JLabel label = new JLabel(resizedIcon);


                //--------------


                childPanel.add(imageLabel);
                childPanel.add(new JLabel("<html>Book ID : " + id + " </html>"));
                childPanel.add(copyIdButton);
                childPanel.add(new JLabel("<html>Title : " + title + " </html>"));
                childPanel.add(new JLabel("<html>number Of pages : " + numberOfPages + " </html>"));
                childPanel.add(new JLabel("<html>Author's Name : " + authorName + " </html>"));
                childPanel.add(new JLabel("<html>Cost Price : " + costPrice + " </html>"));
                childPanel.add(new JLabel("<html>Selling Price : " + sellingPrice + " </html>"));
                childPanel.add(new JLabel("<html>Book Description : " + description + " </html>"));
                childPanel.add(new JLabel("<html>Book Genre : " + genre + " </html>"));
                parentPanel.add(childPanel);

            }


        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }


        //--------------------------------------------------------------------------------------------------------------
        // Add child panels to the parent panel
//        for (int i = 0; i < 100; i++) {
//            JPanel childPanel = new JPanel();
//            childPanel.setLayout(new GridLayout(10, 1)); // Use GridLayout for 5 labels in each child panel
//            //childPanel.setPreferredSize(new Dimension(200, 100));
//            childPanel.setBackground(getRandomColor()); // Vary background color
//
//            // Add labels to the child panel
//            for (int j = 0; j < 10; j++) {
//                JLabel label = new JLabel("Label " + (j + 1));
//                childPanel.add(label);
//            }
//
//            parentPanel.add(childPanel);
//        }
        //--------------------------------------------------------------------------------------------------------------
        // Create JScrollPane and add the parent panel to it
        JScrollPane scrollPane = new JScrollPane(parentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.getVerticalScrollBar().setUnitIncrement(80);
        scrollPane.getVerticalScrollBar().setBlockIncrement(80);

        scrollPane.setPreferredSize(new Dimension(500, 800)); // Set JScrollPane size to 300x300

        // Create a JPanel to add to the left of the JScrollPane
        JPanel controlMenu = new JPanel();
        controlMenu.setBackground(new Color(193, 215, 215)); // Just to visualize it better
        controlMenu.setPreferredSize(new Dimension(400, 800)); // Set size of the left panel

        //--------------------------------------------------------------------------------------------------

        controlMenu.setLayout(null);
        moneyEarnedLabel = new JLabel("Money Earned : " + moneyEarnedValue);
        moneySpentLabel = new JLabel("Money Spent : " + moneySpentValue);
        netIncomeLabel = new JLabel("Net Income : " + (moneyEarnedValue - moneySpentValue));

        moneySpentLabel.setBounds(0, 0, 400, 25);
        moneyEarnedLabel.setBounds(0, 25, 400, 25);
        netIncomeLabel.setBounds(0, 50, 400, 25);

        //-----------------------------------------------------------------------------------------

        sortByOptionsComboBox = new JComboBox<String>(sortByOptionsComboBoxOptionsArray);
        sortByOptionsComboBox.addActionListener(this);

        sortByComboBoxLabel = new JLabel("sort by :");
        sortByComboBoxLabel.setBounds(0, 75, 100, 25);
        sortByOptionsComboBox.setBounds(50, 75, 150, 25);

        sortButton = new JButton("sort");
        sortButton.setBounds(205, 75, 100, 25);
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


        searchBarTextAreaLabel.setBounds(150, 125, 100, 25);
        searchBarTextArea.setBounds(0, 175, 400, 50);
        searchButton.setBounds(150, 230, 100, 25);


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


        sellByIdLabel.setBounds(0, 275, 50, 25);
        sellByIdTextField.setBounds(50, 275, 200, 25);
        sellByIdTextField.addActionListener(this);
        sellButton.setBounds(250, 275, 100, 25);


        sellButton.setFocusable(false);
        sellButton.addActionListener(this);


        controlMenu.add(sellByIdLabel);
        controlMenu.add(sellByIdTextField);
        controlMenu.add(sellButton);

        //-----------------------------------------------------------------------------------------
        addToInventoryButton = new JButton("Add Inventory");
        addToInventoryButton.setBounds(0, 325, 200, 25);
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
        this.colourState %= 3;
        if (this.colourState == 0) {
            this.colourState++;
            return new Color(135, 245, 228);


        }
        if (this.colourState == 1) {
            this.colourState++;
            return new Color(102, 255, 255);
        }
        if (this.colourState == 2) {
            this.colourState++;
            return new Color(204, 255, 255);
        }
        return new Color(193, 215, 215);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println("actionPerformed");

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomePage("SELECT * FROM inventory"));
    }
}
