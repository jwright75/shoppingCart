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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SellingController {
	    
	    @FXML private TextField nameField ;
	    
	    @FXML private TextField typeField ;
	    
	    @FXML private TextField conditionField ;
	    
	    @FXML private TextField priceField ;

	    @FXML private TextArea descriptionField ;
	    
	    @FXML private Button Sell;
	    
	    @FXML private Button Cancel;

	    
	    @FXML
	    public void showAlert(String alertString) {
	    	Alert errorAlert = new Alert(Alert.AlertType.ERROR);
	    	errorAlert.setTitle("Form Error!");
	    	errorAlert.setHeaderText(alertString);
	    	errorAlert.show();
	    }
	    
	    public void succesfulAlert(String alertString) {
	    	Alert success = new Alert(Alert.AlertType.CONFIRMATION);
	    	success.setTitle("Item Posted");
	    	success.setHeaderText(alertString);
	    	success.show();
	    }
	    
		@FXML 
		public void Sell(ActionEvent event) throws IOException {
			
			if(nameField.getText().isEmpty()) { 
	            showAlert("Please enter the item name");
	            return;
	        }
			
			if(typeField.getText().isEmpty()) {
	            showAlert("Please enter the item type");
	            return;
	        }
			
			if(conditionField.getText().isEmpty()) {
	            showAlert("Please enter item condition");
	            return;
			}
			
			if(priceField.getText().isEmpty()) {
	            showAlert("Please enter your asking price");
	            return;
	        }

			if(descriptionField.getText().isEmpty()) {
	            showAlert("Please enter decription of item");
	            return;
			} else {
				succesfulAlert("Item successfully posted for sale");
				Parent Registration = FXMLLoader.load(getClass().getResource("Bookstore.fxml"));
				Scene RegistrationScene = new Scene(Registration);
				Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				window.setScene(RegistrationScene);
				window.show();
			}
		}
	    
		@FXML 
		public void Cancel(ActionEvent event) throws IOException {
			Parent Registration = FXMLLoader.load(getClass().getResource("Bookstore.fxml"));
			Scene RegistrationScene = new Scene(Registration);
			Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
			window.setScene(RegistrationScene);
			window.show();
	    }
}

