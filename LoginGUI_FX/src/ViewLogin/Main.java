package ViewLogin;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/ViewLogin/Login.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setHeight(570);
			primaryStage.setWidth(850);
			primaryStage.setResizable(true);
			primaryStage.show();
      System.out.println();
			//LoginController.LoginButton.setOnAction(e -> Window.setScene(scene));
			System.out.println("Tuan check commit");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void connectToDB() {
		Connection connection = null;
        try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:shoppingCartDb.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          String personTableQueryString = "create table if not exists personTable ("
          								+ "firstName string,"
          								+ "lastName string, userName string primary key,"
          								+ "email string, password string)";
          statement.executeUpdate(personTableQueryString);
          
          Statement statementBookTable = connection.createStatement();
          String bookTableQuery = "create table if not exists bookTable ("
        		  					+ "isbn int,"
        		  					+ "book string,"
        		  					+ "author string,"
        		  					+ "edition int,"
        		  					+ "year int,"
        		  					+ "price float)";
          statementBookTable.executeUpdate(bookTableQuery);
//          statementBookTable.executeUpdate("insert into bookTable values(33, 'Software Engineering','Robert ',1,2016,25.50)");
//          statementBookTable.executeUpdate("insert into bookTable values(44, 'Data Prediction','Carter',1,2017,40)");
        
          Statement statementCartTable = connection.createStatement();
          String cartTableQuery = "create table if not exists bookTable ("
        		  					+ "username string,"
        		  					+ "isbn int,"
        		  					+ "book string,"
        		  					+ "author string,"
        		  					+ "edition int,"
        		  					+ "year int,"
        		  					+ "price float)";
          statementCartTable.executeUpdate(cartTableQuery);
          
          Statement statementPaymentTable = connection.createStatement();
          String paymentTableQuery = "create table if not exists paymentTable ("
        		  					+ "username"
        		  					+ "paymentType,"
        		  					+ "creditNumber,"
        		  					+ "expireDate,"
        		  					+ "firstname,"
        		  					+ "lastname,"
        		  					+ "billingAddress1,"
        		  					+ "billingAddress2,"
        		  					+ "city,"
        		  					+ "state,"
        		  					+ "zipcode,"
        		  					+ "phone)";
          statementPaymentTable.executeUpdate(paymentTableQuery);
        		  				
//          statement.executeUpdate("insert into personTable values(1, 'leo','le','leo123','leo123@gmail.com','leole')");
//          statement.executeUpdate("insert into personTable values(2, 'yui','yu','yu123','yu123@gmail.com','yuiyu')");
//          ResultSet rs = statement.executeQuery("select * from personTable");
//          while(rs.next())
//          {
//            // read the result set
//            System.out.println("name = " + rs.getString("firstName"));
//            System.out.println("personId = " + rs.getInt("personId"));
//          }
          
        }
        catch(SQLException e)
        {
          // if the error message is "out of memory",
          // it probably means no database file is found
          System.err.println(e.getMessage());
        }
        finally
        {
          try
          {
            if(connection != null)
              connection.close();
          }
          catch(SQLException e)
          {
            // connection close failed.
            System.err.println(e);
          }
        }
	}
	
	public static void main(String[] args) {
		
		connectToDB();
		launch(args);
	}
}
