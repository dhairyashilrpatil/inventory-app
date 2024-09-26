import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class BillingSystem {

    private int billNumber = 1; // Starts with bill number 1
    private final String DB_URL = "jdbc:mysql://localhost:3306/inventory1";
    private final String DB_USER = "root";
    private final String DB_PASSWORD = "Drpatil@96";

    private DefaultTableModel tableModel;
    private JTextField productIdField, quantityField;
    private JLabel totalAmountLabel;
    private double totalAmount = 0.0;
    private ArrayList<Product> addedProducts = new ArrayList<>();

    public BillingSystem() {
        initBillingSystem(); // Initialize the billing system when an object is created
    }

    // Initialize the billing system UI and functionality
    public void initBillingSystem() {
        // Set up the main frame
        JFrame mainFrame = new JFrame("Billing System");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        mainFrame.setLayout(new BorderLayout());

        // Left side: JTable for products
        String[] columns = {"Product ID", "Name", "Quantity", "Price", "Total Price"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable productTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(productTable);

        // Right side: Product selection and actions
        JPanel rightPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        JLabel selectProductLabel = new JLabel("Enter Product ID:");
        productIdField = new JTextField();

        JLabel quantityLabel = new JLabel("Enter Quantity:");
        quantityField = new JTextField();
        
        JButton saveBillButton = new JButton("Save Bill to CSV");

        rightPanel.add(selectProductLabel);
        rightPanel.add(productIdField);
        rightPanel.add(quantityLabel);
        rightPanel.add(quantityField);
        rightPanel.add(saveBillButton);

        mainFrame.add(tableScrollPane, BorderLayout.CENTER);
        mainFrame.add(rightPanel, BorderLayout.EAST);

        // Bottom Panel: Total Amount Label
        JPanel bottomPanel = new JPanel();
        totalAmountLabel = new JLabel("Total Amount: $0.00");
        totalAmountLabel.setFont(new Font("Arial", Font.BOLD, 16));
        bottomPanel.add(totalAmountLabel);
        mainFrame.add(bottomPanel, BorderLayout.SOUTH);

        // Action listener for Save Bill Button
        saveBillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveBillToCSV();
                resetBill(); // Reset after saving
            }
        });

        // Key listener for productIdField and quantityField
        productIdField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    quantityField.requestFocus();
                }
            }
        });

        quantityField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    addProduct();
                    productIdField.requestFocus();
                    productIdField.setText("");
                    quantityField.setText("");
                } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    removeLastProduct();
                }
            }
        });

        // Set focus on Product ID field when the frame is visible
        mainFrame.addWindowFocusListener(new java.awt.event.WindowAdapter() {
            public void windowGainedFocus(java.awt.event.WindowEvent e) {
                productIdField.requestFocus();
            }
        });

        // Set frame visible
        mainFrame.setVisible(true);
    }

    // Method to add product to table based on Product ID and update database
    private void addProduct() {
        String productIdStr = productIdField.getText();
        String quantityStr = quantityField.getText();
        if (!productIdStr.isEmpty() && !quantityStr.isEmpty()) {
            try {
                int productId = Integer.parseInt(productIdStr);
                int quantity = Integer.parseInt(quantityStr);
                addProductToTable(productId, quantity);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter valid numbers for Product ID and Quantity.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product ID and Quantity cannot be empty.");
        }
    }

    private void addProductToTable(int productId, int billQuantity) {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM products WHERE id = ?")) {

            selectStmt.setInt(1, productId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int availableQuantity = rs.getInt("quantity");
                double price = rs.getDouble("price");

                if (availableQuantity >= billQuantity) {
                    double totalPrice = billQuantity * price;
                    tableModel.addRow(new Object[]{id, name, billQuantity, price, totalPrice});
                    totalAmount += totalPrice;
                    updateTotalAmountLabel();
                    addedProducts.add(new Product(id, name, billQuantity));
                    updateProductQuantityInDatabase(id, availableQuantity, billQuantity);
                } else {
                    JOptionPane.showMessageDialog(null, "Insufficient stock! Only " + availableQuantity + " units available.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product not found!");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void updateProductQuantityInDatabase(int productId, int availableQuantity, int quantitySold) {
        int newQuantity = availableQuantity - quantitySold;
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement updateStmt = conn.prepareStatement("UPDATE products SET quantity = ? WHERE id = ?")) {
            updateStmt.setInt(1, newQuantity);
            updateStmt.setInt(2, productId);
            updateStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void removeLastProduct() {
        if (tableModel.getRowCount() > 0) {
            int lastRow = tableModel.getRowCount() - 1;
            double lastTotalPrice = (double) tableModel.getValueAt(lastRow, 4);
            totalAmount -= lastTotalPrice;
            updateTotalAmountLabel();
            tableModel.removeRow(lastRow);
            addedProducts.remove(addedProducts.size() - 1);
        } else {
            JOptionPane.showMessageDialog(null, "No products to remove!");
        }
    }

    private void updateTotalAmountLabel() {
        totalAmountLabel.setText(String.format("Total Amount: $%.2f", totalAmount));
    }

    private void saveBillToCSV() {
        String filePath = getNextBillFilePath();
        try (FileWriter csvWriter = new FileWriter(filePath)) {
            csvWriter.append("Product ID,Name,Quantity,Price,Total Price\n");
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                for (int j = 0; j < tableModel.getColumnCount(); j++) {
                    csvWriter.append(tableModel.getValueAt(i, j).toString());
                    if (j < tableModel.getColumnCount() - 1) {
                        csvWriter.append(",");
                    }
                }
                csvWriter.append("\n");
            }
            csvWriter.append(",,,,\n"); // Blank line before total
            csvWriter.append(String.format(",,,Total Amount,$%.2f\n", totalAmount));
            JOptionPane.showMessageDialog(null, "Bill saved successfully to " + filePath);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getNextBillFilePath() {
        String fileName = "bill" + billNumber + ".csv";
        billNumber++;
        return fileName;
    }

    private void resetBill() {
        tableModel.setRowCount(0);
        totalAmount = 0.0;
        updateTotalAmountLabel();
        addedProducts.clear();
    }
}

// Helper class to store product information
class Product {
    int id;
    String name;
    int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
