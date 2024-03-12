import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class LoginPage extends JFrame implements ActionListener {
    DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");


    JLabel container, heading, userNameLabel, passwordLabel;
    JTextField userNameTextField, passwordTextField;

    JButton logInButton;


    LoginPage() {
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
        container.setBounds(0, 0, 1000, 400);
        container.setBackground(Color.darkGray);
        add(container);

        heading = new JLabel("Login");
        heading.setBounds(20, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        container.add(heading);


        userNameLabel = new JLabel("User Name : ");
        userNameLabel.setBounds(20, 50, 1000, 100);
        container.add(userNameLabel);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(150, 85, 350, 30);
        container.add(userNameTextField);

        passwordLabel = new JLabel("Password : ");
        passwordLabel.setBounds(20, 100, 1000, 100);
        container.add(passwordLabel);

        passwordTextField = new JTextField();
        passwordTextField.setBounds(150, 135, 350, 30);
        container.add(passwordTextField);


        logInButton = new JButton("log in");
        logInButton.setBounds(150, 250, 200, 30);
        logInButton.setFocusable(false);
        logInButton.addActionListener(this);
        logInButton.setFont(new Font("Arial", Font.ITALIC, 14));
        // addToInventoryButton.setIcon(new ImageIcon("F:\\projects\\"));
        container.add(logInButton);

        //------------------------------------------------------------------------------------------

        JLabel label1 = new JLabel("allowed userName 1 :");
        label1.setBounds(620, 180, 200, 30);
        container.add(label1);

        JLabel label2 = new JLabel("sakib");
        label2.setBounds(620, 215, 200, 30);
        container.add(label2);

        JLabel label3 = new JLabel("allowed password 1");
        label3.setBounds(620, 250, 200, 30);
        container.add(label3);

        JLabel label4 = new JLabel("12345");
        label4.setBounds(620, 285, 200, 30);
        container.add(label4);

        JLabel label5 = new JLabel("allowed user name 2");
        label5.setBounds(850, 180, 200, 30);
        container.add(label5);

        JLabel label6 = new JLabel("sakib2");
        label6.setBounds(850, 215, 200, 30);
        container.add(label6);

        JLabel label7 = new JLabel("allowed Password 2");
        label7.setBounds(850, 250, 200, 30);
        container.add(label7);

        JLabel label8 = new JLabel("123456");
        label8.setBounds(850, 285, 200, 30);
        container.add(label8);// labels in case  i forget username and password
        //------------------------------------------------------------------------------------------


        setSize(1000, 400);
        setLocation(250, 100);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource() == logInButton) {
            String userName = userNameTextField.getText();
            String passWord = passwordTextField.getText();
            if (userName.isBlank() || passWord.isBlank()) {
                JOptionPane.showMessageDialog(null, "One or both of the input fields is blank!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            try (Connection connection = databaseHandler.getDatabaseConnection();
                 Statement statement = connection.createStatement();) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM admins WHERE userName='" + userName +
                        "' AND password = '" + passWord + "'");
                while (resultSet.next()) {
                    System.out.println("login successful");
                    dispose();
                    SwingUtilities.invokeLater(() -> new HomePage("SELECT * FROM inventory"));
                    return;

                }
                JOptionPane.showMessageDialog(null, "Login failed!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                dispose();
                SwingUtilities.invokeLater(LoginPage::new);

            } catch (SQLException exception) {
                System.out.print("Could not log in: ");
                exception.printStackTrace();

            }


        }


    }


//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(LoginPage::new);
//    }
}


