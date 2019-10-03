package ViewLogin;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditPassword {

	public void Cancel(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("AccountEdit.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	public void Accept(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("AccountEdit.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	
}