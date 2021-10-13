module com.example.cs180_week8 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cs180_week8 to javafx.fxml;
    exports com.example.cs180_week8;
}