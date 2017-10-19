package gui;

import gui.enums.EScene;

import javafx.application.Application;
import javafx.stage.Stage;

public class UIController extends Application
{
    private static Stage window;
    public static void main (String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        primaryStage.setTitle("RestaurantManagement");

        switchScene(EScene.LogInPanel);
        window.setResizable(false);
        window.setHeight(150);
        window.setWidth(215);
        window.show();
    }
    public static void switchScene(EScene scene)
    {
        switch(scene)
        {
            case LogInPanel:
            {
                window.setScene(LogInPanel.display());
            }
            case MainPanel:
            {

            }
        }
    }
}