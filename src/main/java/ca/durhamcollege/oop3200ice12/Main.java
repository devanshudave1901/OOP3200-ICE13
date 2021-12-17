/**
 * @author Devanshu Dave
 * @Student ID: 100785733
 * @date  16/12/2021
 * @type ICE13
 */

package ca.durhamcollege.oop3200ice12;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Main extends Application {
    public static int WIDTH = 640;
    public static  int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setTitle("Hello World");

        // step one - create a control
        Label imageLabel = new Label("Xbox Series X!");



        // configuring the controls
        Button clickMeButton = new Button("Click me");
        clickMeButton.setStyle("-fx-font-family: Arial");
        //clickMeButton.setFont(font);
        FileInputStream imagePath = new FileInputStream("src/main/java/ca/durhamcollege/oop3200ice12/Xbox-Series-X.jpg");
        // step 1 : load the image
        Image xboxSeriesX =  new Image(imagePath);
        // setup a image view to contain it.
        ImageView consoleImageView = new ImageView(xboxSeriesX);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream ps5Path = new FileInputStream("src/main/java/ca/durhamcollege/oop3200ice12/ps5.jpg");
        Image ps5 = new Image(ps5Path);

        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public  void handle(ActionEvent event)
            {
                imageLabel.setText("PS5!");
                consoleImageView.setImage(ps5);
            }
        }
        // For button controls - set an event
        clickMeButton.setOnAction(new ButtonClickHandler());

//        clickMeButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                System.out.println("Click me Button Clicked");
//                imageLabel.setText("PS5!");
//                consoleImageView.setImage(ps5);
//
//            }
//        });
        // step 2- create a container
        HBox hBox = new HBox(10, imageLabel);
       // hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-alignment: center; ");


        HBox hBox2 = new HBox(10,consoleImageView);
        hBox2.setAlignment(Pos.CENTER);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(6,8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));
        gridPane.add(hBox,0,0);
        gridPane.add(hBox2,0,1);
        gridPane.add(consoleImageView, 0,2);


        gridPane.add(clickMeButton,2,2);


        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family:"+
                " Consolas; -fx-font-width: bold; -fx-cell-size: 60px;");

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