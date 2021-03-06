package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.ui.Controller;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        primaryStage.setTitle("Lab3-5OOP");
        primaryStage.setScene(new Scene(root, 330, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
