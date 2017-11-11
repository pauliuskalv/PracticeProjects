package gui.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class UserManagement
{
    private static final String userInfoString = "User type: ";

    private static BorderPane layout;
    private static ListView<String> list;
    private static VBox rightLayout;
    public static Scene display(String[] userStrings)
    {
        layout = new BorderPane();

        /**
         * Show and populate list
         */
        VBox listLayout = new VBox();
        list = new ListView<String>();
        ObservableList<String> elements = FXCollections.observableArrayList(userStrings);
        list.setItems(elements);

        list.getSelectionModel().selectedItemProperty().addListener(e -> handle());

        listLayout.getChildren().add(list);
        listLayout.setPrefWidth(150);

        layout.setLeft(listLayout);

        Scene scene = new Scene(layout);
        return scene;
    }
    private static void handle()
    {
        /**
         * TODO
         * Create the right side for the specific user
         */
        rightLayout = new VBox(10);
        
        /**
         * Populate the right side
         */
        Label infoLabel = new Label(userInfoString + list.getSelectionModel().getSelectedItem());
        

        layout.setRight(rightLayout);
    }
}