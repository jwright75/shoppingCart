package ViewLogin;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


public class BookstoreController implements Initializable {
	
	ObservableList<Book> data =  FXCollections.observableArrayList();
	
	@FXML
	TableView<Book> table;
	
	@FXML
	private TableColumn<?, ?> authorCol;
	
	@FXML
	private TableColumn<?, ?> bookCol;
	
	@FXML
    private Label isbnLabel;
 	
	@FXML
    private Label bookNameLabel;
	
	@FXML
    private Label authorLabel;
	
	@FXML
    private Label editionLabel;
	
	@FXML
    private Label yearLabel;
	
	@FXML
    private Label priceLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
		bookCol.setCellValueFactory(new PropertyValueFactory<>("book"));
		table.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				Book selectedBook = table.getSelectionModel().getSelectedItem();
				showBookDetails(selectedBook);
			}
		});
		
		loadDatabase();
	}
	
	public void showBookDetails(Book book) {
		isbnLabel.setText(""+book.getIsbn());
		bookNameLabel.setText(book.getBook());
		authorLabel.setText(book.getAuthor());
		editionLabel.setText(""+book.getEdition());
		yearLabel.setText(""+book.getYear());
		priceLabel.setText("$"+book.getPrice());
	}
	
	public void loadDatabase() {
		
		Connection connection = null;
		try
        {
          // create a database connection
          connection = DriverManager.getConnection("jdbc:sqlite:shoppingCartDb.db");
          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          String query = "select * from bookTable";
          ResultSet rs = statement.executeQuery(query);
          while(rs.next())
          {
        	  Book existedBook = new Book(
        			  rs.getInt("isbn"),
        			  rs.getString("book"),
        			  rs.getString("author"),
        			  rs.getInt("edition"),
        			  rs.getInt("year"),
        			  rs.getFloat("price"));
        	  
        	  data.add(existedBook);
        	  table.setItems(data);
          }
          statement.close();
          rs.close();
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
	
	
	public BookstoreController() {
		
	}
	public void CheckoutButton(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("CreditCardTransaction.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }
	
	//sell button
	public void sellButton(ActionEvent event) throws IOException{
		Parent Login = FXMLLoader.load(getClass().getResource("Selling.fxml"));
		Scene LoginScene = new Scene(Login);
		Stage window2 = (Stage) ((Node) (event.getSource())).getScene().getWindow();
		window2.setScene(LoginScene);
		window2.show();
    }

	@FXML 
    public void deleteBookFromTable(ActionEvent event) throws IOException { 
		table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
	}
	
}