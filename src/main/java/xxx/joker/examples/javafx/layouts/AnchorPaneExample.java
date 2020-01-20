package xxx.joker.examples.javafx.layouts;

// Java Program to create a AnchorPane, adding
// label and button to it and also setting the
// min height and width of AnchorPane then add
// it to the stage

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.scenicview.ScenicView;

import static xxx.joker.libs.javafx.util.JfxControls.createHBox;

public class AnchorPaneExample extends Application {

    private static boolean scenicView = false;
    // launch the application
    public void start(Stage stage)
    {

        try {

            // set title for the stage
            stage.setTitle("AnchorPane");

            // create a label
            Label label = new Label("this is AnchorPane example");
            HBox lblBox = createHBox("bgPink", label);

            // create a AnchorPane
            AnchorPane anchor_pane = new AnchorPane(lblBox);

            // anchor to the label
            AnchorPane.setTopAnchor(lblBox, 120.0);
            AnchorPane.setLeftAnchor(lblBox, 10.0);
            AnchorPane.setRightAnchor(lblBox, 230.0);
            AnchorPane.setBottomAnchor(lblBox, 120.0);

            Button button = new Button("button");
            HBox btnBox = createHBox("bgGreen", button);

            // anchor to the button
            AnchorPane.setTopAnchor(btnBox, 125.0);
            AnchorPane.setLeftAnchor(btnBox, 220.0);
            AnchorPane.setRightAnchor(btnBox, 110.0);
            AnchorPane.setBottomAnchor(btnBox, 125.0);

            anchor_pane.getChildren().add(btnBox);

            anchor_pane.setMinHeight(400);
            anchor_pane.setMinWidth(400);

            // create a scene
            Scene scene = new Scene(anchor_pane, 400, 300);

            // set the scene
            stage.setScene(scene);

            stage.show();

            scene.getStylesheets().add(getClass().getResource("/css/common.css").toExternalForm());

            if(scenicView) {
                ScenicView.show(scene);
            }

        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    // Main Method
    public static void main(String args[])
    {
        scenicView = true;
        // launch the application
        launch(args);
    }
}