import java.sql.*;

public class InventoryDB {

    private static final String url = "jdbc:mysql://localhost:3306/inventory1";
    private static final String username = "root";
    private static final String password = "Drpatil@96";

    public static void main(String[] args) {
        // Load the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
            return; // Exit if driver not found
        }

        // Establish connection and retrieve data
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM products";
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the ResultSet and print values
            while (resultSet.next()) {
                int productId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double salePrice = resultSet.getDouble("price"); // Use double if price is a decimal

                System.out.println("ID: " + productId);
                System.out.println("Name: " + name);
                System.out.println("Price: " + salePrice);
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
}
