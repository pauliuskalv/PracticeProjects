package gui;

import gui.enums.EScene;

import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

class LogInPanel
{
    static final int preferredWidth = 500;
    static final int preferredHeight = 500;
    private static final String username = "Username:";
    private static final String password = "Password:";
    public static Scene display()
    {
        Scene toReturn;

        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);

        Label usernameLabel = new Label(username);
        TextField usernameField = new TextField();

        GridPane.setConstraints(usernameLabel,0,0);
        GridPane.setConstraints(usernameField,0,1);

        Label passwordLabel = new Label(password);
        PasswordField passwordField = new PasswordField();

        GridPane.setConstraints(passwordLabel,0,2);
        GridPane.setConstraints(passwordField,0,3);

        VBox layoutConfirm = new VBox();
        layoutConfirm.setAlignment(Pos.CENTER_RIGHT);
        Button confirm = new Button("Confirm");
        confirm.setOnAction(e -> check(usernameField.getText(),
                                        passwordField.getText()));
        layoutConfirm.getChildren().add(confirm);

        GridPane.setConstraints(layoutConfirm,0,4);

        layout.getChildren().addAll(usernameLabel,usernameField,
                                    passwordLabel,passwordField,
                                    layoutConfirm);

        layout.getColumnConstraints().add(new ColumnConstraints(200));


        toReturn = new Scene(layout);

        return toReturn;
    }
    private static void check(String username, String password)
    {
        if ( username.equals("admin") && password.equals("admin") )
        {
            UIController.switchScene(EScene.MainPanelAdmin);
        }
        else
            WarningBox.display("This user does not exist!",150,150);
    }
}