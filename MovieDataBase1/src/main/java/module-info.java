module com.example.moviedatabase1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.moviedatabase1 to javafx.fxml;
    exports com.example.moviedatabase1;
}