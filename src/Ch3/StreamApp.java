/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch3;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class StreamApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane textAreaPane = FXMLLoader.load(getClass().getResource("/Ch3/TextAreaPane.fxml"));
        Pane listPane = FXMLLoader.load(getClass().getResource("/Ch3/ListPane.fxml"));
        Map<String, Pane> mapPanes = new TreeMap<>();
        mapPanes.put("textArea", textAreaPane);
        mapPanes.put("listPane", listPane);
        
        Scene scene = new Scene(mapPanes.get("textArea"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Strems Application");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
