import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.UUID;

public class AddItem extends JFrame implements ActionListener {
    Double moneySpent;
    DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");
    Connection databaseConnection = databaseHandler.getDatabaseConnection();


    JLabel container, heading, bookTitleLabel, idLabel, idValueJlabel,
            numberOfPagesLabel, bookGenreLabel, authorNameLabel,
            costPriceLabel, sellingPriceLabel, bookDescriptionLabel, bookCoverImageLabel;
    JTextField bookTitleTextField, numberOfPagesTextField, idTextField,
            bookGenreTextField, authorNameTextField,
            costPriceTextField, sellingPriceTextField;
    JTextArea bookDescriptionTextArea;
    JScrollPane scrollPane;
    JButton addToInventoryButton, browseButton, goToHomePageButton;
    byte[] imageData;
    Image bookCover;
    UUID universallyUniqueIdentifier = UUID.randomUUID();
    String id = universallyUniqueIdentifier.toString();


    AddItem() {
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        container = new JLabel() {
            // Override paintComponent to set background color
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.lightGray);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        container.setBounds(0, 0, 1120, 630);
        container.setBackground(Color.darkGray);
        add(container);

        heading = new JLabel("Add Book");
        heading.setBounds(20, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        container.add(heading);


        bookTitleLabel = new JLabel("Book Title : ");
        bookTitleLabel.setBounds(20, 50, 1000, 100);
        container.add(bookTitleLabel);

        bookTitleTextField = new JTextField();
        bookTitleTextField.setBounds(150, 85, 350, 30);
        container.add(bookTitleTextField);

        numberOfPagesLabel = new JLabel("Number of pages : ");
        numberOfPagesLabel.setBounds(20, 100, 1000, 100);
        container.add(numberOfPagesLabel);

        numberOfPagesTextField = new JTextField();
        numberOfPagesTextField.setBounds(150, 135, 350, 30);
        container.add(numberOfPagesTextField);

        bookGenreLabel = new JLabel("Book Genre : ");
        bookGenreLabel.setBounds(20, 150, 1000, 100);
        container.add(bookGenreLabel);

        bookGenreTextField = new JTextField();
        bookGenreTextField.setBounds(150, 185, 350, 30);
        container.add(bookGenreTextField);

        authorNameLabel = new JLabel("Author's Name : ");
        authorNameLabel.setBounds(20, 200, 1000, 100);
        container.add(authorNameLabel);

        authorNameTextField = new JTextField();
        authorNameTextField.setBounds(150, 235, 350, 30);
        container.add(authorNameTextField);

        costPriceLabel = new JLabel("Cost Price : ");
        costPriceLabel.setBounds(20, 250, 1000, 100);
        container.add(costPriceLabel);

        costPriceTextField = new JTextField();
        costPriceTextField.setBounds(150, 285, 350, 30);
        container.add(costPriceTextField);

        sellingPriceLabel = new JLabel("Selling Price : ");
        sellingPriceLabel.setBounds(20, 300, 1000, 100);
        container.add(sellingPriceLabel);

        sellingPriceTextField = new JTextField();
        sellingPriceTextField.setBounds(150, 335, 350, 30);
        container.add(sellingPriceTextField);


        idLabel = new JLabel("Book ID : ");
        idLabel.setBounds(20, 350, 1000, 100);
        container.add(idLabel);
        id = id.substring(0, 8);

        idValueJlabel = new JLabel(id);
        idValueJlabel.setBounds(150, 385, 350, 30);
        container.add(idValueJlabel);

        bookDescriptionLabel = new JLabel("Book Description : ");
        bookDescriptionLabel.setBounds(20, 450, 1000, 100);
        container.add(bookDescriptionLabel);

        bookDescriptionTextArea = new JTextArea();
        bookDescriptionTextArea.setLineWrap(true); // Enable word wrap
        bookDescriptionTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        scrollPane = new JScrollPane(bookDescriptionTextArea);
        scrollPane.setBounds(150, 485, 300, 100); // Adjust as needed
        container.add(scrollPane);

        addToInventoryButton = new JButton("Add Item To Inventory");
        addToInventoryButton.setBounds(150, 600, 200, 30);
        addToInventoryButton.setFocusable(false);
        addToInventoryButton.addActionListener(this);
        addToInventoryButton.setFont(new Font("Arial", Font.ITALIC, 14));
        // addToInventoryButton.setIcon(new ImageIcon("F:\\projects\\"));
        container.add(addToInventoryButton);


        goToHomePageButton = new JButton("Back"); // Create a new button
        goToHomePageButton.setBounds(360, 600, 100, 30); // Adjust position and size
        goToHomePageButton.setFocusable(false);
        goToHomePageButton.addActionListener(this); // Add action listener
        container.add(goToHomePageButton); // Add button to the container


        browseButton = new JButton("Browse Image"); // Create a new button
        browseButton.setBounds(700, 600, 150, 30); // Adjust position and size
        browseButton.setFocusable(false);
        browseButton.addActionListener(this); // Add action listener
        container.add(browseButton); // Add button to the container


        setSize(1120, 700);
        setLocation(250, 100);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == addToInventoryButton) {

            String title = bookTitleTextField.getText();
            String genre = bookGenreTextField.getText();
            String author = authorNameTextField.getText();
            String numberOfPages = numberOfPagesTextField.getText();
            String bookDescription = bookDescriptionTextArea.getText();


            if (!(verityTypeISNumber(numberOfPages))) {
                JOptionPane.showMessageDialog(null, "Enter a number value for number of pages!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("not number block number of pages");
                return;
            }

            String costPrice = costPriceTextField.getText();

            if (!(verityTypeISNumber(costPrice))) {
                JOptionPane.showMessageDialog(null, "Enter a number value for cost price!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("not number block cost price");
                return;
            }

            String sellingPrice = sellingPriceTextField.getText();

            if (!(verityTypeISNumber(sellingPrice))) {
                JOptionPane.showMessageDialog(null, "Enter a number value for selling price!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("not number block cost price");
                return;
            }


//            if (!(id.matches("\\d*"))) {
//                JOptionPane.showMessageDialog(null, "Enter a unique integer number value for ID!", "Error",
//                JOptionPane.ERROR_MESSAGE);
//                System.out.println("not number block ID");
//                return;
//            }

            if ((title.isBlank() || numberOfPages.isBlank() || genre.isBlank() ||
                    author.isBlank() || costPrice.isBlank() || sellingPrice.isBlank()
                    || id.isBlank() || bookDescription.isBlank())) {
                JOptionPane.showMessageDialog(null,
                        "Please make sure none of the input fields is empty!", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (PreparedStatement statement = databaseConnection.prepareStatement("SELECT * FROM inventory WHERE id = ?")) {
                statement.setString(1, id); // Set the value of the parameter
                ResultSet rs = statement.executeQuery();

                // Iterate through the result set
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null,
                            "The entered ID already exists. Please enter a unique ID.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }

            System.out.println("title " + title);
            System.out.println("number of pages " + numberOfPages);
            System.out.println("genre " + genre);
            System.out.println("author " + author);
            System.out.println("cost price " + costPrice);
            System.out.println("sellingPrice " + sellingPrice);
            System.out.println("ID " + id);
            System.out.println("description " + bookDescription);
            System.out.println("imageLength " + imageData.length);


            String insertQuery = "INSERT into inventory (id, numberOfPages, title, genre, authorName, costPrice," +
                    " sellingPrice, description,coverPageIcon)" +
                    " values (?, ?, ?, ?, ?, ?, ?, ?,?)";

//            if (imageData == null) {
//                JOptionPane.showMessageDialog(null, "Please select an image.", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
            try (Connection databaseConnection = databaseHandler.getDatabaseConnection();
                 PreparedStatement preparedStatement = databaseConnection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, id); // Assuming 'id' is auto-incremented
                preparedStatement.setInt(2, Integer.parseInt(numberOfPages));
                preparedStatement.setString(3, title);
                preparedStatement.setString(4, genre);
                preparedStatement.setString(5, author);
                preparedStatement.setDouble(6, Float.parseFloat(costPrice));
                preparedStatement.setDouble(7, Float.parseFloat(sellingPrice));
                preparedStatement.setString(8, bookDescription);
                preparedStatement.setBytes(9, imageData);

                preparedStatement.executeUpdate();

                //-----------------------------------------------------------


                Statement statement = databaseConnection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM store");
                while (resultSet.next()) {
                    this.moneySpent = resultSet.getDouble("moneySpent");

                }

                String updateQuery = "UPDATE store SET moneySpent = ?";
                PreparedStatement updateStatement = databaseConnection.prepareStatement(updateQuery);
                this.moneySpent += Double.parseDouble(costPrice);// update money Spent
                updateStatement.setDouble(1, this.moneySpent);
                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("MoneyMade updated successfully.");
                } else {
                    System.out.println("No records updated.");
                }


                //========================================================

                // add to money Spent hear
                System.out.println("data inserted from GUI .");
            } catch (SQLException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                dispose();
                new AddItem();
            }


        }


        if (actionEvent.getSource() == browseButton) {
            JFileChooser fileChooser = new JFileChooser(); // Create a file chooser
            int result = fileChooser.showOpenDialog(this); // Show the file chooser dialog

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile(); // Get the selected file

                try {
                    FileInputStream fis = new FileInputStream(selectedFile); // Create FileInputStream
                    imageData = new byte[(int) selectedFile.length()]; // Create byte array for image data
                    fis.read(imageData); // Read image data into the byte array
                    fis.close(); // Close FileInputStream
                    bookCover = ImageIO.read(new ByteArrayInputStream(imageData));
                    bookCover = bookCover.getScaledInstance(100, 200, Image.SCALE_SMOOTH);

                    // If the bookCoverImageLabel already exists, update its icon
                    if (bookCoverImageLabel != null) {
                        bookCoverImageLabel.setIcon(new ImageIcon(bookCover));
                    } else { // Otherwise, create a new bookCoverImageLabel and add it to the container
                        bookCoverImageLabel = new JLabel(new ImageIcon(bookCover));
                        bookCoverImageLabel.setBounds(725, 385, 100, 200);
                        container.add(bookCoverImageLabel);
                    }

                    // Call revalidate and repaint to update the container
                    container.revalidate();
                    container.repaint();

                    // Do something with the image data (e.g., store it in a database)
                    System.out.println("Image data read successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (actionEvent.getSource() == goToHomePageButton) {
            dispose();
            SwingUtilities.invokeLater(() -> new HomePage("SELECT * FROM inventory"));
        }


    }

    public boolean verityTypeISNumber(String text) {
        return text.matches("\\d*\\.?\\d*");
    }

    //public static void main(String[] args) {
        //SwingUtilities.invokeLater(AddItem::new);
    //}
}


//
//JTextField costPriceTextField = new JTextField();
//        costPriceTextField.setBounds(150, 285, 350, 30);
//        container.add(costPriceTextField);
//        costPriceTextField.setInputVerifier(new InputVerifier() {
//    @Override
//    public boolean verify(JComponent input) {
//        JTextField tf = (JTextField) input;
//        String text = tf.getText();
//        try {
//            float num = Float.parseFloat(text);
//            // Input is a float
//            return true;
//        } catch (NumberFormatException e) {
//            // Input is not a float
//            return false;
//        }
//    }
//});


//JTextField textField = new JTextField();
//AbstractDocument document = (AbstractDocument) textField.getDocument();
//document.setDocumentFilter(new DocumentFilter() {
//    @Override
//    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
//        // Check if the input is numeric
//        if (text.matches("\\d*")) {
//            super.replace(fb, offset, length, text, attrs);
//        }
//    }
//});


//
//
//
//JTextField textField = new JTextField();
//textField.setInputVerifier(new InputVerifier() {
//    @Override
//    public boolean verify(JComponent input) {
//        JTextField textField = (JTextField) input;
//        String text = textField.getText();
//        // Check if the input is numeric
//        return text.matches("\\d*");
//    }
//});
//
