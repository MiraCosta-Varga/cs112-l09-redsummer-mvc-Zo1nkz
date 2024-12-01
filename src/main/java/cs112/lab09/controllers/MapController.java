package cs112.lab09.controllers;

import cs112.lab09.MainApplication;
import cs112.lab09.models.Date;
import cs112.lab09.models.RevisedHistoricalEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MapController {

    //Convenient helper method
    private void openPopupWindow(String location, RevisedHistoricalEvent rhEvent) throws IOException {
        //get FXML file for the popup window
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("event-view.fxml"));
        Parent evenViewParent = loader.load();

        //pass data to controller for that specific view
        EventController eventController = loader.getController();
        eventController.initData(location, rhEvent);


        //create new stage (stage=window)
        Stage popupStage = new Stage();
        //extra step: change modality of window
        popupStage.initModality(Modality.APPLICATION_MODAL);
        //set scene
        popupStage.setScene(new Scene(evenViewParent));
        //show scene
        popupStage.show();
    }
    @FXML
    protected void onSanFranciscoCAButtonClick() throws IOException {
        RevisedHistoricalEvent sfEvent = new RevisedHistoricalEvent("A minor riot between Black and white soldiers occured in the Presidio in San Francisco.",
                new Date(5,15,1919), "A minor riot between Black and white soldiers occured in the Presidio in San Francisco after a dispute about a Thai soldier who was moved from the \"colored quarters\" to the white military housing. Despite defending our country, housing for Black soldiers was not only segregated, but often inferior. Black soldiers also faced increased attacks and other forms of discrimination upon returning home.",
                "https://visualizingtheredsummer.com/?page_id=6");

        this.openPopupWindow("San Francisco, CA", sfEvent);

        //get FXML file for the popup window
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApplication.class.getResource("event-view.fxml"));
        Parent evenViewParent = loader.load();
    }

    @FXML
    protected void onBisbeeAZButtonClick() throws IOException {
        RevisedHistoricalEvent bisbee = new RevisedHistoricalEvent("The Chief of Police and his men began moving through town, systematically disarming Black soldiers by force. Hundreds of shots were fired at the cavalrymen by the police officers and civilian white vigilantes.",
                new Date(7, 13, 1919),
                "On July 3, 1919, active members of the Army’s segregated 10th Cavalry Regiment (“Buffalo Soldiers”) were in Bisbee, Arizona, to participate in the town’s Independence Day parade.  According to a New York Times report about the violence in Bisbee, local white law enforcement “planned deliberately to aggravate the Negro troops so that they would furnish an excuse for police and deputy sheriffs to shoot them down.”",
                "https://www.zinnedproject.org/news/tdih/brewery-gulch-battle/");
        this.openPopupWindow("Bisbee, AZ", bisbee);
    }
}
