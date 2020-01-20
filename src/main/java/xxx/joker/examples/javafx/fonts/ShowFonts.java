package xxx.joker.examples.javafx.fonts;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import org.scenicview.ScenicView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xxx.joker.libs.core.debug.JkDebug;

public class ShowFonts extends Application {

    private static final Logger LOG = LoggerFactory.getLogger(ShowFonts.class);
    private static boolean scenicView;
    private FontsPane fontsPane;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.fontsPane = new FontsPane();

        // Create scene
        Group root = new Group();
        Scene scene = new Scene(root);
//        Scene scene = new Scene(root, 600, 500);
        scene.setRoot(new ScrollPane(fontsPane));

        // Show stage
        primaryStage.setScene(scene);
//        primaryStage.sizeToScene();
        primaryStage.setMaximized(true);

//        primaryStage.setResizable(false);
        scene.getStylesheets().add(getClass().getResource("/css/ShowFonts.css").toExternalForm());
        primaryStage.show();


        if(scenicView) {
            ScenicView.show(scene);
        }


    }


    @Override
    public void stop() throws Exception {
        LOG.debug("STOP APP");
        JkDebug.displayTimes();
//        JfxTable<StatsLine> table = (JfxTable<StatsLine>) fontsPane.lookup(".homePane .jfxTable");
//        display("border {}", ToStringBuilder.reflectionToString(table.getBorder(), ToStringStyle.MULTI_LINE_STYLE));

    }

    public static void main(String[] args) {
        scenicView = args.length > 0 && args[0].equals("-sv");
        launch(args);
    }


}
