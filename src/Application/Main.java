/**
 * Hieu Duong
 * CSC 201
 * Assignment 5
 * Problem 5.36:
 * (Business application: checking ISBN ) Use loops to simplify Programming
 * Exercise 3.9.
 *
 * 09/08/2017
 *
 */

package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/View/View.fxml"));
        primaryStage.setTitle("Assignment 5");
        primaryStage.setScene(new Scene(root, 600, 440));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
