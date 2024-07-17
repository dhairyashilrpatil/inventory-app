import java.sql.*;

public class inventaryDB {


    private static final String url="jdbc:mysql://127.0.0.1:3306/inventory";
     
    private static final String username="root";

    private static final String password="Drpatil@96";


    public static void main(String[] args) {
       try{
        Class.forName("com.mysql.cj.jdbc.Driver");
       }
       catch(ClassNotFoundException e)
       {
        System.out.println(e.getMessage());
       }


       try{
        Connection connection= DriverManager.getConnection(url, username, password);

        Statement statement=connection.createStatement();

        String query1="select * from product";

        ResultSet resultSet=statement.executeQuery(query1);


        while (resultSet.next()) 
        {
            // we have to print the values in the database 
            // so we can get the values from the mysql that values we have to store in local variable
            // so, create variable for the id,name,price 

            int productId,price;
            String name;

            productId =resultSet.getInt("productId");
            name=resultSet.getString("name");
            price=resultSet.getInt("price");


            System.out.println("id:  "+productId);
            System.out.println("name:  "+name);
            System.out.println("price:  "+price);

            }

            connection.close();


      

        



       }
       catch(SQLException S)
       {
        System.out.println(S.getMessage());
       }











    }
    
}
