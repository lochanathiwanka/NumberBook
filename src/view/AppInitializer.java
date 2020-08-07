package view;

import controller.StageList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppInitializer extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StageList.mainMenuStage=primaryStage;

        /*Text text = new Text("Hello");
        text.setFont(new Font(40));
        VBox box = new VBox();
        box.getChildren().add(text);
        final Scene scene = new Scene(box,300,250);
        scene.setFill(null);

        primaryStage.setScene(scene);
        primaryStage.show();
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth()-primaryStage.getWidth())/2);
        primaryStage.setY((primScreenBounds.getHeight()-primaryStage.getHeight())/4);*/

        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("MainMenu.fxml"))));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
