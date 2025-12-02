module com.jtd1368 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jtd1368 to javafx.fxml;
    exports com.jtd1368;
}
