package ViewLogin;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountDetails {
	public void EditUsername(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("EditUsername.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void EditEmail(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("EditEmail.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void EditPassword(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("EditPassword.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void EditAll(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("EditAll.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void CheckoutButton(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("CreditCardTransaction.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void sellButton(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("Selling.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void homeButton(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("Bookstore.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
}