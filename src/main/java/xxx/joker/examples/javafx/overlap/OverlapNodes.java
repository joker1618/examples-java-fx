package xxx.joker.examples.javafx.overlap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.scenicview.ScenicView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OverlapNodes extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(OverlapNodes.class);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("OVERLAP NODES SPIKE");

        Button button = new Button("Hello");
        Text text = new Text("hello");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(button, text); // button will be left of text

//        Image image = new Image("space.jpg",x,y, false, false);
//        ImageView iv1 = new ImageView();
        Image image = new Image("/img/casa.png");
        ImageView iv1 = new ImageView(image);
        iv1.setPreserveRatio(false);
        iv1.setFitWidth(220d);
        iv1.setFitHeight(220d);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(iv1, hbox); // hbox with button and text on top of image view

        HBox root = new HBox();
        root.getChildren().add(stackPane);

        // Create scene
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/common.css").toExternalForm());

        primaryStage.setScene(scene);
//        primaryStage.setMaximized(true);
        primaryStage.sizeToScene();
        primaryStage.show();

        boolean scenicView = !getParameters().getRaw().isEmpty() && getParameters().getRaw().get(0).equals("-sv");
        if (scenicView) {
            ScenicView.show(scene);
        }

//        Platform.setImplicitExit(false);
//        primaryStage.setOnCloseRequest(e -> {
//            if (panesSel.isHomeShowed()) {
//                Platform.exit();
//            } else {
//                e.consume();
//                panesSel.displayHomePane();
//            }
//        });
    }

    // Show stage
    @Override
    public void stop() throws Exception {
        LOG.info("Closing app");
    }

    public static void main(String[] args) {
        launch(args);
    }

}