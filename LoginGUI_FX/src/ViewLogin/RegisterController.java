package ViewLogin;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.stage.WindowEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterController {
		private User user;
	    
	    @FXML
	    private TextField firstName ;
	    
	    @FXML
	    private TextField lastName ;
	    
	    @FXML
	    private TextField userName ;
	    
	    @FXML
	    private TextField email ;

	    @FXML
	    private PasswordField password ;
	    
	    @FXML
	    private PasswordField confirm ;
	    
	    @FXML
	    private Button Create;
	    
	    @FXML
	    private Button Cancel;

	    @FXML
	    public void Create(ActionEvent event) {
	    	Create.setOnAction(new EventHandler<ActionEvent>() {
	    	    @Override
	    	    public void handle(ActionEvent event) {

	    	    }
	    	});
	    }
	    
	    @FXML
	    public void showAlert(String alertString) {
	    	Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	    	errorAlert.setTitle("Form Error!");
	    	errorAlert.setHeaderText(alertString);
	    	errorAlert.show();
	    }
	    
		@FXML 
		public void createButtonClick(ActionEvent event) throws IOException {
			
			if(firstName.getText().isEmpty()) { 
	            showAlert("Please enter your first name");
	            return;
	        }
			
			if(lastName.getText().isEmpty()) {
	            showAlert("Please enter your last name");
	            return;
	        }
			
			if(userName.getText().isEmpty()) {
	            showAlert("Please enter your username");
	            return;
			}
			
			if(email.getText().isEmpty()) {
	            showAlert("Please enter your email");
	            return;
	        }

			if(password.getText().isEmpty()) {
	            showAlert("Please enter your password");
	            return;
	        }

			if(confirm.getText().isEmpty()) {
	            showAlert("Please enter your confirm password");
	            return;
	        }
			
			if (!password.getText().equals(confirm.getText())) {
				showAlert("Your password and confirm password don't match");
 	            return;
 	        }
			
			User newUser = new User();
			newUser.firstName = firstName.getText();
			newUser.lastName = lastName.getText();
			newUser.userName = userName.getText();
			newUser.email = email.getText();
			newUser.password = password.getText();
			
			boolean isSavedSuccessfully = saveUserToDB(newUser);
			
			if (isSavedSuccessfully) {
				Alert alert = new Alert(AlertType.NONE, "Registration Succesful! Welcome to GSU BookStore", ButtonType.OK);
				alert.showAndWait();
				if (alert.getResult() == ButtonType.OK) {

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
			
		private boolean saveUserToDB(User user) {
	    	Connection connection = null;
	        try
	        {
	          // create a database connection
	          connection = DriverManager.getConnection("jdbc:sqlite:shoppingCartDb.db");
	          Statement statement = connection.createStatement();
	          statement.setQueryTimeout(30);  // set timeout to 30 sec.
	          
//	          String getAllPersonString1 = "insert into personTable values"
//	          		+ "(1, 'leo','le','leo123','leo123@gmail.com','leole')\"";
	          
	          String getAllPersonString = "insert into personTable values('"
	        		    + user.firstName + "', '"
		          		+ user.lastName  + "', '"
		          		+ user.userName  + "', '"
		          		+ user.email     + "', '"
		          		+ user.password  + "')";
	          statement.executeQuery(getAllPersonString);
	          return true;
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
	        return true;
	    }
		
		@FXML
		public void CancelButtontoLogin(ActionEvent event) throws IOException{
			Parent Login = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene LoginScene = new Scene(Login);
			Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			window2.setScene(LoginScene);
			window2.show();
	    }
}

