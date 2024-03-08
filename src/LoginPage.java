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
                JOptionPane.showMessageDialog(null, "One or both of the input fields is blank!", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try (Connection connection = databaseHandler.getDatabaseConnection();
                 Statement statement = connection.createStatement();) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM admins WHERE userName='" + userName + "' AND password = '" + passWord + "'");
                while (resultSet.next()) {
                    System.out.println("login successful");
                    dispose();
                    //new HomePage(); //not yet created
                    return;

                }
                JOptionPane.showMessageDialog(null, "Login failed!",
                        "Error", JOptionPane.ERROR_MESSAGE);
                dispose();
                new LoginPage();

            } catch (SQLException exception) {
                System.out.print("Could not log in: ");
                exception.printStackTrace();

            }


        }


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginPage::new);
    }
}


