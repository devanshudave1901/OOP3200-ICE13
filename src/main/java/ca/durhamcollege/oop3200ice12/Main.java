/**
 * @author Devanshu Dave
 * @date  10/12/2021
 * @type ICE12
 */

package ca.durhamcollege.oop3200ice12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static int WIDTH = 640;
    public static  int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws IOException {


        primaryStage.setTitle("Hello World");
        // step one - create a control
        Label helloLabel = new Label("Hello, World");

        Label goodByeLabel = new Label("Good Bye");

        // configuring the controls
        Font font =  Font.font("Consolas", FontWeight.BOLD,40);
        Button clickMeButton = new Button("Click me");
        clickMeButton.setFont(font);

        // For button controls - set an event
        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Click me Button Clicked");
                helloLabel.setText("Clicked");
            }
        });
        // step 2- create a container
        //HBox hBox = new HBox(helloLabel,clickMeButton);
        //VBox vBox = new VBox(helloLabel,clickMeButton);

        GridPane gridPane = new GridPane();
        gridPane.add(helloLabel,1,0);
        gridPane.add(goodByeLabel,1,1);
        gridPane.add(clickMeButton,2,2);
        //var children = vBox.getChildren();
        // step 3- add layout container to scene
        Scene scene = new Scene(gridPane,WIDTH,HEIGHT);

        // step 4 - add scene to the stage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}