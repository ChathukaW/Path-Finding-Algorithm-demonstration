package Structure;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class firstPage extends Application {

    Button btnTwenty,btnForty;


    @Override
    public void start(Stage primaryStage) {

        Label name = new Label("Path Finder");
        name.setFont(new Font("Arial", 30));

        btnTwenty = new Button("20 X 20");
        btnTwenty.setId("btnTwenty");
        btnTwenty.setPrefWidth(200.0);

        btnForty = new Button("40 X 40");
        btnForty.setId("btnForty");
        btnForty.setPrefWidth(200.0);


        VBox vb = new VBox(20);
        vb.getChildren().addAll(name,btnForty,btnTwenty);

        vb.setAlignment(Pos.CENTER);

        btnTwenty.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
             Grid grid = new Grid();
             try{
                grid.start(new Stage());

             }catch(Exception el){

             }

            }
        });

        btnForty.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                fortyGrid grid = new fortyGrid();

                try{
                    grid.start(new Stage());

                }catch(Exception el){

                }

            }
        });


        primaryStage.setTitle("Path Finder");

        Scene scene = new Scene(vb, 400, 400);
        scene.getStylesheets().add("Styling/Styling.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }


}

