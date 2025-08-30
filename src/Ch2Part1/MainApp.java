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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author HP
 */
public class MainApp extends Application {

    private Label labelTitle, labelError;
    private TextField textLoginName;
    private PasswordField passwordField;
    private Button buttonSubmit, buttonCancel; //احنا عرفناهم برا بس هلقيت عشان ندخلهم للشاشة لازم نروح نضيفهم في ال start 

    @Override
    public void start(Stage primaryStage) throws Exception {
        labelTitle = new Label("Login Information"); //عرفناهم واحد واحد هينا
        textLoginName = new TextField();
        textLoginName.setPromptText("Login Name");// نص مظلل حيظهر داخل صندوق الأدخال
        passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        labelError = new Label("Initial text");
        VBox v1 = new VBox(10, labelTitle, textLoginName, passwordField, labelError); // ضفناهم لفرع شجرة زي ما شرحنا سابقاً

        v1.setAlignment(Pos.CENTER);

        buttonSubmit = new Button("Submit");
        buttonSubmit.setOnAction(e -> {
            if (textLoginName.getText().toLowerCase().equals("salah") && passwordField.getText().equals("123")) {
                labelError.setText("Vaild user");
            } else {
                labelError.setText("Invalid Data");
            }
        });
        /* ممكن نعمل inner class تحت ونحط فيه داله if
        if(event.getSource() == ButtonName) وهذا الدالة get source بترجع الزر يلي انضغط عليه 
        فممكن نعملها جوا اينر كلاس زي ما قلنا ونقله لو انضعط ع الزر هذا اعمل كذا ولو انضغط ع الزر هذا اعمل كذا وكذلك
        وبعدها بروح بعطي نفس الكلاس للزرين من خلال
        buttonName.setOnAction(new ClassInnerName());
        بس انا استخدمت طريقة ال lambda هنا لانها اسهل 
         */
        buttonCancel = new Button("Cancel");
        buttonCancel.setOnAction(e -> {
            textLoginName.setText("");
            passwordField.setText("");
            labelError.setText("Initial text");
        });

        HBox h1 = new HBox();
        h1.getChildren().addAll(buttonSubmit, buttonCancel);// هنا ادخلنا البيانات للصندوق بطريقة غير بدل ما ندخلهم من ال constractor
        // getChildren() هذه دالة بترجع observableList عشان اقدر اتعامل معها من ناحية اضافة او حذف ال node 
        /*
        عنا عدة دوال بنسخدمها بعد الgetC.... وهم:
        add(item): بضيف عنصر واحد
        addAll(item...): بضيف عدة عناصر او عنصر واحد بس 
        clear(): بحذف كافة العناصر
        remove(item): بيحذف عنصر واحد
        removeAll(item...): بيحذف عنصر أو أكثر 
        setAll(item...): بيمسح كل العناصر القديمة وبحط العناصر يلي بتحطها جواه
        size(): برجع عدد العناصر
         */
        h1.setSpacing(20);
        h1.setAlignment(Pos.CENTER);

        VBox v2 = new VBox(10, v1, h1);
        v2.setAlignment(Pos.CENTER);

        FlowPane f1 = new FlowPane(v2);// هذا layout كثير مستخدم ممكن نعتبره هو جذر الشجرة  root زي ما شرحنا سابقا
        f1.setAlignment(Pos.CENTER);

        // تأكد دايما إنو كل الاستدعاءات من JavaFx
        Scene s1 = new Scene(f1, 400, 300); //بضيف على المشهد
        primaryStage.setScene(s1); // بضيف على المسرح
        primaryStage.setTitle("Login Screen");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
