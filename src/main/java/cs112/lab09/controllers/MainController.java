package cs112.lab09.controllers;

import cs112.lab09.MainApplication;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class MainController {

    @FXML
    private ImageView logoImageView;
    @FXML
    private Button startButton;
    @FXML
    private Button quitButton;

    @FXML
    public void initialize(){
        logoImageView.setImage(new Image(getClass().getResourceAsStream("/images/Red-Summer.jpg")));
    }

    @FXML
    protected void onStartButtonClick(ActionEvent actionEvent) throws IOException {
        //get the map view as a scene
        Parent mapView = FXMLLoader.load(MainApplication.class.getResource("map-view.fxml"));
        Scene mapViewScene = new Scene(mapView);

        //get stage
        Stage window = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        //set the scene (change it) for the stage (window)
        window.setScene(mapViewScene);

        //show
        window.show();
    }

    @FXML
    protected void onQuitButtonClick(){
        Platform.exit();
    }

}