package gui;

import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Insets;

class WarningBox
{
    private static String okButtonText = "Ok";
    static void display(String message, int width, int height)
    {
        Stage window = new Stage();
        Scene scene;

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Warning");
        
        window.setHeight(width);
        window.setWidth(height);

        BorderPane layout = new BorderPane();
        layout.setPadding(new Insets(0,10,0,10));

        Label warningText = new Label(message);
        warningText.setWrapText(true);
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