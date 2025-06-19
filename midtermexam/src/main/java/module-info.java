module com.example.midtermexam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.midtermexam to javafx.fxml;
    exports com.example.midtermexam;
}