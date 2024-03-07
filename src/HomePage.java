import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class HomePage extends JFrame implements ActionListener {
    DatabaseHandler databaseHandler = new DatabaseHandler("bookStore");


    JLabel container, heading, moneySpentLabel, moneyMadeLabel , neIncomeLabel;
    JTextField userNameTextField, passwordTextField;

    JButton logInButton;


    HomePage() {
        setLayout(null);

        container = new JLabel() {
            // Override paintComponent to set background color
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.lightGray);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        container.setBounds(0, 0, 1000, 1000);
        container.setBackground(Color.darkGray);
        add(container);

        heading = new JLabel("Home");
        heading.setBounds(20, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        container.add(heading);


        moneySpentLabel = new JLabel("User Name : ");
        moneySpentLabel.setBounds(20, 50, 1000, 100);
        container.add(moneySpentLabel);

        userNameTextField = new JTextField();
        userNameTextField.setBounds(150, 85, 350, 30);
        container.add(userNameTextField);

        moneyMadeLabel = new JLabel("Password : ");
        moneyMadeLabel.setBounds(20, 100, 1000, 100);
        container.add(moneyMadeLabel);

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


        setSize(1000, 1000);
        setLocation(250, 0);
        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent actionEvent) {



    }

    public static void main(String[] args) {
        new HomePage();
    }
}
