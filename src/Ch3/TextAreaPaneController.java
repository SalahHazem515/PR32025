/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Ch3;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class TextAreaPaneController implements Initializable {

    @FXML
    private TextArea textArea1;
    @FXML
    private Button showButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleShowAction(ActionEvent event) {
        textArea1.clear();
        int[] arr = {1, 3, 4, 5, 61, 71, 16};
        textArea1.setText("Sorted: ");
        IntStream.of(arr).sorted().forEach(v -> textArea1.appendText(v + " "));
        textArea1.appendText("\n");

        Stream
                .of(1, 3, 4, 5, 61, 71, 16)
                .filter(v -> v % 2 == 0)
                .forEach(v -> textArea1.appendText(v + " "));//يفضل هيك تكتبها عشان لو كان في ايرور تعرف وين هو عدل 
        textArea1.appendText("\n");

        int sum = IntStream.rangeClosed(10, 30).filter(v -> v % 2 == 0).reduce(0, (a, b) -> a + b);
        textArea1.appendText("Sum: " + sum);
        textArea1.appendText("\n");

        Double[] arr2 = {1.2, 3.4, 2.2, 65.4, 12.2};
        double avg = Arrays
                .stream(arr2)
                .mapToDouble(v -> (double) v)
                .average().getAsDouble();
        textArea1.appendText("Average: " + avg);
        textArea1.appendText("\n");

        textArea1.appendText(Stream
                .of("salah", "rami", "abd", "mhmd")
                .filter(s -> s.length() > 3)
                .findAny()
                .get()
        );

        textArea1.appendText("\nGrouping:\n");
        Stream
                .of("Hello World", "Hello Hello new World!")
                .flatMap(s -> Stream.of(s.split("[\\s]+")))
                .collect(Collectors.groupingBy(String::toString))
                .forEach((s, List) -> textArea1.appendText(s + ": " + List + "\n"));

        textArea1.appendText("\nCounting:\n");
        Stream
                .of("Hello World", "Hello Hello new World!")
                .flatMap(s -> Stream.of(s.split("[\\s]+")))
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()))
                .forEach((s, c) -> textArea1.appendText(s + ": " + c + "\n"));

        Employee[] employees = {
            new Employee(1, "Ahmad", "IT", 1201.5),
            new Employee(2, "Sami", "Sales", 950.8),
            new Employee(5, "Huda", "IT", 1010.5),
            new Employee(7, "Ali", "Marketing", 1300.4),
            new Employee(4, "Hani", "Sales", 1050.7)
        };
        
        List<Employee> employeeList = Arrays.asList(employees);
        
        textArea1.appendText("\nSorted Employees:\n");
        employeeList
                .stream()
                .filter(e -> e.getSalary()>=1100)
                .forEach(e -> textArea1.appendText(e+"\n"));
    }
}
