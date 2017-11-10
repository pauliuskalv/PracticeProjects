package gui.user;

import gui.UIController;
import gui.enums.EScene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainPanel
{
    private static final String layoutDesignerText = "Layout Designer";
    private static final String logOutText = "Log out";
    private static final String startSessionText = "Start a new session";
    private static final String settingsText = "User settings";
    private static final String text = "Informational text goes here";
    private static final Insets defaultInsets = new Insets(0,10,0,10);
    public static Scene display()
    {
        Scene scene;

        BorderPane layout = new BorderPane();

        /**
         * Set up buttons
         */
        VBox topButtonLayout = new VBox(10);
        topButtonLayout.setPadding(defaultInsets);
        topButtonLayout.setAlignment(Pos.CENTER_LEFT);

        VBox logOutButtonLayout = new VBox(10);
        logOutButtonLayout.setPadding(defaultInsets);
        logOutButtonLayout.setAlignment(Pos.CENTER_RIGHT);

        Button layoutDesigner = new Button(layoutDesignerText);
        layoutDesigner.setOnAction(e -> UIController.switchScene(EScene.LayoutDesigner));

        Button startSession = new Button(startSessionText);
        /**
         * TODO
         * Add action for startSession
         */

        Button settings = new Button(settingsText);
        /**
         * Add action for settings
         */

        Button logOut = new Button(logOutText);
        logOut.setOnAction(e -> UIController.switchScene(EScene.LogInPanel));

        topButtonLayout.getChildren().addAll(layoutDesigner,startSession,
                                            settings);

        logOutButtonLayout.getChildren().add(logOut);

        /**
         * Set up informational text
         */
        VBox textLayout = new VBox();
        textLayout.setPadding(defaultInsets);
        textLayout.setAlignment(Pos.CENTER_RIGHT);

        Label textLabel = new Label(text);
        textLabel.setFont(new Font(10));

        textLayout.getChildren().add(textLabel);

        /**
         * Set constraints
         */

        layout.setLeft(topButtonLayout);
        layout.setCenter(textLayout);
        layout.setBottom(logOutButtonLayout);

        scene = new Scene(layout);

        return scene;
    }
}