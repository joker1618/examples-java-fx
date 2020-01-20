package xxx.joker.examples.javafx.fonts;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xxx.joker.libs.javafx.builder.JfxGridPaneBuilder;

import java.util.List;

import static xxx.joker.libs.core.util.JkStrings.strf;

public class FontsPane extends BorderPane {

    private static final Logger LOG = LoggerFactory.getLogger(FontsPane.class);

    public FontsPane() {
        String str = strf("Actual year is 2019");

        JfxGridPaneBuilder gpBuilder = new JfxGridPaneBuilder();

        List<String> fontNames = Font.getFamilies();
        int row = 0;
        for (String fontName : fontNames) {
            gpBuilder.add(row, 0, fontName);
            Label label = new Label(str);
            label.setFont(Font.font(fontName, 40));
            gpBuilder.add(row, 1, label);
            row++;
        }

        GridPane gp = gpBuilder.createGridPane();
        setCenter(gp);
    }

}

