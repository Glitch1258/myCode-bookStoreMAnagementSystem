import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddItem extends JFrame implements ActionListener {
    JButton view, add, update, remove;

    AddItem() {
        setLayout(null);

        JLabel container = new JLabel() {
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

        JLabel heading = new JLabel("Add Book");
        heading.setBounds(20, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        container.add(heading);

        JLabel bookTitleLabel = new JLabel("Book Title : ");
        bookTitleLabel.setBounds(20,50,1000,100);
        container.add(bookTitleLabel);

        JTextField bookTitleTextField = new JTextField();
        bookTitleTextField.setBounds(150, 85, 350, 30);
        container.add(bookTitleTextField);

        JLabel numberOfPagesLabel = new JLabel("Number of pages : ");
        numberOfPagesLabel.setBounds(20,100,1000,100);
        container.add(numberOfPagesLabel);

        JTextField numberOfPagesTextField = new JTextField();
        numberOfPagesTextField.setBounds(150, 135, 350, 30);
        container.add(numberOfPagesTextField);

        JLabel bookGenreLabel = new JLabel("Book Genre : ");
        bookGenreLabel.setBounds(20,150,1000,100);
        container.add(bookGenreLabel);

        JTextField bookGenreTextField = new JTextField();
        bookGenreTextField.setBounds(150, 185, 350, 30);
        container.add(bookGenreTextField);

        JLabel authorNameLabel = new JLabel("Author's Name : ");
        authorNameLabel.setBounds(20,200,1000,100);
        container.add(authorNameLabel);

        JTextField authorNameTextField = new JTextField();
        authorNameTextField.setBounds(150, 235, 350, 30);
        container.add(authorNameTextField);

        JLabel costPriceLabel = new JLabel("Cost Price : ");
        costPriceLabel.setBounds(20,250,1000,100);
        container.add(costPriceLabel);

        JTextField costPriceTextField = new JTextField();
        costPriceTextField.setBounds(150, 285, 350, 30);
        container.add(costPriceTextField);

        JLabel sellingPriceLabel = new JLabel("Selling Price : ");
        sellingPriceLabel.setBounds(20,300,1000,100);
        container.add(sellingPriceLabel);

        JTextField sellingPriceTextField = new JTextField();
        sellingPriceTextField.setBounds(150, 335, 350, 30);
        container.add(sellingPriceTextField);

        JLabel bookDescriptionLabel = new JLabel("Book Description : ");
        bookDescriptionLabel.setBounds(20,350,1000,100);
        container.add(bookDescriptionLabel);

        JTextArea bookDescriptionTextArea = new JTextArea();
        bookDescriptionTextArea.setLineWrap(true); // Enable word wrap
        bookDescriptionTextArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane scrollPane = new JScrollPane(bookDescriptionTextArea);
        scrollPane.setBounds(150, 385, 300, 100); // Adjust as needed
        container.add(scrollPane);

        JButton addToInventoryButton = new JButton("Add Item To Inventory");
        addToInventoryButton.setBounds(150, 500, 200, 30);
        addToInventoryButton.setFocusable(false);
        addToInventoryButton.addActionListener(this);
        addToInventoryButton.setFont(new Font("Arial", Font.ITALIC, 14));
       // addToInventoryButton.setIcon(new ImageIcon("F:\\projects\\"));

        container.add(addToInventoryButton);

        setSize(1120, 630);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getActionCommand().equals("Add Item To Inventory")) {
            System.out.println("Button clicked!");
        }
    }

    public static void main(String[] args) {
        new AddItem();
    }
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
