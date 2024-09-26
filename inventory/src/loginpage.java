import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Class for the main frame where the user chooses Employee or Owner
class myframe implements ActionListener {
    JFrame mainFrame;
    JButton employeeButton, ownerButton; // Class-level buttons

    public myframe(String s) {
        mainFrame = new JFrame(s);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        mainFrame.setLayout(new GridLayout(1, 2)); // 1 row, 2 columns

        // Initialize buttons with images
        employeeButton = new JButton("EMPLOYEE", new ImageIcon("D:\\dhairyashil\\inventory\\inventory\\images\\employee.png"));
        ownerButton = new JButton("OWNER", new ImageIcon("D:\\dhairyashil\\inventory\\inventory\\images\\owner.png"));

        // Set button appearance
        employeeButton.setContentAreaFilled(false);
        employeeButton.setFocusPainted(false);
        ownerButton.setContentAreaFilled(false);
        ownerButton.setFocusPainted(false);

        // Set font for both buttons
        employeeButton.setFont(new Font("Arial", Font.BOLD, 20));
        ownerButton.setFont(new Font("Arial", Font.BOLD, 20));

        // Add buttons to the main frame
        mainFrame.add(employeeButton);
        mainFrame.add(ownerButton);

        // Add action listeners for buttons
        employeeButton.addActionListener(this);
        ownerButton.addActionListener(this);

        // Set frame visibility
        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == employeeButton) {
            mainFrame.setVisible(false);
            // Assuming loginpage2 is a valid class handling the Employee login
            loginpage2 l1 = new loginpage2(); 
        } else if (e.getSource() == ownerButton) {
            mainFrame.setVisible(false);
            // Assuming loginpage1 is a valid class handling the Owner login
            loginpage1 l2 = new loginpage1();
        }
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }
}

// Main class to launch the login page
public class loginpage {
    public static void main(String[] args) {
        myframe mf = new myframe("LOGIN PAGE");
    }

    // Set visibility method if needed
    public void setVisible(boolean b) {
        // Method can be implemented depending on requirements
        // JFrame.setVisible(b) could be used if necessary
    }
}
