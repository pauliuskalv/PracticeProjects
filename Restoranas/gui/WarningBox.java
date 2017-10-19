package gui;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

class WarningBox
{
    private static String okButtonText = "Ok";
    static void display(String message)
    {
        Stage window = new Stage();
        Scene scene;

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Warning");
        
        window.setHeight(200);
        window.setWidth(200);

        BorderPane layout = new BorderPane();

        Label warningText = new Label(message);
        Button okButton = new Button(okButtonText);
        okButton.setOnAction(e -> window.close());

        layout.setCenter(warningText);
        BorderPane.setAlignment(okButton,Pos.CENTER);
        layout.setBottom(okButton);

        scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}