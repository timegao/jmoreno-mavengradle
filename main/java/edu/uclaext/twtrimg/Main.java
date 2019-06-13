package edu.uclaext.twtrimg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import twitter4j.*;

import java.net.URL;

public class Main extends Application{
    public void start(Stage stage) throws Exception {
        ConfigReader cr = ConfigReader.getInstance();
        System.out.println(cr.config);

        String fxmlPath = "/fxml/main.fxml";

        URL path = getClass().getResource(fxmlPath);
        FXMLLoader loader = new FXMLLoader(path);
        Parent root = loader.load();
        stage.setTitle("My Title");
        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }

    public static void main(String args[]) {
        launch(args);
    }
}