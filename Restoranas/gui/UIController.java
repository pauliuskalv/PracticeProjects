package gui;

import gui.enums.EScene;

import javafx.application.Application;
import javafx.stage.Stage;
import logincontroller.Account;

public class UIController extends Application
{
    private static Account userAccount;
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

        switchScene(EScene.MainPanel);
        window.setResizable(false);
        window.setHeight(350);
        window.setWidth(400);
        window.show();
    }
    public static void switchScene(EScene scene)
    {
        switch(scene)
        {
            case LogInPanel:
            {
                window.setTitle("LogIn");
                window.setScene(LogInPanel.display());
                break;
            }
            case RegisterAdminPanel:
            {
                WarningBox.display("Hello!\n"+
                                    "The app needs to create a new administrator\n"+
                                    "on the first run\n"+
                                    "Enter the appropriate data in the window",200,300);
                window.setTitle("Register new Admin");
                window.setScene(null);
                window.setScene(RegisterPanel.display());
                /**
                 * TODO
                 * Handle registration for admin here
                 */
                break;
            }
            case RegisterPanel:
            {
                window.setTitle("Register new user");
                window.setScene(RegisterPanel.display());
                break;
            }
            case MainPanel:
            {
                window.setTitle("RestaurantManagement");
                window.setScene(gui.user.MainPanel.display());
                break;
            }
        }
    }
}