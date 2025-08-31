/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch2Part2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class MainApp extends Application {

    private ListView<String> listViewSource, listViewDest;
    private TextField textFieldName;
    private CheckBox checkBoxName;
    private RadioButton radioButtonGold, radioButtonCyan;
    private Button addButton, deleteButton, updateButton, copyButton, clearButton;
    private VBox root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        listViewSource = new ListView<>();
        listViewSource.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listViewSource.setPrefSize(100, 150);
        listViewSource.getItems().addAll("salah", "abd", "seraj", "mhmd");
        listViewDest = new ListView<>();
        listViewDest.setPrefSize(100, 150);

        HBox h1 = new HBox(10, listViewSource, listViewDest);
        h1.setAlignment(Pos.CENTER);

        textFieldName = new TextField();
        textFieldName.setPromptText("Enter The Name");
        textFieldName.setMinWidth(150);
        textFieldName.setMaxWidth(150);

        checkBoxName = new CheckBox("Select All");
        checkBoxName.setOnAction(e -> {
            if (checkBoxName.isSelected()) {
                listViewSource.getSelectionModel().selectAll();
            } else {
                listViewSource.getSelectionModel().clearSelection();
            }
        });

        VBox v1 = new VBox(10, textFieldName, checkBoxName);
        v1.setAlignment(Pos.CENTER);

        ToggleGroup tg1 = new ToggleGroup();
        radioButtonGold = new RadioButton("Gold");
        radioButtonGold.setOnAction(e -> {
            root.setStyle("-fx-background-color: gold;");
        });
        radioButtonGold.setToggleGroup(tg1);
        radioButtonCyan = new RadioButton("Cyan");
        radioButtonCyan.setOnAction(e -> {
            root.setStyle("-fx-background-color: cyan;");
        });
        radioButtonCyan.setToggleGroup(tg1);
        HBox h2 = new HBox(10, radioButtonGold, radioButtonCyan);
        h2.setAlignment(Pos.CENTER);

        addButton = new Button("Add");
        addButton.setOnAction(e -> {
            listViewSource.getItems().addAll(textFieldName.getText().toLowerCase());
            textFieldName.clear();
        });

        deleteButton = new Button("Delete");
        deleteButton.setOnAction(e -> {
            listViewSource.getItems().remove(textFieldName.getText().toLowerCase());
            textFieldName.clear();
        });

        updateButton = new Button("Update");
        updateButton.setOnAction(e -> {
            listViewSource.getItems().add(listViewSource.getSelectionModel().getSelectedIndex(), textFieldName.getText());
            listViewSource.getItems().remove(listViewSource.getSelectionModel().getSelectedIndex());
            textFieldName.clear();
        });

        copyButton = new Button("Copy");
        copyButton.setOnAction(e -> {
            listViewDest.getItems().addAll(listViewSource.getSelectionModel().getSelectedItems());
            textFieldName.clear();
        });

        clearButton = new Button("Clear");
        clearButton.setOnAction(e -> {
            listViewSource.getItems().clear();
            listViewDest.getItems().clear();
            tg1.selectToggle(null);
            root.setStyle("-fx-background-color: white");
            textFieldName.clear();
        });

        HBox h3 = new HBox(10, addButton, deleteButton, updateButton, copyButton, clearButton);
        h3.setAlignment(Pos.CENTER);

        root = new VBox(15, h1, v1, h2, h3);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("List Manger");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
