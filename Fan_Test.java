
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
public class Fan_Test extends Application{
    @Override
    public void start(Stage primaryStage){
        BorderPane mainPane = new BorderPane();
        FanPane fpane = new FanPane();
        HBox bpane = new HBox();
        Button Pause = new Button("Pause");
        Button Resume = new Button("Resume");
        Button Reverse = new Button("Reverse");

        Pause.setOnAction(e ->{
            fpane.pause();
        });

        Resume.setOnAction(e ->{
            fpane.play();
        });

        Reverse.setOnAction(e ->{
            fpane.reverse();
        });

        bpane.getChildren().addAll(Pause, Resume, Reverse);

        bpane.setSpacing(10);
        bpane.setAlignment(Pos.CENTER);
        mainPane.setTop(bpane);

        Slider sl = new Slider();
        sl.setMax(5);
        sl.setMaxWidth(200);

        mainPane.setBottom(sl);

        sl.setOrientation(Orientation.HORIZONTAL);
        sl.valueProperty().addListener(ov ->{
            fpane.setSpeed(sl.getValue());
        });

        mainPane.setCenter(fpane);

        Scene scene = new Scene(mainPane, 300 , 200);
        primaryStage.setTitle("Ch_6_18");
        primaryStage.setScene(scene);
        primaryStage.show();





    }

}
