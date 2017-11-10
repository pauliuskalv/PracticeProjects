package gui.admin;

import gui.enums.EScene;
import gui.UIController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class MainPanel
{
    private static final String userManagementString = "User Management";
    private static final String statisticsPanelString = "Statistics Panel";
    //private static final String 
    public static Scene display()
    {
        BorderPane layout = new BorderPane();

        /**
         * Populate the left side
         */
        VBox leftLayout = new VBox(10);
        leftLayout.setAlignment(Pos.CENTER);
        /**
         * TODO
         * Think about the max width of the
         *  left layout
         */
        leftLayout.setMaxWidth(200);

        Button enterUserManagement = new Button(userManagementString);
        enterUserManagement.setOnAction(e -> UIController.switchScene(EScene.UserManagement));

        Button enterStatisticsPanel = new Button(statisticsPanelString);
        enterStatisticsPanel.setOnAction(e -> UIController.switchScene(EScene.StatisticsPanel));

        leftLayout.getChildren().addAll(enterUserManagement,enterStatisticsPanel);

        /**
         * Populate the right side
         */
        VBox rightLayout = new VBox();
        rightLayout.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Change this");

        rightLayout.getChildren().add(welcomeLabel);

        layout.setLeft(leftLayout);
        layout.setRight(rightLayout);
        
        return new Scene(layout);
    }
}