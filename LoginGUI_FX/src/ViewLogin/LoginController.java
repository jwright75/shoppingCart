package ViewLogin;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {
	    
	    @FXML private TextField userField ;

	    @FXML private PasswordField passField ;

	    @FXML
	    private void login() {
	       
	    }
	    
	    private User getUserInDB(String userName, String password) {
	    	Connection connection = null;
	        try
	        {
	          // create a database connection
	          connection = DriverManager.getConnection("jdbc:sqlite:shoppingCartDb.db");
	          Statement statement = connection.createStatement();
	          statement.setQueryTimeout(30);  // set timeout to 30 sec.
	          
	          String getAllPersonString = "select * from personTable where userName = '" 
	        		  				+ userName + "' and password = '" + password + "'";
	          
	          ResultSet rs = statement.executeQuery(getAllPersonString);
	          while(rs.next())
	          {
	        	  User existedUser = new User();
	        	  existedUser.firstName = rs.getString("firstName");
	        	  existedUser.lastName = rs.getString("lastName");
	        	  existedUser.userName = rs.getString("userName");
	        	  existedUser.email = rs.getString("email");
	        	  existedUser.password = rs.getString("password");
	        	  
	        	  return existedUser;
	            // read the result set
//	            System.out.println("name = " + rs.getString("firstName"));
//	            System.out.println("personId = " + rs.getInt("personId"));
	          }
	          
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
	        return null;
	    }
	    
	    @FXML 
	    public void Login(ActionEvent event) throws IOException { 
	    	
	    	User existedUser = getUserInDB(userField.getText(), passField.getText());
	    	if(existedUser != null) {

	    		Alert alert = new Alert(AlertType.NONE, "Login Succesful! Welcome to GSU BookStore", ButtonType.OK);
	    		alert.showAndWait();
	    		if(alert.getResult() == ButtonType.OK) {

//	    			Parent Login = FXMLLoader.load(getClass().getResource("CreditCardTransaction.fxml"));
//	    			Scene LoginScene = new Scene(Login);
//	    			Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
//	    			window2.setScene(LoginScene);
//	    			window2.show();
	    			
	    			Parent Registration = FXMLLoader.load(getClass().getResource("Bookstore.fxml"));
	    			Scene RegistrationScene = new Scene(Registration);
	    			Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
	    			window.setScene(RegistrationScene);
	    			window.show();
	    		}
	    	} else {
	    		Alert alert = new Alert(AlertType.ERROR, "Login Failed!", ButtonType.YES);
	    		alert.show();
	    	}
	    	
	    }
		@FXML 
		public void Create(ActionEvent event) throws IOException {
			Parent Registration = FXMLLoader.load(getClass().getResource("Registration.fxml"));
			Scene RegistrationScene = new Scene(Registration);
			Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			window.setScene(RegistrationScene);
			window.show();
	    }
}

