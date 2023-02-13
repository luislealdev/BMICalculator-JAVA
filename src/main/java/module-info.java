module com.example.bmicalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bmicalculator to javafx.fxml;
    exports com.example.bmicalculator;
}