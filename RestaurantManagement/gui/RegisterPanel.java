package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

class RegisterPanel
{
    private static final String usernameLabelText = "Username:";
    private static final String passwordLabelText = "Password:";
    private static final String passwordLabelTextConfirm = "Repeat password:";
    public static Scene display()
    {
        Scene toReturn;

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        /**
         * Create username fields
         */
        VBox usernameLayout = new VBox();

        Label usernameLabel = new Label(usernameLabelText);
        TextField usernameField = new TextField();

        usernameLayout.setPadding(new Insets(0, 10, 0, 10));

        usernameLayout.getChildren().addAll(usernameLabel,usernameField);

        /**
         * Create password fields
         */
        GridPane passwordLayout = new GridPane();

        Label passwordLabel = new Label(passwordLabelText);
        Label passwordLabelConfirm = new Label(passwordLabelTextConfirm);
        PasswordField passwordFieldLeft = new PasswordField();
        PasswordField passwordFieldRight = new PasswordField();

        GridPane.setConstraints(passwordLabel,0,0);
        GridPane.setConstraints(passwordLabelConfirm,1,0);
        GridPane.setConstraints(passwordFieldLeft,0,1);
        GridPane.setConstraints(passwordFieldRight,1,1);

        passwordLayout.setPadding(new Insets(0,10,0,10));

        passwordLayout.getChildren().addAll(passwordLabel,passwordLabelConfirm,
                                            passwordFieldLeft,passwordFieldRight);

        /**
         * Create the confirm button
         */
        VBox confirmButtonLayout = new VBox();
        Button confirmButton = new Button("Confirm");

        confirmButton.setOnAction(e -> handle());

        confirmButtonLayout.getChildren().add(confirmButton);
        confirmButtonLayout.setAlignment(Pos.CENTER_RIGHT);
        confirmButtonLayout.setPadding(new Insets(0,10,0,10));

        /**
         * Finish by finalizing the layout variable
         */
        layout.getChildren().addAll(usernameLayout,passwordLayout,confirmButtonLayout);

        toReturn = new Scene(layout);

        return toReturn;
    }
    private static void handle()
    {

    }
}