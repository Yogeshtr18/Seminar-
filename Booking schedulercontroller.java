package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

public class BookingSchedulerController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> slotComboBox;

    @FXML
    private Button validateButton;

    @FXML
    private Button confirmButton;

    @FXML
    public void initialize() {
        // Add slots dynamically
        for (int i = 1; i <= 6; i++) {
            slotComboBox.getItems().add("Slot " + i);
        }

        // Validate Button Action
        validateButton.setOnAction(e -> {
            if (datePicker.getValue() == null || slotComboBox.getValue() == null) {
                showAlert(AlertType.WARNING, "Validation Failed", "Please select both Date and Slot.");
            } else {
                showAlert(AlertType.INFORMATION, "Validation Successful",
                        "Date: " + datePicker.getValue() + "\nSlot: " + slotComboBox.getValue());
            }
        });

        // Confirm Booking Button Action
        confirmButton.setOnAction(e -> {
            if (datePicker.getValue() == null || slotComboBox.getValue() == null) {
                showAlert(AlertType.ERROR, "Booking Failed", "Please validate first before confirming.");
            } else {
                showAlert(AlertType.INFORMATION, "Booking Confirmed",
                        "Your booking is confirmed for " + datePicker.getValue() + " - " + slotComboBox.getValue());
            }
        });
    }

    private void showAlert(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}