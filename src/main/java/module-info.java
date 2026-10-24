module com.example.sumaralgoritmos {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sumaralgoritmos to javafx.fxml;
    exports com.example.sumaralgoritmos;
}