/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch2Part1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class KiloConverter extends Application {

    private Label enterLabel, viewResult;
    private TextField kiloValue;
    private Button convertButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        enterLabel = new Label("Enter the value with Kilo Meters:");
        kiloValue = new TextField();
        VBox v1 = new VBox(10, enterLabel, kiloValue);
        v1.setAlignment(Pos.CENTER);

        viewResult = new Label("Result");
        convertButton = new Button("Convert");
        convertButton.setOnAction(e -> {
            double result = Double.parseDouble(kiloValue.getText()) * 0.6214;
            result = Math.round(result * 100) / 100d;
            viewResult.setText(result + " miles");
        });

        HBox h1 = new HBox(10, viewResult, convertButton);
        h1.setAlignment(Pos.CENTER);

        VBox v2 = new VBox(10, v1, h1);
        v2.setAlignment(Pos.CENTER);

        FlowPane f1 = new FlowPane(v2);
        f1.setAlignment(Pos.CENTER);

        Scene scene = new Scene(f1, 200,200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Kilo Meters Convert");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
