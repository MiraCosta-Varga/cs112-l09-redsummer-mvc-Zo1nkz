package cs112.lab09.controllers;

import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EventController {

    private RevisedHistoricalEvent redSummerEvent;
    private String location; //should be made in the class not the controller because it is part of the object

    protected void initData(String location, RevisedHistoricalEvent historicalEvent){
        this.location = location;
        this.redSummerEvent = historicalEvent; //can deep copy here instead

        locationLabel.setText(this.location);
        dateLabel.setText(this.redSummerEvent.getEventDay().toString());
        descriptionLabel.setText(this.redSummerEvent.getDescription());
        revisedDescriptionLabel.setText(this.redSummerEvent.getRevisedDescription());
    }

    @FXML
    private Button closeButton;
    @FXML
    private Label locationLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label revisedDescriptionLabel;


    @FXML
    protected void onCloseButtonClick(ActionEvent actionEvent){
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}
