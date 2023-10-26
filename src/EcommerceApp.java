


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EcommerceApp
{

	   private static Connection connection;
	    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/e-commerceapp";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "9765284928";

	public static void main(String[]args) 

	{
		
		 connectToDatabase();
	        Scanner scanner = new Scanner(System.in);

	        while (true)
	        {
	                                                          // Display menu options
	        System.out.println("E-Commerce Application Menu:");
	        System.out.println("1. User Registration");
	        System.out.println("2. User Login");
	        System.out.println("3. View Product Items");
	        System.out.println("4. Buy Product");	           
	                                                  // Add more options for admin and guest functionalities

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline
	            switch (choice) 
	            {
                case 1:
                	
                	   private static void userRegistration() 
                	   {
                	        Scanner scanner = new Scanner(System.in);
                	        System.out.print("Enter the user_id: ");
                	        int user_id = scanner.nextInt();                	        
                	        System.out.print("Enter the first name: ");
                	        String first_name = scanner.nextLine();
                	        System.out.print("Enter the last name: ");
                	        String last_name = scanner.nextLine();
                	        System.out.print("Enter the username: ");
                	        String username = scanner.nextLine();
                	        System.out.print("Enter the password: ");
                	        String password = scanner.nextLine();
                	        System.out.print("Enter the city: ");
                	        String city = scanner.nextLine();
                	        System.out.print("Enter the email: ");
                	        String email = scanner.nextLine();
                	        System.out.print("Enter the mobile number: ");
                	        long mobile_number = scanner.nextLong();
                	   
                	        // Implement code to insert user details into the database
                	        try 
                	        {
                	            String insertQuery = "INSERT INTO users (user_id,first_name, last_name, username, password, city, email, mobile_number) VALUES (?, ?, ?, ?, ?, ?, ?,?)";
                	            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
                	            preparedStatement.setInt(1, user_id);
                	            preparedStatement.setString(2, first_name);
                	            preparedStatement.setString(3, last_name);
                	            preparedStatement.setString(4, username);
                	            preparedStatement.setString(5, password);
                	            preparedStatement.setString(6, city);
                	            preparedStatement.setString(7, email);
                	            preparedStatement.setLong(8, mobile_number);
                	            int rowsInserted = preparedStatement.executeUpdate();
                	            if (rowsInserted > 0) 
                	            {
                	                System.out.println("User registered successfully.");
                	            } else 
                	            {
                	                System.out.println("User registration failed.");
                	            }
                	        } catch (SQLException e) 
                	        {
                	            e.printStackTrace();
                	        }
                	       	
                break ;
                	   
                case 2:
                    // Implement user login
                	 private static void userLogin() 
                	 {
                	        Scanner scanner = new Scanner(System.in);
                	        System.out.print("Enter the username: ");
                	        String username = scanner.nextLine();
                	        System.out.print("Enter the password: ");
                	        String password = scanner.nextLine();

                	        // Implement code to check user credentials in the database
                	        try 
                	        {
                	            String selectQuery = "SELECT * FROM e-commerceapp WHERE username = root AND password = 9765284928";
                	            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                	            preparedStatement.setString(1, username);
                	            preparedStatement.setString(2, password);
                	            ResultSet resultSet = preparedStatement.executeQuery();

                	            if (resultSet.next()) 
                	            {
                	                System.out.println("Login successful.");
                	            }
                	            else 
                	            {
                	                System.out.println("Login failed. Invalid username or password.");
                	            }
                	        } 
                	        catch (SQLException e) 
                	        {
                	            e.printStackTrace();
                	        }
                	 
                    break ;
                case 3:
                    // Implement viewing product items
                	  private static void viewProductItems() 
                	  {
                	        // Implement code to fetch and display product items from the database
                	        try {
                	            String selectQuery = "SELECT * FROM products";
                	            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
                	            ResultSet resultSet = preparedStatement.executeQuery();

                	            System.out.println("Product List:");
                	            while (resultSet.next()) {
                	                int productId = resultSet.getInt("product_id");
                	                String productName = resultSet.getString("name");
                	                String productDescription = resultSet.getString("product_description");
                	                int availableQuantity = resultSet.getInt("quantity");
                	                double price = resultSet.getDouble("price");

                	                System.out.println("Product ID: " + productId);
                	                System.out.println("Name: " + productName);
                	                System.out.println("Description: " + productDescription);
                	                System.out.println("Available Quantity: " + availableQuantity);
                	                System.out.println("Price: $" + price);
                	                System.out.println("-------------------");
                	            }
                	        } catch (SQLException e) 
                	        {
                	            e.printStackTrace();
                	        }
                	    

                    break;
                case 4:
                    // Implement buying a product
                	
                    private static void buyProduct() 

                    {
                        Scanner scanner = new Scanner(System.in);
                        System.out.print("Enter the product ID to buy: ");
                        int productId = scanner.nextInt();
                        System.out.print("Enter the quantity: ");
                        int quantity = scanner.nextInt();

                        // Implement code to update product quantity and calculate the bill
                        try {
                            String selectQuery = "SELECT * FROM products WHERE product_id = ?";
                            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
                            selectStatement.setInt(1, productId);
                            ResultSet resultSet = selectStatement.executeQuery();

                            if (resultSet.next()) {
                                int availableQuantity = resultSet.getInt("available_quantity");
                                double price = resultSet.getDouble("price");

                                if (availableQuantity >= quantity) {
                                    double totalAmount = price * quantity;

                                    // Implement code to update the product quantity in the database

                                    System.out.println("Product purchased successfully.");
                                    System.out.println("Total Amount: $" + totalAmount);
                                } else {
                                    System.out.println("Not enough quantity available.");
                                }
                            } else {
                                System.out.println("Product not found.");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                	  	  
               //   public static void main(String[] args) 
                    {

                        connectToDatabase();
                        Scanner scanner = new Scanner(System.in);

                        while (true) {
                            System.out.println("E-Commerce Application Menu:");
                            System.out.println("1. User Registration");
                            System.out.println("2. User Login");
                            System.out.println("3. View Product Items");
                            System.out.println("4. Buy Product");
                            System.out.println("5. Exit");

                            System.out.print("Enter your choice: ");
                            int choice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline

                            switch (choice) {
                                case 1:
                                    userRegistration();
                                    break;
                                case 2:
                                    userLogin();
                                    break;
                                case 3:
                                    viewProductItems();
                                    break;
                                case 4:
                                    buyProduct();
                                    break;
                                case 5:
                                    System.out.println("Goodbye!");
                                    System.exit(0);
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                                    break;
                            }
                        }
                 //  }
                }
	            private static void connectToDatabase() {

	                try {
	                    connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	                    System.out.println("Connected to the database.");
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
}
    }
