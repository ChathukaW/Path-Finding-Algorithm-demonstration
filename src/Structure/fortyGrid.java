package Structure;

import  Path.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class fortyGrid extends Application {

    static int size = 40;

    public static Rectangle[][] recGroup = new Rectangle[size][size];

    Label lblX, Ylabel, lStart, lStop, lblX_start, lblY_start, lblX_end, lblY_end, lblCost,lblTime;

    TextField txtX_start, txtY_start, txtX_end, txtY_end, txtCost,txtTime;

    final ToggleGroup group = new ToggleGroup();

    Button btnStart, btnReset;

    Rectangle rectangle;

    boolean isClick;

    Image image1, image2;

    ImagePattern imagePattern1, imagePattern2;

    ImageView imageView1, imageView2;

    RadioButton Manhattan, Chebyshev, Euclidean;


    int capacity;


    @Override
    public void start(Stage primaryStage) {


        GridPane main = new GridPane();
        main.setAlignment(Pos.CENTER);
        main.setPadding(new Insets(10, 0, 0, 5));

        GridPane map = new GridPane();
        map.setAlignment(Pos.CENTER);
        isClick = map.isGridLinesVisible();

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(15);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(200);
        col2.setMinWidth(200);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(200);
        col3.setMinWidth(200);

        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(15);

        ColumnConstraints spaces = new ColumnConstraints();
        spaces.setMinWidth(50);
        spaces.setPrefWidth(50);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(120);
        row1.setMinHeight(100);

        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(200);
        row2.setMinHeight(200);

        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(30);
        row3.setMinHeight(30);

        RowConstraints row4 = new RowConstraints();
        row4.setPrefHeight(50);
        row4.setMinHeight(50);

        RowConstraints row5 = new RowConstraints();
        row5.setPrefHeight(60);
        row5.setMinHeight(60);


        lStart = new Label("Starting Point");
        lStop = new Label("Ending Point");
        lblX_start = new Label("X - axis");
        lblY_start = new Label("Y - axis");
        lblX_end = new Label("X - axis");
        lblY_end = new Label("Y - axis");
        lblCost = new Label("Cost");
        lblTime = new Label("Time");

        lStart.setId("lStart");
        lStop.setId("lStop");
        lblX_start.setId("lblX_start");
        lblY_start.setId("lblY_start");
        lblX_end.setId("lblX_end");
        lblY_end.setId("lblY_end");
        lblCost.setId("lbCost");
        lblTime.setId("lbTime");

        txtX_start = new TextField();
        txtX_end = new TextField();
        txtY_start = new TextField();
        txtY_end = new TextField();
        txtCost = new TextField();
        txtTime = new TextField();

        image1 = new Image("Images/start.png");
        image2 = new Image("Images/end.png");

        imagePattern1 = new ImagePattern(image1);
        imagePattern2 = new ImagePattern(image2);

        btnStart = new Button("Get Path");
        btnStart.setId("btnStart");
        btnStart.setPrefWidth(200.0);

        btnReset = new Button("Reset");
        btnReset.setId("btnReset");
        btnReset.setPrefWidth(200.0);

        Manhattan = new RadioButton("Manhattan");
        Chebyshev = new RadioButton("Chebyshev");
        Euclidean = new RadioButton("Euclidean");

        Manhattan.setUserData("Normal");
        Chebyshev.setUserData("Picture");
        Euclidean.setUserData("Picture");

        Manhattan.setToggleGroup(group);
        Chebyshev.setToggleGroup(group);
        Euclidean.setToggleGroup(group);
        Manhattan.setSelected(true);

        CheckBox cB1 = new CheckBox("With Heuristics");


        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(lStart, lblX_start, txtX_start, lblY_start, txtY_start);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(lStop, lblX_end, txtX_end, lblY_end, txtY_end);

        VBox vBox3 = new VBox();
        vBox2.getChildren().addAll(lblCost, txtCost,lblTime,txtTime);

        VBox buttons = new VBox();
        buttons.getChildren().addAll(Manhattan, Chebyshev, Euclidean);


        if (!isClick) {
            map.setGridLinesVisible(true);
            System.out.println(isClick);
        }

//        for (int i = 1; i < 40; i++) {
//            lblX = new Label("" + i);
//            map.setHalignment(lblX, HPos.CENTER);
//            map.add(lblX, 0, i);
//        }
//
//        for (int j = 1; j < 40; j++) {
//            Ylabel = new Label("" + j);
//            map.setHalignment(Ylabel, HPos.CENTER);
//            map.add(Ylabel, j, 0);
//        }

        for (int i = 1; i < 40; i++) {

            for (int j = 1; j < 40; j++) {

                int struc = Structure.forty[i][j];

                rectangle = new Rectangle(0, 0, 20, 20);
                recGroup[i][j] = rectangle;

                switch (struc) {
                    case 1:
                        rectangle.setFill(Color.rgb(255, 255, 255, 0.6));
                        break;

                    case 2:

                        rectangle.setFill(Color.rgb(185, 185, 185, 0.6));
                        break;

                    case 3:

                        rectangle.setFill(Color.rgb(125, 125, 125, 0.6));
                        break;

                    case 4:

                        rectangle.setFill(Color.rgb(65, 65, 65, 0.6));
                        break;

                    case 5:
                        rectangle.setFill(Color.rgb(0, 0, 0, 0.8));
                        break;
                }
                map.add(rectangle, j, i);

            }
        }

        btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                int Xstart = Integer.valueOf(txtX_start.getText());
                int Ystart = Integer.valueOf(txtY_start.getText());
                int Xend = Integer.valueOf(txtX_end.getText());
                int Yend = Integer.valueOf(txtY_end.getText());

                Logic logic = new Logic();
                if (Manhattan.isSelected()) {
                    logic.setHeuristic("Manhattan");
                }
                if (Chebyshev.isSelected()) {
                    logic.setHeuristic("Chebyshev");
                }
                if (Euclidean.isSelected()) {
                    logic.setHeuristic("Euclidean");
                }

                Long startTime = System.nanoTime();

                fortyPath.run(Xstart, Ystart, Xend, Yend);

                Long stopTime = System.nanoTime();

                Long timeCost = stopTime-startTime;

                txtTime.setText(Long.toString(timeCost)+" Nano Seconds");
                txtCost.setText(Double.toString(fortyPath.total));

                recGroup[Yend][Xend].setFill(imagePattern2);
                imageView2 = new ImageView(image2);

                recGroup[Ystart][Xstart].setFill(imagePattern1);
                imageView1 = new ImageView(image1);
            }
        });

        btnReset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                map.getChildren().clear();


                if (!isClick) {
                    map.setGridLinesVisible(true);
                    System.out.println(isClick);
                }

                for (int i = 1; i < 40; i++) {
                    lblX = new Label("" + i);
                    map.setHalignment(lblX, HPos.CENTER);
                    map.add(lblX, 0, i);
                }

                for (int j = 1; j < 40; j++) {
                    Ylabel = new Label("" + j);
                    map.setHalignment(Ylabel, HPos.CENTER);
                    map.add(Ylabel, j, 0);
                }

                for (int i = 1; i < 40; i++) {

                    for (int j = 1; j < 40; j++) {

                        int struc = Structure.forty[i][j];

                        rectangle = new Rectangle(0, 0, 20, 20);
                        recGroup[i][j] = rectangle;

                        switch (struc) {
                            case 1:
                                rectangle.setFill(Color.rgb(255, 255, 255, 0.6));
                                break;

                            case 2:

                                rectangle.setFill(Color.rgb(185, 185, 185, 0.6));
                                break;

                            case 3:

                                rectangle.setFill(Color.rgb(125, 125, 125, 0.6));
                                break;

                            case 4:

                                rectangle.setFill(Color.rgb(65, 65, 65, 0.6));
                                break;

                            case 5:
                                rectangle.setFill(Color.rgb(0, 0, 0, 0.8));
                                break;
                        }
                        map.add(rectangle, j, i);

                    }
                }
            }
        });

        cB1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (!cB1.isSelected()) {
                    PathFind.setIsSelected(false);
                    Manhattan.setDisable(true);
                    Chebyshev.setDisable(true);
                    Euclidean.setDisable(true);
                } else {
                    PathFind.setIsSelected(true);
                    Manhattan.setDisable(false);
                    Chebyshev.setDisable(false);
                    Euclidean.setDisable(false);
                }
            }
        });


        main.setHalignment(lStart, HPos.CENTER);
        main.setHalignment(lStop, HPos.CENTER);
        main.setHalignment(lblX_start, HPos.CENTER);
        main.setHalignment(lblY_start, HPos.CENTER);
        main.setHalignment(lblX_end, HPos.CENTER);
        main.setHalignment(lblY_end, HPos.CENTER);
        main.setHalignment(lblCost, HPos.CENTER);

        main.setHalignment(txtX_start, HPos.CENTER);
        main.setHalignment(txtX_end, HPos.CENTER);
        main.setHalignment(txtY_start, HPos.CENTER);
        main.setHalignment(txtY_end, HPos.CENTER);
        main.setHalignment(txtCost, HPos.CENTER);

        GridPane.setConstraints(btnStart, 1, 8, 1, 1);
        GridPane.setConstraints(btnReset, 1, 9, 1, 2);
        GridPane.setConstraints(map, 6, 1, 4, 6);
        GridPane.setConstraints(vBox1, 1, 2);
        GridPane.setConstraints(vBox2, 1, 5);
        GridPane.setConstraints(buttons, 1, 6);
        GridPane.setConstraints(cB1, 1, 7);

        main.getChildren().addAll(map, vBox1, vBox2, vBox3, btnStart, buttons, btnReset, cB1);

        primaryStage.setTitle("Path Finder 40x40");

        Scene scene = new Scene(main, 1200, 1055);
        scene.getStylesheets().add("Styling/Styling.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }
}
