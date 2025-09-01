/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ch2Part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class chapterExecrise extends Application {

    private MenuBar menuBar1;
    private Menu menuFile;
    private MenuItem menuItemOpen;
    private TextArea textArea1;
    private Slider sliderFontSize;
    private ComboBox<String> comboBox1;
    private WebView webView1;
    private FileChooser filechooser1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        menuBar1 = new MenuBar();//إنشاء شريط المنيو
        menuFile = new Menu("File");// انشاء خيار داخل شريط المنيو وتحديد اسمه
        menuItemOpen = new MenuItem("Open");// انشاء عنصر داخل خيار ال file 
        menuFile.getItems().add(menuItemOpen);// ربط عنصر ال open بخيار ال file 
        menuBar1.getMenus().add(menuFile);//اضافة أو ربط خيار ال file الى شريط المنيو
        menuItemOpen.setOnAction(e -> {
            filechooser1 = new FileChooser();
            filechooser1.setInitialDirectory(new File("src/Ch2Part2"));// اختيار قيمة مبدئية للملف
            File fileSelected = filechooser1.showOpenDialog(primaryStage);

            try (Scanner scanner = new Scanner(fileSelected)) {
                textArea1.setText("");
                while (scanner.hasNext()) {
                    textArea1.appendText(scanner.nextLine()+ "\n");
                }
                scanner.close();
            } catch (FileNotFoundException ffe) {
                Logger.getLogger(chapterExecrise.class.getName()).log(Level.SEVERE, null, ffe);
            }
        });

        textArea1 = new TextArea("Playing with JavaFx Advanced Controls");// هنا وفي ال textField في عندك امكانية تضيف نص بس بكون نص ظار يعني المستخدم بيحذفه عشان يضيف بداله
        //textArea1.setPromptText("Playing with JavaFx Advanced Controls");// اما هنا بتضيف نص خفي او زي ظل عامل
        textArea1.setMaxHeight(300);
        textArea1.setMaxWidth(500);
        textArea1.setWrapText(true);

        sliderFontSize = new Slider(5, 35, 12);
        sliderFontSize.setMajorTickUnit(5);// اضافة تخطيطات ع السطر للارقام للتمييز الماجور للخطوط الكبيرة و الاساسية
        sliderFontSize.setMinorTickCount(3);// اضافة تخططيات صغيرة وفرعية بين كل 3 
        sliderFontSize.setShowTickLabels(true);// يظهر الارقام على الخطوط او الماجور تعون السلايدر
        sliderFontSize.setShowTickMarks(true);// يظهر الخطوط او العلامات على السلايدر زهنا قصدي المجور والمانيور ديربالك لو خليناه خطأ حيظهر سلايدر فاضي
        sliderFontSize.setSnapToTicks(true);// انو المؤشر ما يوقف على مناطق عشرية يعني بس يلزق على ارقام صحيحة وبس يعني لو انت حطيت المؤشر في منطقة بالنص المؤشر حينط على أقرب عدد صحيح
        sliderFontSize.valueProperty().addListener(e -> {
            textArea1.setStyle("-fx-font-size: " + sliderFontSize.getValue() + "pt");
        });

        webView1 = new WebView();//عشان اضيف مواقع لتطبيقي

        comboBox1 = new ComboBox<>();
        comboBox1.getItems().addAll("My GitHup", "JavaFx Guide");
        comboBox1.getSelectionModel().select(1);
        webView1.getEngine().load("https://www.oracle.com/java/technologies/javase/javafx-overview.html");
        comboBox1.setOnAction(e -> {
            String selected = comboBox1.getSelectionModel().getSelectedItem();
            if (selected.equals("My GitHup")) {
                webView1.getEngine().load("https://github.com/SalahHazem515");
            } else if (selected.equals("JavaFx Guide")) {
                webView1.getEngine().load("https://www.oracle.com/java/technologies/javase/javafx-overview.html");
            }
        });

        HBox h1 = new HBox(15, comboBox1, webView1);

        VBox v1 = new VBox(15, textArea1, sliderFontSize, h1);

        BorderPane bp1 = new BorderPane();
        bp1.setTop(menuBar1);// لازم نحط المنيو في التوب من خلال ال borderPane
        bp1.setCenter(v1);

        Scene scene = new Scene(bp1, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple pro");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
