import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class mainPage {

    public static void main(String[] args) {
        // Create the main frame and set it to full screen
        JFrame mainFrame = new JFrame("User Selection");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        mainFrame.setLayout(new GridLayout(1, 2)); // 1 row, 2 columns

       
        

        // Create buttons with images
        JButton employeeButton = new  JButton("employee",new ImageIcon("D:\\dhairyashil\\inventory\\inventory\\images\\employee.png"));
        JButton ownerButton = new JButton("OWNER",new ImageIcon("D:\\dhairyashil\\inventory\\inventory\\images\\owner.png"));

        employeeButton.addActionListener(this);
        ownerButton.addActionListener(this);

        // Remove the borders around the buttons
        //employeeButton.setBorderPainted(false);
        employeeButton.setContentAreaFilled(false); // Remove background
        employeeButton.setFocusPainted(false);      // Remove focus border

        //ownerButton.setBorderPainted(false);
        ownerButton.setContentAreaFilled(false);    // Remove background
        ownerButton.setFocusPainted(false);         // Remove focus border

        // Set the buttons to have larger text and ensure both are uniform
        employeeButton.setFont(new Font("Arial", Font.BOLD, 20));
        ownerButton.setFont(new Font("Arial", Font.BOLD, 20));

        // Add buttons to the main frame
        mainFrame.add(employeeButton);
        mainFrame.add(ownerButton);

        // Action Listener for Employee Button
        employeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginpage1 l1=new loginpage1();
            }
        });

        // Action Listener for Owner Button
        ownerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginpage2 l1=new loginpage2();
            }
        });

       
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==employeeButton)
        {
            mainFrame.setVisible(false);
            loginpage1 l1=new loginpage1();
        }
        else if(e.getSource()==jb1)
        {
            jf.setVisible(false);
            loginpage2 l2=new loginpage2();
            

        }
    }

    public void setVisible(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setVisible'");
    }


}
