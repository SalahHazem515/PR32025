/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch2Part3;

/**
 *
 * @author HP
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button cancelButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField textFieldLogIn;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Label outputLabel;

    @FXML
    public void handleButtonCancel(ActionEvent event) {
        textFieldLogIn.clear();
        userPassword.clear();
        outputLabel.setText("Initial Text");
    }

    @FXML
    public void handleButtonSubmit(ActionEvent event) {
        if (textFieldLogIn.getText().equals("salah") && userPassword.getText().equals("1032005")) {
            outputLabel.setText("Correct User");
        } else {
            outputLabel.setText("InCorrect User");
        }
    }
}
