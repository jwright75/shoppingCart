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
	import javafx.scene.control.RadioButton;
	import javafx.scene.control.TextField;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;
	import javafx.stage.WindowEvent;

	public class TransactionCotnroller {
		    
		 	@FXML
		    private TextField creditNumField ;
		 	
		    @FXML
		    private TextField firstnameField ;
		    
		    @FXML
		    private TextField lastnameField ;
		    
		    @FXML
		    private TextField monthField ;
		    
		    @FXML
		    private TextField yearField ;
		    
		    @FXML
		    private TextField billingAddress1Field;
		    
		    @FXML
		    private TextField billingAddress2Field;
		    
		    @FXML
		    private TextField cityField;
		    
		    @FXML
		    private TextField stateField;
		    
		    @FXML
		    private TextField zipField;
		    
		    @FXML
		    private TextField phoneField;
		    
		    @FXML
		    private RadioButton visaRadio;
		    
		    @FXML
		    private RadioButton masterCardRadio;
		    
		    @FXML
		    private RadioButton amexRadio;
		    
		    @FXML
		    private RadioButton discoveryRadio;
		    
		    @FXML
		    private Button payButton;
		    
		    @FXML
		    private Button cancelButton;

		    public void showAlert(String alertString) {
		    	Alert errorAlert = new Alert(Alert.AlertType.ERROR);
		    	errorAlert.setTitle("Form Error!");
		    	errorAlert.setHeaderText(alertString);
		    	errorAlert.show();
		    }
		    
		    @FXML 
		    public void pay(ActionEvent event) {
		    	String creditString = creditNumField.getText();
    	        if(creditString.isEmpty()) {
    	        	showAlert("Please enter your credit card numbers");
    	            return;
    	        }
    	        else if (creditString.length() != 16 || !creditString.matches("[0-9]+")) {
    	        	showAlert("Your card credit card number must be 16 digits"
    	        			+ " and cannot contain letter");
    	            return;
    	        }    	        
    	        if((monthField.getText().isEmpty() || yearField.getText().isEmpty())) {
    	        	showAlert("Please enter your month and date");
    	            return;
    	        }
    	        if((monthField.getText().length() != 2) || !monthField.getText().matches("0[1-9]|1[012]")){
    	        	showAlert("Please enter the month in the format of mm "
    	        			+ "for example: 02 or 11");
    	            return;
    	        }
    	        if((yearField.getText().length() != 2 || !yearField.getText().matches("1[8-9]|[2-9][1-9]"))){
    	        	showAlert("Please enter the year in the format of yy and it must be year of 18 or after 18 "
    	        			+ "for example: 18 or 22");
    	            return;
    	        }
    	        if((monthField.getText().isEmpty() || yearField.getText().isEmpty())) {
    	        	showAlert("Please enter your month and date");
    	            return;
    	        }
    	        if(firstnameField.getText().isEmpty()) {
    	        	showAlert("Please enter your first name");
    	            return;
    	        }
    	        if(lastnameField.getText().isEmpty()) {
    	        	showAlert("Please enter your last name");
    	            return;
    	        }
    	        if(billingAddress1Field.getText().isEmpty()) {
    	        	showAlert("Please enter your billing address");
    	            return;
    	        }
    	        if(cityField.getText().isEmpty()) {
    	        	showAlert("Please enter your city");
    	            return;
    	        }
    	        if(stateField.getText().isEmpty()) {
    	        	showAlert("Please enter your state");
    	            return;
    	        }
    	        if(zipField.getText().isEmpty()) {
    	        	showAlert("Please enter your zipcode");
    	            return;
    	        }
    	        if(phoneField.getText().isEmpty()) {
    	        	showAlert("Please enter your phone");
    	            return;
    	        }
    	        

    	       Alert Confirmation = new Alert(Alert.AlertType.CONFIRMATION);
    	       Confirmation.setTitle("Payment Succesful");
    	       Confirmation.setHeaderText("Transaction Succsesful");
    	       Confirmation.setContentText(firstnameField.getText() + " " + lastnameField.getText());
    	       return;
		    }
			@FXML 
			public void CancelButtontoLogin(ActionEvent event) throws IOException{
				Parent Login = FXMLLoader.load(getClass().getResource("Bookstore.fxml"));
				Scene LoginScene = new Scene(Login);
				Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
				window2.setScene(LoginScene);
				window2.show();
		    }
	}