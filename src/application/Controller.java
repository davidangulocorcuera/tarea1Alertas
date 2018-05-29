package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

public class Controller {
	private String verano = "21-06-2018";
	private String primavera = "20-03-2018";
	private String invierno = "21-12-2018";
	private String otono = "22-09-2018";
	
	
	@FXML
	private Button myButton;

	@FXML
	private TextField myTextField;

	@FXML
	public void initialize() {

		// TODO (don't really need to do anything here).

	}
	

	// When user click on myButton
	// this method will be called.
	public void showDateTime(ActionEvent event) {
		System.out.println("Button Clicked!");

		Date now = new Date();
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		int mesActual = now.getMonth() + 1;
		
		// Model Data
		String dateTimeString = df.format(now);
		String[] cosas = dateTimeString.split("-");
		int mesPrueba = Integer.parseInt(cosas[1]);
		// Show in VIEW
		myTextField.setText(dateTimeString);
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Fecha");
		alert.setHeaderText("La fecha de hoy es");
		alert.setContentText(dateTimeString);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.OK) {
			if (mesPrueba >= 12 && mesPrueba <= 3 ) {
				alert.setTitle("Fecha");
				alert.setHeaderText("La fecha de hoy es");
				alert.setContentText("estas en invierno");
				alert.showAndWait();
			}
			else if (mesPrueba >= 3 && mesPrueba <= 6 ) {
				alert.setTitle("Fecha");
				alert.setHeaderText("La fecha de hoy es");
				alert.setContentText("estas en primavera");
				alert.showAndWait();
			}
			else if (mesPrueba >= 6 && mesPrueba <= 9) {
				alert.setTitle("Fecha");
				alert.setHeaderText("La fecha de hoy es");
				alert.setContentText("estas en verano");
				alert.showAndWait();
			}
			else if (mesPrueba >= 9 && mesPrueba <= 12) {
				alert.setTitle("Fecha");
				alert.setHeaderText("La fecha de hoy es");
				alert.setContentText("estas en otoño");
				alert.showAndWait();
			}

		} else {
			// ... user chose CANCEL or closed the dialog
		}

	}

}